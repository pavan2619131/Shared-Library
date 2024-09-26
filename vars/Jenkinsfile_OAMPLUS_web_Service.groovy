
import org.ans.Constants
def call(String projectType='WithParent') {
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
            			break;
				
        case 'RELEASE' :
            			serverName = Constants.ANS_OAMUAT_BRANCH_SERVERNAME
            			buildMailRequire  = Constants.ANS_OAMUAT_BUILD_MAIL_REQUIRE
            			deploymentMailRequire  = Constants.ANS_OAMUAT_DEPLOY_MAIL_REQUIRE
            			buildTeamsNotificationRequire  = Constants.ANS_OAMUAT_BUILD_TEAMS_NOTIFICATION_REQUIRE
            			deploymentTeamsNotificationRequire  = Constants.ANS_OAMUAT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE
            			deployFileName = Constants.ANS_OAMUAT_DEPLOY_FILENAME
            			jenkinsFolderPath = Constants.ANS_OAMUAT_SERVER_JENKINPATH
            			deploymentServerDetails = ANS_OAMUAT_Server
            			deploymentServerPwd = ANS_OAMUAT_Pwd
            			break;
		
			    case 'PRODUCTION' :
		
	      	 		serverName = Constants.ANS_OAMPROD_BRANCH_SERVERNAME
            			buildMailRequire  = Constants.ANS_OAMPROD_BUILD_MAIL_REQUIRE
            			deploymentMailRequire  = Constants.ANS_OAMPROD_DEPLOY_MAIL_REQUIRE
            			buildTeamsNotificationRequire  = Constants.ANS_OAMPROD_BUILD_TEAMS_NOTIFICATION_REQUIRE
            			deploymentTeamsNotificationRequire  = Constants.ANS_OAMPROD_DEPLOY_TEAMS_NOTIFICATION_REQUIRE
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
		
                  steps{
		    script{
			   
			    sourcePath=JENKINS_HOME + "/jobs/oamplus/jobs/" + mainJobName + "/builds/" + BUILD_NUMBER + "/archive/target/*.jar"
			    
			    println(sourcePath)
		    }
		    
		    echo "URL :  ${env.BUILD_URL}"
		    script { 

        sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no " + sourcePath + " " + deploymentServerDetails + ":" + jenkinsFolderPath
	sh "sshpass -p '"+ deploymentServerPwd +"' ssh -tt " + deploymentServerDetails + " 'echo "+ deploymentServerPwd +" | sudo -S sh " + jenkinsFolderPath + "/" + deployFileName + " " + mainJobName + "' &" 


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
    
