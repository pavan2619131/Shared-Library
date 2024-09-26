 
//     import org.ans.Constants
// def call(String projectType='WithParent', String servicePath, int port, String requestsCpu, String requestsMemory, int minReplicas, int maxReplicas,String healthcheckPath='') {
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
// def approveManager = Constants.ANS_APPROVAL_MANAGER


// 	switch(BRANCH_NAME.toUpperCase()){
		
// 		case 'DEVELOPMENT' :
//     		case 'DEVELOP' :
// 		case 'MASTER' :

//             			serverName = Constants.ANS_OAMPLUSSIT_BRANCH_SERVERNAME
//             			buildMailRequire  = Constants.ANS_OAMPLUSSIT_BUILD_MAIL_REQUIRE
//             			deploymentMailRequire  = Constants.ANS_OAMPLUSSIT_DEPLOY_MAIL_REQUIRE
//             			buildTeamsNotificationRequire  = Constants.ANS_OAMPLUSSIT_BUILD_TEAMS_NOTIFICATION_REQUIRE
//             			deploymentTeamsNotificationRequire  = Constants.ANS_OAMPLUSSIT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE
//             			deployFileName = Constants.ANS_OAMPLUSSIT_DEPLOY_FILENAME
//             			jenkinsFolderPath = Constants.ANS_OAMPLUSSIT_SERVER_JENKINPATH
//             			deploymentServerDetails = ANS_OAMPLUSSIT_Server
//             			deploymentServerPwd = ANS_OAMPLUSSIT_Pwd
//                                 deploymentServerIP = ANS_OAMPLUSSIT_Server_IP
//             			break;

// 		 case 'UAT' :
// 			serverName = Constants.ANS_OAMPLUSUAT_BRANCH_SERVERNAME
// 			buildMailRequire = Constants.ANS_OAMPLUSUAT_BUILD_MAIL_REQUIRE
// 			deploymentMailRequire = Constants.ANS_OAMPLUSUAT_DEPLOY_MAIL_REQUIRE
// 			buildTeamsNotificationRequire  = Constants.ANS_OAMPLUSUAT_BUILD_TEAMS_NOTIFICATION_REQUIRE
// 			deploymentTeamsNotificationRequire  = Constants.ANS_OAMPLUSUAT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE
// 			deployFileName = Constants.ANS_OAMPLUSUAT_DEPLOY_FILENAME
// 			jenkinsFolderPath = Constants.ANS_OAMPLUSUAT_SERVER_JENKINPATH
// 			deploymentServerDetails = ANS_OAMPLUSUAT_Server
// 			deploymentServerPwd = ANS_OAMPLUSUAT_Pwd
// 	        	deploymentServerIP = ANS_OAMPLUSUAT_Server_IP
// 			break;

