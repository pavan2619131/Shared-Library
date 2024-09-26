

// import org.ans.Constants
// def call(String projectType='WithParent', String servicePath) {
// def SonarClear = true
// def SonarDashboardURL = ''
// def SonarStatus = Constants.SonarStatus.ByPassed
// def BuildSuccessfully = false

// def mainJobParts = JOB_NAME.tokenize('/') as String[]  // Multibranch project return project name and branch togather in JOB_NAME so to remove branch name I forced to do this. Generally JOB_NAME will be enough to get project name if it is simple project.
// def mainJobName = mainJobParts[1]

// def buildMailRequire = ''
// def deploymentMailRequire = ''
// def buildTeamsNotificationRequire = ''
// def deploymentTeamsNotificationRequire = ''
// def serverName = ''
// def deployFileName = ''
// def jenkinsFolderPath =''
// def deploymentServerDetails = ''
// def deploymentServerPwd = '' 
	
// def sourcePath=''
// def initPath=''
// def additionFolderName=''
// def attachedLog=true
	
// def sourceDockerfile = ''
// def jarName = ''
// def dockersh = ''


// 	switch(BRANCH_NAME.toUpperCase()){
		
// 		case 'DEVELOPMENT' :
// 		case 'WITHS3APIGATEWAY' :
// 		case 'DEVELOPMENT-GO-LAYER7':
// 		case 'DEV' :
//             			serverName = Constants.ANS_OAMSIT_BRANCH_SERVERNAME
//             			buildMailRequire  = Constants.ANS_OAMSIT_BUILD_MAIL_REQUIRE
//             			deploymentMailRequire  = Constants.ANS_OAMSIT_DEPLOY_MAIL_REQUIRE
//             			buildTeamsNotificationRequire  = Constants.ANS_OAMSIT_BUILD_TEAMS_NOTIFICATION_REQUIRE
//             			deploymentTeamsNotificationRequire  = Constants.ANS_OAMSIT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE
//             			deployFileName = Constants.ANS_OAMSIT_DEPLOY_FILENAME
//             			jenkinsFolderPath = Constants.ANS_OAMSIT_SERVER_JENKINPATH
//             			deploymentServerDetails = ANS_OAMPLUSSIT_Server
//             			deploymentServerPwd = ANS_OAMPLUSSIT_Pwd
//             			break;
// 		case 'RELEASE' :
// 		case 'UAT-SIDBI' :
// 		case 'RELEASE-GO-LAYER7' :
// 		case 'QA' :
// 		case 'DEVELOPMENT-API':
// 		case 'OAM-RELEASE' :
		
//             			serverName = Constants.ANS_OAMUAT_BRANCH_SERVERNAME
//             			buildMailRequire  = Constants.ANS_OAMUAT_BUILD_MAIL_REQUIRE
//             			deploymentMailRequire  = Constants.ANS_OAMUAT_DEPLOY_MAIL_REQUIRE
//             			buildTeamsNotificationRequire  = Constants.ANS_OAMUAT_BUILD_TEAMS_NOTIFICATION_REQUIRE
//             			deploymentTeamsNotificationRequire  = Constants.ANS_OAMUAT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE
//             			deployFileName = Constants.ANS_OAMUAT_DEPLOY_FILENAME
//             			jenkinsFolderPath = Constants.ANS_OAMUAT_SERVER_JENKINPATH
//             			deploymentServerDetails = ANS_OAMUAT_Server
//             			deploymentServerPwd = ANS_OAMUAT_Pwd
//             			break;
		
// 		case 'PRODUCTION' :
		
// 	      	 		serverName = Constants.ANS_OAMPROD_BRANCH_SERVERNAME
//             			buildMailRequire  = Constants.ANS_OAMPROD_BUILD_MAIL_REQUIRE
//             			deploymentMailRequire  = Constants.ANS_OAMPROD_DEPLOY_MAIL_REQUIRE
//             			buildTeamsNotificationRequire  = Constants.ANS_OAMPROD_BUILD_TEAMS_NOTIFICATION_REQUIRE
//             			deploymentTeamsNotificationRequire  = Constants.ANS_OAMPROD_DEPLOY_TEAMS_NOTIFICATION_REQUIRE
//             			break;
// 	}
	

//     pipeline {
//         agent any
// 	//options {                 
// 	//	skipDefaultCheckout true   //Multibranch will automatically pull data from repository at start so if wants to ignore it and wants to do it manually then this line is useful.
// 	//    }
// 	triggers {pollSCM('H/2 * * * *')}
// 	options {
//     		buildDiscarder(logRotator(numToKeepStr: Constants.NUM_TO_KEEP_STR))
//   	}
//         tools {
//             // Install the Maven version configured as "M3" and add it to the path.
//           //  jdk "JDK"
// 		 jdk "JDK8"
//             maven "Maven"
// 	    jfrog "Jfrog-CLI"
//         }
// 	    environment {
//     		CI = true
//     		ARTIFACTORY_ACCESS_TOKEN = credentials('jfogs')
//          }
	
