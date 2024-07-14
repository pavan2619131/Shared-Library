package org.ans

class Constants {
  static final String ANS_EMAILTO = ""
  static final String ANS_EMAILTO_CC = ""


  static final String PROJECT_NAME = ""
  static final String NUM_TO_KEEP_STR = "5"

  static final String ANS_TEAMS_NOTIFICATION_WEBHOOK = 

   static final String ANS_SIT_BRANCH_SERVERNAME = "SIT"
   static final boolean ANS_SIT_BUILD_MAIL_REQUIRE = true
   static final boolean ANS_SIT_DEPLOY_MAIL_REQUIRE = true
   static final boolean ANS_SIT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
   static final boolean ANS_SIT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
   static final boolean ANS_SIT_DEPLOY_FILENAME = "docker.sh"
   static final boolean ANS_SIT_SERVER_JENKINPATH = "/apps/services/jenkinspath"



  static final boolean ANS_SONAR_FAILURE_MAIL_REQUIRE = true
  static final boolean ANS_SONAR_TEST_PERFORM = true
  static final String ANS_SONAR_PERFORM_BRANCH = "branch name"
  static final boolean ANS_BUILD_ARCHIVE_FAILURE_MAIL_REQUIRE = true


static final boolean ANS_K8S_TEST_PERFORM = false
static final String ANS_K8S_PERFORM_BRANCH = "master"


  enum SonarStatus{
    ByPassed,
    passed
  }
}
 
  
   
  