// 		case 'PRODUCTION' :
// 			serverName = Constants.ANS_OAMPLUSPRODUCTION_BRANCH_SERVERNAME
// 			buildMailRequire = Constants.ANS_OAMPLUSPRODUCTION_BUILD_MAIL_REQUIRE
// 			deploymentMailRequire = Constants.ANS_OAMPLUSPRODUCTION_DEPLOY_MAIL_REQUIRE
// 			buildTeamsNotificationRequire  = Constants.ANS_OAMPLUSPRODUCTION_BUILD_TEAMS_NOTIFICATION_REQUIRE
// 			deploymentTeamsNotificationRequire  = Constants.ANS_OAMPLUSPRODUCTION_DEPLOY_TEAMS_NOTIFICATION_REQUIRE
// 			deployFileName = Constants.ANS_OAMPLUSPRODUCTION_DEPLOY_FILENAME
// 			jenkinsFolderPath = Constants.ANS_OAMPLUSPRODUCTION_SERVER_JENKINPATH
// 			deploymentServerDetails = ANS_OAMPLUSPRODUCTION_Server
// 			deploymentServerPwd = ANS_OAMPLUSPRODUCTION_Pwd
// 			break;
		

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
//             jdk "JDK21"
//             maven "Maven1"
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
//                  when {
//                          expression {("${env.BRANCH_NAME}".toUpperCase() == Constants.ANS_SONAR_PERFORM_BRANCHOAMPLUS.toUpperCase() || "${env.BRANCH_NAME}".toUpperCase() == Constants.ANS_SONAR_PERFORM_BRANCHOAMPLUS1.toUpperCase()) && Constants.ANS_SONAR_TEST_PERFORM && ServicePerformSonar_ANS(mainJobName)}
//                     }  
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
//                            // SonarDashboardURL =  props['dashboardUrl']
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
//                                     mail bcc: '', body: '' + MailBody('sonarFailureMailBody', SonarDashboardURL), cc: Constants.ANS_EMAILTO_CC, charset: 'UTF-8', from: 'jnk.pipeline@onlinepsbloans.com', mimeType: 'text/html', replyTo: '', subject: 'ABORTED : Sonar Testing Fail', to: Constants.ANS_EMAILTOOAM     // from email id not mandatory
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
//                             emailext attachLog: attachedLog, body: '' + MailBody('buildMailBody','','',SonarStatus), from: 'jnk.pipeline@onlinepsbloans.com', mimeType: 'text/html', replyTo: '', subject: "${Constants.PROJECT_NAMEPNBHL} - " + serverName + " Build Status ${currentBuild.currentResult}: Project name -> ${env.JOB_NAME}", to: Constants.ANS_EMAILTOOAM + ",cc:" + Constants.ANS_EMAILTO_CC  // emailext used to send attachment, simple mail not able to send attachment.
				    
//                             }
// 			    if(buildTeamsNotificationRequire){
// 				office365ConnectorSend webhookUrl: Constants.ANS_TEAMS_NOTIFICATION_WEBHOOK_OAM,
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
//                                 mail bcc: '', body: '' + MailBody('archiveFailurMailBody'), cc: Constants.ANS_EMAILTO_CC, charset: 'UTF-8', from: 'jnk.pipeline@onlinepsbloans.com', mimeType: 'text/html', replyTo: '', subject: "${Constants.PROJECT_NAMEPNBHL} - " + serverName + " Archiving Artifacts : Failed for  ${env.JOB_NAME} (Build Number : ${env.BUILD_NUMBER})", to: Constants.ANS_EMAILTOOAM
//                             }
//                         }
//                     }
//                 }

//             }

// 	      stage ("Depolyment on Server & Build Docker Images") {
// 		       when {
// 			      expression { env.BRANCH_NAME ==~ /(development|develop|master|uat)/ } 
//             		}
//                   steps{
// 		    script{
			   
// 			    sourcePath=JENKINS_HOME + "/jobs/oamplus/jobs/" + mainJobName + "/branches/" + BRANCH_NAME + "/builds/" + BUILD_NUMBER + "/archive/" + additionFolderName + "target/*.jar"
			    
// 			    println(sourcePath)
// 		    }
		    
// 		    echo "URL :  ${env.BUILD_URL}"
//        		    script{
// 			sourceDockerfile = WORKSPACE +  "/" + mainJobName + "-Dockerfile"
// 			println(sourceDockerfile)
			
// 		if(projectType.toUpperCase()=="WithParent".toUpperCase()) {
// 		def applicationProperties = WORKSPACE +  "/service-*/config/*"
// 		println(applicationProperties)
// 	        sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no -r " + applicationProperties + " " + deploymentServerDetails + ":" + servicePath + mainJobName + "/config/"  // Copy Dockerfile to /apps/services/common/servicename
// 		}
// 		else {
// 		def applicationProperties = WORKSPACE +  "/config/*"
// 		println(applicationProperties)
// 	        sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no -r " + applicationProperties + " " + deploymentServerDetails + ":" + servicePath + mainJobName + "/config/"  // Copy Dockerfile to /apps/services/common/servicename
		
// 		}
			