//         stages {
//             //stage('checkout'){
//             //    steps {
//             //        git url: "${env.ANS_GIT_URL}/${env.JOB_NAME}.git", branch: "${env.BRANCH_NAME}", credentialsId: 'newID'
                
//             //    }
//             //}
//             stage ("SonarQube analysis") {
//                 when {
//                     expression {"${env.BRANCH_NAME}".toUpperCase() == Constants.ANS_SONAR_PERFORM_BRANCHOAM.toUpperCase() && Constants.ANS_SONAR_TEST_PERFORM && ServicePerformSonar_ANS(mainJobName)}
//                 }  
//                 options {
//                     timeout(time: 5, unit: 'MINUTES')
//                     retry(2)
//                 }
//                 environment {
//                         SCANNER_HOME = tool 'MySonarScanner'
//                 }
//                 steps {
//                     script {
//                         STAGE_NAME = "SonarQube analysis"
                
//                         withSonarQubeEnv('SonarQubeServer') {
//                             sh "${SCANNER_HOME}/bin/sonar-scanner"
//                             //sh "mvn clean package sonar:sonar"  // This wont consider sonar-project.properties file
//                            // def props = readProperties  file: '.scannerwork/report-task.txt'
//                           //  SonarDashboardURL =  props['dashboardUrl']
//                         }
            
//                         //echo "ANS_SONAR_TEST_PERFORM : " + Constants.ANS_SONAR_TEST_PERFORM
//                         //echo "ANS_SONAR_FAILURE_MAIL_REQUIRE : " + Constants.ANS_SONAR_FAILURE_MAIL_REQUIRE
//                        waitForQualityGate abortPipeline: true   // temparory we have commented this line otherwise this should be aborted and should not build service.
// 			    //waitForQualityGate abortPipeline: false

//                     }
//                 }
        
//                 post {
//                     failure {
//                             script{
//                                 if (Constants.ANS_SONAR_FAILURE_MAIL_REQUIRE){
//                                     mail bcc: '', body: '' + MailBody('sonarFailureMailBody', SonarDashboardURL), cc: Constants.ANS_EMAILTO_CC, charset: 'UTF-8', from: 'jnk.pipeline@onlinepsbloans.com', mimeType: 'text/html', replyTo: '', subject: "${Constants.PROJECT_NAMEOAM} - " + serverName + ' : ABORTED - Sonar Testing Fail', to: Constants.ANS_EMAILTOOAM     // from email id not mandatory
//                                 }
//                             }
//                     }
//                     success {
//                         script{
//                             SonarStatus = Constants.SonarStatus.Passed
//                         }
//                     }
//                 }                               
//             }

		
//             stage("Build Project"){
//                 steps{
// 			//sh "mvn -Dmaven.test.failure.ignore=true clean install"		
//                     //sh "mvn -Dmaven.repo.local=/var/jenkins_home/" + "${env.BRANCH_NAME}".toUpperCase() + " clean package install"
// 			sh "mvn -Dmaven.repo.local=/var/lib/jenkins/repository/" + serverName + " clean package install"
			
//                 }
//                 post {
//                     // If Maven was able to run the tests, even if some of the test
//                     // failed, record the test results and archive the jar file.
//                     success {
//                         //junit '**/target/surefire-reports/TEST-*.xml'
//                         //archiveArtifacts artifacts:'**/*.jar', fingerprint: true
// 			    echo "MAP TESTING ${env.JOB_NAME} : " + ServicePerformSonar_ANS(mainJobName)
// 			    echo "Inside Success but outside of script: " + attachedLog
			    
//                         script{
//                             BuildSuccessfully = true

//                             attachedLog = false
// 				echo "Inside Success : " + attachedLog


//                         }
//                     }
//                     always
//                     {

//                         script {
//                             if(buildMailRequire){
//                             //if ("${ANS_Build_Mail_Require}"=="Yes")
// 				    echo "Inside Always : " + attachedLog
//                             emailext attachLog: attachedLog, body: '' + MailBody('buildMailBody','','',SonarStatus), from: 'jnk.pipeline@onlinepsbloans.com', mimeType: 'text/html', replyTo: '', subject: "${Constants.PROJECT_NAMEOAM} - " + serverName + " Build Status ${currentBuild.currentResult}: Project name -> ${env.JOB_NAME}", to: Constants.ANS_EMAILTOOAM + ",cc:" + Constants.ANS_EMAILTO_CC  // emailext used to send attachment, simple mail not able to send attachment.
				    
//                             }
// 			    if(buildTeamsNotificationRequire){
// 				office365ConnectorSend webhookUrl: Constants.ANS_TEAMS_NOTIFICATION_WEBHOOK_PNBHL,
// 				message: MailBody('buildMailBody','','',SonarStatus),
// 				status: "Build ${currentBuild.currentResult}",
// 				remarks: ""
// 			    }
//                         }
//                     }
//                 }
//             }
//             stage("Archive Artifacts"){
//                 when {
//                     expression {BuildSuccessfully}
//                 } 	
//                 steps{
// 			script{
// 				if(projectType.toUpperCase()=="WithParent".toUpperCase())
// 				    {
// 					    additionFolderName="service-*/"
// 				    }
// 			}
			 
