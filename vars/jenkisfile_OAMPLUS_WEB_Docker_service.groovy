
import org.ans.Constants
def call(String projectType='WithParent', String servicePath) {	
def mainJobParts = JOB_NAME.tokenize('/') as String[]  // Multibranch project return project name and branch togather in JOB_NAME so to remove branch name I forced to do this. Generally JOB_NAME will be enough to get project name if it is simple project.
def mainJobName = mainJobParts[1]
	
def SonarStatus = ''
def buildMailRequire = ''
def deploymentMailRequire = ''
def buildTeamsNotificationRequire = ''
def deploymentTeamsNotificationRequire = ''
def serverName = ''
def deployFileName = ''
def jenkinsFolderPath =''
def deploymentServerDetails = ''
def deploymentServerPwd = ''
def attachedLog=true
def sourcePath=''
def sourceDockerfile = ''
def jarName = ''
def dockersh = ''
def approveManager = Constants.ANS_APPROVAL_MANAGER

        pipeline {
        agent any

        tools {
            // Install the Maven version configured as "M3" and add it to the path.
            jdk "JDK21"
            maven "Maven"
	    jfrog "Jfrog-CLI"
        }
		environment {
    		CI = true
    		ARTIFACTORY_ACCESS_TOKEN = credentials('jfogs')
         }
		options {
    		buildDiscarder(logRotator(numToKeepStr: Constants.NUM_TO_KEEP_STR))
  	}
        parameters {
            string(name: 'BranchName', defaultValue: '' , description: '')
        }
        stages {
            
            stage('checkout'){  // Require only first time or anychange happened.

                when {expression {"${env.BUILD_NUMBER}" == 1} }
                steps {
			git url: "https://github.com/capitawrld/${env.JOB_NAME}.git", credentialsId: 'newID'

		}
			
            }
            stage("Build Project")
            {
                steps{ 
                    sh "mvn -Dmaven.repo.local=/var/lib/jenkins/repository/OAMPLUSSIT clean package install"
                    //sh "mvn -Dmaven.repo.local=/var/lib/jenkins/repository/" + "${env.BRANCH_NAME}".toUpperCase() + " clean package install" This is not require bcoz of master branch
                    //sh "mvn -Dmaven.repo.local=/var/lib/jenkins/repository/" + serverName + " clean package install"
                }
                post {
                    // If Maven was able to run the tests, even if some of the test
                    // failed, record the test results and archive the jar file.
                    success {
                        //junit '**/target/surefire-reports/TEST-*.xml'
                        archiveArtifacts 'target/*.jar'

                        echo "Branch Name ---> ${params.BranchName}"
                        
                        script{
                            
                            attachedLog = false
                            
                        switch("${params.BranchName}".toUpperCase()){
			   
			  case 'DEVELOPMENT' :
    			  case 'DEVELOP' :
            			serverName = Constants.ANS_OAMPLUSSIT_BRANCH_SERVERNAME
            			buildMailRequire  = Constants.ANS_OAMPLUSSIT_BUILD_MAIL_REQUIRE
            			deploymentMailRequire  = Constants.ANS_OAMPLUSSIT_DEPLOY_MAIL_REQUIRE
            			buildTeamsNotificationRequire  = Constants.ANS_OAMPLUSSIT_BUILD_TEAMS_NOTIFICATION_REQUIRE
            			deploymentTeamsNotificationRequire  = Constants.ANS_OAMPLUSSIT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE
            			deployFileName = Constants.ANS_OAMPLUSSIT_DEPLOY_FILENAME
            			jenkinsFolderPath = Constants.ANS_OAMPLUSSIT_SERVER_JENKINPATH
            			deploymentServerDetails = ANS_OAMPLUSSIT_Server
            			deploymentServerPwd = ANS_OAMPLUSSIT_Pwd
				deploymentServerIP = ANS_OAMPLUSSIT_Server_IP
            			break;

		case 'UAT' :
			serverName = Constants.ANS_OAMPLUSUAT_BRANCH_SERVERNAME
			buildMailRequire = Constants.ANS_OAMPLUSUAT_BUILD_MAIL_REQUIRE
			deploymentMailRequire = Constants.ANS_OAMPLUSUAT_DEPLOY_MAIL_REQUIRE
			buildTeamsNotificationRequire  = Constants.ANS_OAMPLUSUAT_BUILD_TEAMS_NOTIFICATION_REQUIRE
			deploymentTeamsNotificationRequire  = Constants.ANS_OAMPLUSUAT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE
			deployFileName = Constants.ANS_OAMPLUSUAT_DEPLOY_FILENAME
			jenkinsFolderPath = Constants.ANS_OAMPLUSUAT_SERVER_JENKINPATH
			deploymentServerDetails = ANS_OAMPLUSUAT_Server
			deploymentServerPwd = ANS_OAMPLUSUAT_Pwd
	        	deploymentServerIP = ANS_OAMPLUSUAT_Server_IP
			break;
				
        	case 'PRODUCTION' :
			serverName = Constants.ANS_OAMPLUSPRODUCTION_BRANCH_SERVERNAME
			buildMailRequire = Constants.ANS_OAMPLUSPRODUCTION_BUILD_MAIL_REQUIRE
			deploymentMailRequire = Constants.ANS_OAMPLUSPRODUCTION_DEPLOY_MAIL_REQUIRE
			buildTeamsNotificationRequire  = Constants.ANS_OAMPLUSPRODUCTION_BUILD_TEAMS_NOTIFICATION_REQUIRE
			deploymentTeamsNotificationRequire  = Constants.ANS_OAMPLUSPRODUCTION_DEPLOY_TEAMS_NOTIFICATION_REQUIRE
			deployFileName = Constants.ANS_OAMPLUSPRODUCTION_DEPLOY_FILENAME
			jenkinsFolderPath = Constants.ANS_OAMPLUSPRODUCTION_SERVER_JENKINPATH
			deploymentServerDetails = ANS_OAMPLUSPRODUCTION_Server
			deploymentServerPwd = ANS_OAMPLUSPRODUCTION_Pwd
			break;
				
                        }
                        }
                    }
                    always
                    {
                        echo "Build successfully"
                         script {
                            if(buildMailRequire){
                                //mail bcc: '', body: '' + MailBody('buildMailBody'), cc: Constants.ANS_EMAILTO_CC, charset: 'UTF-8', from: 'jnk.pipeline@onlinepsbloans.com', mimeType: 'text/html', replyTo: '', subject: "(Web Project) Build Status ${currentBuild.currentResult}: Project name -> ${env.JOB_NAME}", to: Constants.ANS_EMAILTOOAM    // from email id is not mandatroy
                                emailext attachLog: '' + attachedLog, body: '' + MailBody('buildMailBody'), from: 'jnk.pipeline@onlinepsbloans.com', mimeType: 'text/html', replyTo: '', subject: "Build Status ${currentBuild.currentResult}: Project name -> ${env.JOB_NAME}", to: Constants.ANS_EMAILTOOAM + ",cc:" + Constants.ANS_EMAILTO_CC  // emailext used to send attachment, simple mail not able to send attachment.
                            }
                        }
                    }
                   
    	
                }
            }
              
	       stage ("Depolyment on Server") {

		       when {
			      expression { params.BranchName ==~ /(development|develop|master|uat)/ } 
                	//branch 'dev-pnb-egst'
            		}
		
                  steps{
		    script{
			   
			    sourcePath=JENKINS_HOME + "/jobs/oamplus/jobs/" + mainJobName + "/builds/" + BUILD_NUMBER + "/archive/target/*.jar"
			    
			    println(sourcePath)
		    }
		    
		    echo "URL :  ${env.BUILD_URL}"
		    script { 
			   sourceDockerfile = WORKSPACE +  "/" + mainJobName + "-Dockerfile"
			println(sourceDockerfile)
def applicationProperties = WORKSPACE +  "/src/main/resources/application.properties"
println(applicationProperties)
sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no " + applicationProperties + " " + deploymentServerDetails + ":" + servicePath + mainJobName + "/config/"  // Copy Dockerfile to /apps/services/common/servicename
		
sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no " + sourcePath + " " + deploymentServerDetails + ":" + servicePath + mainJobName
sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no " + sourceDockerfile + " " + deploymentServerDetails + ":" + servicePath + mainJobName  // Copy Dockerfile to /apps/services/common/servicename

def remotessh = "sshpass -p Welcome@12345 ssh -tt -o StrictHostKeyChecking=no " + deploymentServerDetails + " 'echo Welcome@12345 | sudo -S sh /apps/services/jenkinsPath/oam-plus-docker.sh " + mainJobName + " " + servicePath + "'"
sh "${remotessh}"
			   
 		// 	def remote = [:]
			// remote.name = "${serverName}"
			// remote.host = "${deploymentServerIP}"
			// remote.user = 'oampipeline'
			// remote.password = "${deploymentServerPwd}"
			// remote.pty = true
			// remote.allowAnyHosts = true
			
		 // // sshCommand remote: remote, sudo : true, command: "sudo -S sh ${jenkinsFolderPath}/docker.sh ${mainJobName} ${servicePath}"   // Run docker.sh script on Remote server
			//  sshCommand remote: remote, sudo : true, command: "sudo -S sh ${jenkinsFolderPath}/oam-plus-docker.sh ${mainJobName} ${servicePath}"   // Run docker.sh script on Remote server
			       
		    }
		    
                }
                post{
                    always
                    {
                        script{
                            if (deploymentMailRequire){
                                mail bcc: '', body: '' + MailBody('deploymentMailBody','',serverName), cc:  Constants.ANS_EMAILTO_CC, charset: 'UTF-8', from: 'jnk.pipeline@onlinepsbloans.com', mimeType: 'text/html', replyTo: '', subject: "${currentBuild.currentResult} : Deployment for " + mainJobName + " on " + serverName + " server is ${currentBuild.currentResult}" , to: Constants.ANS_EMAILTOOAM
                            }
			    if(deploymentTeamsNotificationRequire){
				office365ConnectorSend webhookUrl: Constants.ANS_TEAMS_NOTIFICATION_WEBHOOK_OAM,
				message: MailBody('deploymentMailBody','',SonarStatus),
				status: "Deployment ${currentBuild.currentResult}",
				remarks: ""
			    }
                        }
                        
                        
                    }
                }  
	                              
            }


		stage('Deploy to Production') {

	when {
             expression {"${params.BranchName}".toUpperCase() == Constants.ANS_OAMPLUSPRODUCTION_PERFORM_BRANCH.toUpperCase() && Constants.ANS_OAMPLUSPRODUCTION_TEST_PERFORM }
        } 
            // when {
            //     branch 'production' // or the branch you use for production
            // }
            steps {
                script {
                    try {
                        timeout(time: 5, unit: 'MINUTES') {
                            def userInput = input(
                                id: 'userInput', 
                                message: 'Approve Production Deployment?', 
                                parameters: [
                                    booleanParam(defaultValue: false, description: 'Approve deployment?', name: 'approve')
                                ],
                                submitter: "${approveManager}" // Replace with the actual username
                            )
                            
                            if (userInput) {
                                echo 'Deploying to Production...'

				sourcePath=JENKINS_HOME + "/jobs/oamplus/jobs/" + mainJobName + "/builds/" + BUILD_NUMBER + "/archive/target/*.jar"
				    	println(sourcePath)
				sourceDockerfile = WORKSPACE +  "/" + mainJobName + "-Dockerfile"
					println(sourceDockerfile)
				def applicationProperties = WORKSPACE +  "/src/main/resources/application.properties"
					println(applicationProperties)
				sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no " + applicationProperties + " " + deploymentServerDetails + ":" + servicePath + mainJobName + "/config/"  // Copy Dockerfile to /apps/services/common/servicename
						
				sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no " + sourcePath + " " + deploymentServerDetails + ":" + servicePath + mainJobName
				sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no " + sourceDockerfile + " " + deploymentServerDetails + ":" + servicePath + mainJobName  // Copy Dockerfile to /apps/services/common/servicename
				
				def remotessh = "sshpass -p welcome@12345 ssh -tt -o StrictHostKeyChecking=no " + deploymentServerDetails + " 'echo welcome@12345 | sudo -S sh /apps/services/jenkinsPath/oam-plus-docker.sh " + mainJobName + " " + servicePath + "'"
				sh "${remotessh}"


				    
                            } else {
                                error 'Deployment to Production was not approved.'
                            }
                        }
                    } catch (err) {
                        echo 'Timeout reached or input was not approved.'
                        error 'Deployment to Production was not approved due to timeout or denial.'
                    }
                }
            }
	    post{
                    always
                    {
                        script{
                            if (deploymentMailRequire){
                                mail bcc: '', body: '' + MailBody('deploymentMailBody','',serverName), cc:  Constants.ANS_EMAILTO_CC, charset: 'UTF-8', from: 'jnk.pipeline@onlinepsbloans.com', mimeType: 'text/html', replyTo: '', subject: "${currentBuild.currentResult} : Deployment for " + mainJobName + " on " + serverName + " server is ${currentBuild.currentResult}" , to: Constants.ANS_EMAILTOOAM
                            }
			    if(deploymentTeamsNotificationRequire){
				office365ConnectorSend webhookUrl: Constants.ANS_TEAMS_NOTIFICATION_WEBHOOK_OAM,
				message: MailBody('deploymentMailBody','',SonarStatus),
				status: "Deployment ${currentBuild.currentResult}",
				remarks: ""
			    }
                        }
                        
                        
                    }
                }
        }

		
    
            
        }
    }

}

