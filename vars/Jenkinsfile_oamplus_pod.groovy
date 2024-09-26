

import org.ans.Constants
def call(String projectType='WithParent', String servicePath) {
def SonarClear = true
def SonarDashboardURL = ''
def SonarStatus = Constants.SonarStatus.ByPassed
def BuildSuccessfully = false

def mainJobParts = JOB_NAME.tokenize('/') as String[]  // Multibranch project return project name and branch togather in JOB_NAME so to remove branch name I forced to do this. Generally JOB_NAME will be enough to get project name if it is simple project.
def mainJobName = mainJobParts[1]

def buildMailRequire = ''
def deploymentMailRequire = ''
def buildTeamsNotificationRequire = ''
def deploymentTeamsNotificationRequire = ''
def serverName = ''
def deployFileName = ''
def jenkinsFolderPath =''
def deploymentServerDetails = ''
def deploymentServerPwd = '' 
	
def sourcePath=''
def initPath=''
def additionFolderName=''
def attachedLog=true
	
def sourceDockerfile = ''
def jarName = ''
def dockersh = ''


	switch(BRANCH_NAME.toUpperCase()){
		
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
	

    pipeline {
        agent any
	//options {                 
	//	skipDefaultCheckout true   //Multibranch will automatically pull data from repository at start so if wants to ignore it and wants to do it manually then this line is useful.
	//    }
	//triggers {pollSCM('H/2 * * * *')}
	options {
    		buildDiscarder(logRotator(numToKeepStr: Constants.NUM_TO_KEEP_STR))
  	}
        tools {
            // Install the Maven version configured as "M3" and add it to the path.
            jdk "JDK21"
            maven "Maven1"
        }
	   
	
        stages {
            //stage('checkout'){
            //    steps {
            //        git url: "${env.ANS_GIT_URL}/${env.JOB_NAME}.git", branch: "${env.BRANCH_NAME}", credentialsId: 'newID'
                
            //    }
            //}


		
            stage("Build Project"){
                steps{
			sh "mvn -Dmaven.repo.local=/var/lib/jenkins/repository/" + serverName + " clean package install"
			
                }
                post {
                    // If Maven was able to run the tests, even if some of the test
                    // failed, record the test results and archive the jar file.
                    success {
                        //junit '**/target/surefire-reports/TEST-*.xml'
                        //archiveArtifacts artifacts:'**/*.jar', fingerprint: true
			    echo "MAP TESTING ${env.JOB_NAME} : " + ServicePerformSonar_ANS(mainJobName)
			    echo "Inside Success but outside of script: " + attachedLog
			    
                        script{
                            BuildSuccessfully = true

                            attachedLog = false
				echo "Inside Success : " + attachedLog


                        }
                    }
                    always
                    {

		    
                        script {
                            if(buildMailRequire){
                            //if ("${ANS_Build_Mail_Require}"=="Yes")
				    echo "Inside Always : " + attachedLog
                            emailext attachLog: attachedLog, body: '' + MailBody('buildMailBody','','',SonarStatus), from: 'jnk.pipeline@onlinepsbloans.com', mimeType: 'text/html', replyTo: '', subject: "${Constants.PROJECT_NAMEPNBHL} - " + serverName + " Build Status ${currentBuild.currentResult}: Project name -> ${env.JOB_NAME}", to: Constants.ANS_EMAILTOOAM + ",cc:" + Constants.ANS_EMAILTO_CC  // emailext used to send attachment, simple mail not able to send attachment.
				    
                            }
			    if(buildTeamsNotificationRequire){
				office365ConnectorSend webhookUrl: Constants.ANS_TEAMS_NOTIFICATION_WEBHOOK_OAM,
				message: MailBody('buildMailBody','','',SonarStatus),
				status: "Build ${currentBuild.currentResult}",
				remarks: ""
			    }
                        }
                    }
                }
            }
            stage("Archive Artifacts"){
                when {
                    expression {BuildSuccessfully}
                } 	
                steps{
			script{
				if(projectType.toUpperCase()=="WithParent".toUpperCase())
				    {
					    additionFolderName="service-*/"
				    }
			}
			 
                    archiveArtifacts artifacts:additionFolderName + 'target/service-*.jar, target/*.jar', fingerprint: true
                println(additionFolderName)
                }
                post{
                    failure{
                        script {
                            if(Constants.ANS_BUILD_ARCHIVE_FAILURE_MAIL_REQUIRE){
                                mail bcc: '', body: '' + MailBody('archiveFailurMailBody'), cc: Constants.ANS_EMAILTO_CC, charset: 'UTF-8', from: 'jnk.pipeline@onlinepsbloans.com', mimeType: 'text/html', replyTo: '', subject: "${Constants.PROJECT_NAMEPNBHL} - " + serverName + " Archiving Artifacts : Failed for  ${env.JOB_NAME} (Build Number : ${env.BUILD_NUMBER})", to: Constants.ANS_EMAILTOOAM
                            }
                        }
                    }
                }

            }

	stage('Deploy to Production') {
            when {
                branch 'production' // or the branch you use for production
            }
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
                                submitter: 'pappu_yadav' // Replace with the actual username
                            )
                            
                            if (userInput) {
                                echo 'Deploying to Production...'
				
				sourcePath=JENKINS_HOME + "/jobs/oamplus/jobs/" + mainJobName + "/branches/" + BRANCH_NAME + "/builds/" + BUILD_NUMBER + "/archive/" + additionFolderName + "target/*.jar"
	                        println(sourcePath)

				sourceDockerfile = WORKSPACE +  "/" + mainJobName + "-Dockerfile"
				println(sourceDockerfile)

				    if(projectType.toUpperCase()=="WithParent".toUpperCase()) {
					def applicationProperties = WORKSPACE +  "/service-*/config/*"
						println(applicationProperties)
				        	sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no " + applicationProperties + " " + deploymentServerDetails + ":" + servicePath + mainJobName + "/config/"  // Copy Dockerfile to /apps/services/common/servicename
					}
					else {
					def applicationProperties = WORKSPACE +  "/config/*"
						println(applicationProperties)
				        	sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no " + applicationProperties + " " + deploymentServerDetails + ":" + servicePath + mainJobName + "/config/"  // Copy Dockerfile to /apps/services/common/servicename
					
				   	}
				sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no " + sourcePath + " " + deploymentServerDetails + ":" + servicePath + mainJobName  // Copy jar to /apps/services/common/servicename
	                	sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no " + sourceDockerfile + " " + deploymentServerDetails + ":" + servicePath + mainJobName  // Copy Dockerfile to /apps/services/common/servicename

				def remotessh = "sshpass -p '"+ deploymentServerPwd +"' ssh -tt -o StrictHostKeyChecking=no " + deploymentServerDetails + " 'echo welcome@12345 | sudo -S sh /apps/services/jenkinsPath/oam-plus-docker.sh " + mainJobName + " " + servicePath + "'"
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
    
    
    