//                     archiveArtifacts artifacts:additionFolderName + 'target/service-*.jar, target/*.jar', fingerprint: true
//                 println(additionFolderName)
//                 }
//                 post{
//                     failure{
//                         script {
//                             if(Constants.ANS_BUILD_ARCHIVE_FAILURE_MAIL_REQUIRE){
//                                 mail bcc: '', body: '' + MailBody('archiveFailurMailBody'), cc: Constants.ANS_EMAILTO_CC, charset: 'UTF-8', from: 'jnk.pipeline@onlinepsbloans.com', mimeType: 'text/html', replyTo: '', subject: "${Constants.PROJECT_NAMEOAM} - " + serverName + " Archiving Artifacts : Failed for  ${env.JOB_NAME} (Build Number : ${env.BUILD_NUMBER})", to: Constants.ANS_EMAILTOOAM
//                             }
//                         }
//                     }
//                 }

//             }

// 	      stage ("Depolyment on Server") {
//                   steps{
// 		    script{
			   
// 			    sourcePath=JENKINS_HOME + "/jobs/oam/jobs/" + mainJobName + "/branches/" + BRANCH_NAME + "/builds/" + BUILD_NUMBER + "/archive/" + additionFolderName + "target/*.jar"
			   
// 			    println(sourcePath)
// 		    }
		    
// 		    echo "URL :  ${env.BUILD_URL}"
// 		    script {

// if (mainJobName == 'service-cbdt' || mainJobName == 'service-udhyam') {
// sourceDockerfile = WORKSPACE +  "/" + mainJobName + "-oam-Dockerfile"
// println(sourceDockerfile)
// }
// else {
// 	sourceDockerfile = WORKSPACE +  "/" + mainJobName + "-Dockerfile"
// 	println(sourceDockerfile)
// }


// 	sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no " + sourcePath + " " + deploymentServerDetails + ":" + servicePath + mainJobName  // Copy jar to /apps/services/common/servicename
// 	sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no " + sourceDockerfile + " " + deploymentServerDetails + ":" + servicePath + mainJobName  // Copy Dockerfile to /apps/services/common/servicename
// 	def remotessh = "sshpass -p Welcome@12345 ssh -tt -o StrictHostKeyChecking=no " + deploymentServerDetails + " 'echo Welcome@12345 | sudo -S sh /apps/services/jenkinsPath/docker.sh " + mainJobName + " " + servicePath + "'"
// 	sh "${remotessh}"
			    
// 	//sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no " + sourcePath + " " + deploymentServerDetails + ":" + jenkinsFolderPath
// 	//sh "sshpass -p '"+ deploymentServerPwd +"' ssh -tt " + deploymentServerDetails + " 'echo "+ deploymentServerPwd +" | sudo -S sh " + jenkinsFolderPath + "/" + deployFileName + " " + mainJobName + "' &" 

// 		    }
		    
//                 }
//                 post{
// 		  failure{
//                         script {
//                              if(Constants.ANS_BUILD_ARCHIVE_FAILURE_MAIL_REQUIRE){
//                                 mail bcc: '', body: '' + MailBody('archiveFailurMailBody'), cc: Constants.ANS_EMAILTO_CC, charset: 'UTF-8', from: 'jnk.pipeline@onlinepsbloans.com', mimeType: 'text/html', replyTo: '', subject: "${Constants.PROJECT_NAMEOAM} - " + serverName + " : Moving JAR to server Failed for  ${env.JOB_NAME} (Build Number : ${env.BUILD_NUMBER})", to: Constants.ANS_EMAILTOOAM
//                              }
//                         }
//                     }
//                     always
//                     {
//                         script{
//                             if (deploymentMailRequire){
// 					mail bcc: '', body: '' + MailBody('deploymentMailBody','',serverName), cc:  Constants.ANS_EMAILTO_CC, charset: 'UTF-8', from: 'jnk.pipeline@onlinepsbloans.com', mimeType: 'text/html', replyTo: '', subject: "${Constants.PROJECT_NAMEOAM} - " + serverName + " : Deploy and build docker images for " + mainJobName + " on " + serverName + " server is ${currentBuild.currentResult}" , to: Constants.ANS_EMAILTOOAM
//                             }
// 			    if(deploymentTeamsNotificationRequire){
// 				office365ConnectorSend webhookUrl: Constants.ANS_TEAMS_NOTIFICATION_WEBHOOK_OAM,
// 				message: MailBody('deploymentMailBody','',SonarStatus),
// 				status: "Deployment ${currentBuild.currentResult}",
// 				remarks: ""
// 			    }
//                         }
                        
                        
//                     }
//                 }  
	                              
//             }


		
//             }
		
	
//         }
//     }
    
    
    