// 			sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no " + sourcePath + " " + deploymentServerDetails + ":" + servicePath + mainJobName  // Copy jar to /apps/services/common/servicename
// 	                sh "sshpass -p '"+ deploymentServerPwd +"' scp -o StrictHostKeyChecking=no " + sourceDockerfile + " " + deploymentServerDetails + ":" + servicePath + mainJobName  // Copy Dockerfile to /apps/services/common/servicename

// 			def remotessh = "sshpass -p Welcome@12345 ssh -tt -o StrictHostKeyChecking=no " + deploymentServerDetails + " 'echo Welcome@12345 | sudo -S sh /apps/services/jenkinsPath/oam-plus-docker.sh " + mainJobName + " " + servicePath + "'"
// 			sh "${remotessh}"

 
//                     }

		    
//                 }
//                 post{
//                     always
//                     {
//                         script{
//                             if (deploymentMailRequire){
//                                 mail bcc: '', body: '' + MailBody('deploymentMailBody','',serverName), cc:  Constants.ANS_EMAILTO_CC, charset: 'UTF-8', from: 'jnk.pipeline@onlinepsbloans.com', mimeType: 'text/html', replyTo: '', subject: "${currentBuild.currentResult} : Deployment for " + mainJobName + " on " + serverName + " server is ${currentBuild.currentResult}" , to: Constants.ANS_EMAILTOOAM
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


// 			    stage ("K8S Deployment") {
//                 // when {
//                 //     expression {"${env.BRANCH_NAME}".toUpperCase() == Constants.ANS_K8S_PERFORM_BRANCH.toUpperCase() && Constants.ANS_K8S_TEST_PERFORM }
//                 // }  
                
//                 steps {
// 			withKubeCredentials(kubectlCredentials: [[caCertificate: '', clusterName: 'PROD-OAM', contextName: '', credentialsId: 'Kubernetes', namespace: 'production', serverUrl: 'https://A463D3B1FE583612E2610F26A74C5D89.gr7.ap-south-1.eks.amazonaws.com']]) {

//                   script {
// // This condition for specific sevices which is used Persistent Volume.
// if (mainJobName == 'service-reports-ans' || mainJobName == 'service-loans-retail-ans' || mainJobName == 'service-loans-agri-ans' || mainJobName == 'service-loans-msme-ans' || mainJobName == 'service-dms-ans' || mainJobName == 'service-aadhar-ans') {
// sh "kubectl apply -f ${mainJobName}.yml"
// }
			  
// else{
// 	// Kubernetes Deployment, Files copy from service-k8s-oamplus repo and replace the value from JenkinsFile
	
// 		    //sh 'rm -rf ${WORKSPACE}/service-k8s-oamplus'
//             	   // sh 'git clone https://pavan2619131:gittoken.com/capitawrld/service-k8s-oamplus.git ${WORKSPACE}/service-k8s-oamplus'
                    
// 		    sh "sed -i 's|\${mainJobName}|${mainJobName}|g' ${WORKSPACE}/service-k8s-oamplus/deployment.yaml"
//           	    sh "sed -i 's|\${port}|${port}|g' ${WORKSPACE}/service-k8s-oamplus/deployment.yaml"
// 	            sh "sed -i 's|\${requestsCpu}|${requestsCpu}|g' ${WORKSPACE}/service-k8s-oamplus/deployment.yaml"
// 		    sh "sed -i 's|\${requestsMemory}|${requestsMemory}|g' ${WORKSPACE}/service-k8s-oamplus/deployment.yaml"
// 		    sh "sed -i 's|\${minReplicas}|${minReplicas}|g' ${WORKSPACE}/service-k8s-oamplus/deployment.yaml"
// 		    sh "sed -i 's|\${maxReplicas}|${maxReplicas}|g' ${WORKSPACE}/service-k8s-oamplus/deployment.yaml"
// 		    sh "sed -i 's|\${healthcheckPath}|${healthcheckPath}|g' ${WORKSPACE}/service-k8s-oamplus/deployment.yaml"
//                     sh "kubectl apply -f ${WORKSPACE}/service-k8s-oamplus/deployment.yaml"
// }
// 		}
//                 }
//         }
        
                                          
//             }




		
//             }
		
	
//         }
//     }
    
