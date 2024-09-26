// package org.ans

// class Constants {
//   static final String ANS_EMAILTO = ""
//   static final String ANS_EMAILTO_CC = ""


//   static final String PROJECT_NAME = ""
//   static final String NUM_TO_KEEP_STR = "5"

//   static final String ANS_TEAMS_NOTIFICATION_WEBHOOK = 

//    static final String ANS_SIT_BRANCH_SERVERNAME = "SIT"
//    static final boolean ANS_SIT_BUILD_MAIL_REQUIRE = true
//    static final boolean ANS_SIT_DEPLOY_MAIL_REQUIRE = true
//    static final boolean ANS_SIT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
//    static final boolean ANS_SIT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
//    static final boolean ANS_SIT_DEPLOY_FILENAME = "docker.sh"
//    static final boolean ANS_SIT_SERVER_JENKINPATH = "/apps/services/jenkinspath"



//   static final boolean ANS_SONAR_FAILURE_MAIL_REQUIRE = true
//   static final boolean ANS_SONAR_TEST_PERFORM = true
//   static final String ANS_SONAR_PERFORM_BRANCH = "branch name"
//   static final boolean ANS_BUILD_ARCHIVE_FAILURE_MAIL_REQUIRE = true


// static final boolean ANS_K8S_TEST_PERFORM = false
// static final String ANS_K8S_PERFORM_BRANCH = "master"


//   enum SonarStatus{
//     ByPassed,
//     passed
//   }
// }


  package org.ans

class Constants {
  static final String ANS_EMAILTO = "akshay.patel@onlinepsbloans.com, pappu.yadav@onlinepsbloans.com"
  //static final String ANS_EMAILTO = "jignesh.mirani@onlinepsbloans.com"
  static final String ANS_EMAILTO_CC = "jignesh.mirani@onlinepsbloans.com, sahil.patel@onlinepsbloans.com"
    
  static final String ANS_EMAILTOPABL = "hiren.sojitra@onlinepsbloans.com, ketan.goswami@onlinepsbloans.com, monika.vara@onlinepsbloans.com, pappu.yadav@onlinepsbloans.com, pavankumar.yalla@onlinepsbloans.com, mensi.khunt@onlinepsbloans.com, ritesh.patel@onlinepsbloans.com, brijesh.hansaliya@onlinepsbloans.com, ankit.kapadiya@onlinepsbloans.com, rahul.chauhan@onlinepsbloans.com"

  static final String PROJECT_NAMEDG = "DG - SUGAM"
  static final String ANS_EMAILTODG = "jay.mpatel@onlinepsbloans.com, manish.patel@onlinepsbloans.com, sanjay.makwana@onlinepsbloans.com, pappu.yadav@onlinepsbloans.com"

  static final String PROJECT_NAMEPNBHL = "PNB - HL"
  static final String ANS_EMAILTOPNBHL = "chirag.shah@onlinepsbloans.com, keval.chauhan@onlinepsbloans.com, shivnarayan.birla@onlinepsbloans.com, smit.mandivala@onlinepsbloans.com, pappu.yadav@onlinepsbloans.com, pavankumar.yalla@onlinepsbloans.com"
  
  static final String PROJECT_NAME = "GST - SAHAY"
  static final String PROJECT_NAMES = "PABL"
  static final String  NUM_TO_KEEP_STR = "2"

  static final String PROJECT_NAMEFIT = "FIT"
  static final String ANS_EMAILTOFIT =  "pappu.yadav@onlinepsbloans.com, pavankumar.yalla@onlinepsbloans.com, chirag.shah@onlinepsbloans.com"

  static final String PROJECT_NAMEBOB = "BOB"
  static final String ANS_EMAILTOBOB = "pappu.yadav@onlinepsbloans.com, pavankumar.yalla@onlinepsbloans.com"
  static final String ANS_TEAMS_NOTIFICATION_WEBHOOK_BOB = "https://capitaworld.webhook.office.com/webhookb2/e6ee1a0d-0b72-4c5d-bf10-d407d4bac190@54318472-f71e-43cb-b853-5fffed1d2cad/IncomingWebhook/7610b7922f6c48e1aa529b7870e8a56b/d6978761-66ab-4e17-8ce4-f5fea1ee490f"

  static final String PROJECT_NAMEOPLSIM = "OPL - SIMULATOR"
  static final String ANS_EMAILTOOPLSIM = "pappu.yadav@onlinepsbloans.com, pavankumar.yalla@onlinepsbloans.com"
  static final String ANS_TEAMS_NOTIFICATION_WEBHOOK_OPLSIM = "https://capitaworld.webhook.office.com/webhookb2/005a3c55-0ba0-443c-b01f-0e6c8fce4462@54318472-f71e-43cb-b853-5fffed1d2cad/IncomingWebhook/78678d778cca4564bcc5602468754c3e/d6978761-66ab-4e17-8ce4-f5fea1ee490f"

//---------------------------HSBC Start-------------------------------//
  
  static final String PROJECT_NAMEHSBC = "HSBC"
  static final String ANS_EMAILTOHSBC = "pappu.yadav@onlinepsbloans.com, pavankumar.yalla@onlinepsbloans.com"
  static final String ANS_TEAMS_NOTIFICATION_WEBHOOK_HSBC = "https://capitaworld.webhook.office.com/webhookb2/c3d0cd2f-afa4-4a49-8db1-6a1d50defc9a@54318472-f71e-43cb-b853-5fffed1d2cad/IncomingWebhook/522b1a1c26b046f4962349e51d931706/d6978761-66ab-4e17-8ce4-f5fea1ee490f"

  static final String ANS_HSBCSIT_BRANCH_SERVERNAME = "HSBCSIT"
  static final boolean ANS_HSBCSIT_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_HSBCSIT_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_HSBCSIT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_HSBCSIT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_HSBCSIT_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_HSBCSIT_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

  static final String ANS_HSBCUAT_BRANCH_SERVERNAME = "HSBCUAT"
  static final boolean ANS_HSBCUAT_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_HSBCUAT_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_HSBCUAT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_HSBCUAT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_HSBCUAT_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_HSBCUAT_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

  //---------------------------HSBC END-------------------------------//


  //---------------------------PAPQ Start-------------------------------//
  
  static final String PROJECT_NAMEPAPQ = "PAPQ"
  static final String ANS_EMAILTOPAPQ = "pappu.yadav@onlinepsbloans.com, pavankumar.yalla@onlinepsbloans.com"
  static final String ANS_TEAMS_NOTIFICATION_WEBHOOK_PAPQ = "https://capitaworld.webhook.office.com/webhookb2/a659e64b-f906-4fb9-9f21-0a1b37bfeb86@54318472-f71e-43cb-b853-5fffed1d2cad/IncomingWebhook/bb78c7c38c83494bb32fca23aef13388/d6978761-66ab-4e17-8ce4-f5fea1ee490f"

  static final String ANS_PAPQ_BRANCH_SERVERNAME = "PAPQSIT"
  static final boolean ANS_PAPQ_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_PAPQ_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_PAPQ_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_PAPQ_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_PAPQ_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_PAPQ_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

  static final String ANS_PAPQUAT_BRANCH_SERVERNAME = "PAPQUAT"
  static final boolean ANS_PAPQUAT_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_PAPQUAT_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_PAPQUAT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_PAPQUAT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_PAPQUAT_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_PAPQUAT_SERVER_JENKINPATH = "/apps/services/jenkinsPath"


  //---------------------------PAPQ END-------------------------------//

//---------------------------OAMPLUS Start-------------------------------//

  static final String ANS_OAMPLUSSIT_BRANCH_SERVERNAME = "OAMPLUSSIT"
  static final boolean ANS_OAMPLUSSIT_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_OAMPLUSSIT_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_OAMPLUSSIT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_OAMPLUSSIT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_OAMPLUSSIT_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_OAMPLUSSIT_SERVER_JENKINPATH = "/apps/services/jenkinsPath"


  static final String ANS_OAMPLUSUAT_BRANCH_SERVERNAME = "OAMPLUSUAT"
  static final boolean ANS_OAMPLUSUAT_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_OAMPLUSUAT_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_OAMPLUSUAT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_OAMPLUSUAT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_OAMPLUSUAT_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_OAMPLUSUAT_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

  static final String ANS_OAMPLUSPRODUCTION_BRANCH_SERVERNAME = "OAMPLUSPRODUCTION"
  static final boolean ANS_OAMPLUSPRODUCTION_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_OAMPLUSPRODUCTION_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_OAMPLUSPRODUCTION_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_OAMPLUSPRODUCTION_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_OAMPLUSPRODUCTION_DEPLOY_FILENAME = "oam-plus-docker.sh"
  static final String ANS_OAMPLUSPRODUCTION_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

  static final String PROJECT_NAMEOAM = "OAM"
  static final String PROJECT_NAMEOAMPLUS = "OAM - PLUSS"
  static final String ANS_EMAILTOOAM = "deepak.vishwakarma@oplinnovate.com, pappu.yadav@onlinepsbloans.com, pavankumar.yalla@onlinepsbloans.com, anish.parekh@oplinnovate.com"
  static final String ANS_TEAMS_NOTIFICATION_WEBHOOK_OAM = "https://capitaworld.webhook.office.com/webhookb2/ef83e37b-ed9e-4880-9d8e-aaeee58dd5d8@54318472-f71e-43cb-b853-5fffed1d2cad/IncomingWebhook/139463b1a4b74d9ca3c179c5bed3a0e3/d6978761-66ab-4e17-8ce4-f5fea1ee490f"

  static final boolean ANS_OAMPLUSPRODUCTION_TEST_PERFORM = true
  static final String ANS_OAMPLUSPRODUCTION_PERFORM_BRANCH = "production"

  static final String ANS_APPROVAL_MANAGER = "pappu_yadav,anish_parekh"

  static final String ANS_SONAR_PERFORM_BRANCHOAMPLUS = "uat"
  static final String ANS_SONAR_PERFORM_BRANCHOAMPLUS1 = "development"
  static final String ANS_SONAR_PERFORM_BRANCHOAMPLUS2 = "develop"
  
 //---------------------------OAM & OAMPLUS End-------------------------------//


//---------------------------FIT-PLUS START -------------------------------//

static final String ANS_FITPLUSQA_BRANCH_SERVERNAME = "FITPLUSQA"
static final boolean ANS_FITPLUSQA_BUILD_MAIL_REQUIRE = true
static final boolean ANS_FITPLUSQA_DEPLOY_MAIL_REQUIRE = true
static final boolean ANS_FITPLUSQA_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
static final boolean ANS_FITPLUSQA_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
static final String ANS_FITPLUSQA_DEPLOY_FILENAME = "docker.sh"
static final String ANS_FITPLUSQA_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

static final String ANS_FITPLUSUAT_BRANCH_SERVERNAME = "FITPLUSUAT"
static final boolean ANS_FITPLUSUAT_BUILD_MAIL_REQUIRE = true
static final boolean ANS_FITPLUSUAT_DEPLOY_MAIL_REQUIRE = true
static final boolean ANS_FITPLUSUAT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
static final boolean ANS_FITPLUSUAT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
static final String ANS_FITPLUSUAT_DEPLOY_FILENAME = "docker.sh"
static final String ANS_FITPLUSUAT_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

static final String PROJECT_NAMEFITPLUS = "FIT-PLUS"
static final String ANS_EMAILTOFITPLUS = "brijesh.hansaliya@oplinnovate.com, pappu.yadav@onlinepsbloans.com, pavankumar.yalla@onlinepsbloans.com"
static final String ANS_TEAMS_NOTIFICATION_WEBHOOK_FITPLUS = "https://capitaworld.webhook.office.com/webhookb2/2a514a44-35d6-434f-92c1-87ae1e0e5472@54318472-f71e-43cb-b853-5fffed1d2cad/IncomingWebhook/1913082a25364af99ca1fddd149c4028/d6978761-66ab-4e17-8ce4-f5fea1ee490f"

//---------------------------FIT-PLUS END -------------------------------//
  
  static final String ANS_TEAMS_NOTIFICATION_WEBHOOK = "https://capitaworld.webhook.office.com/webhookb2/6b6b2089-3abd-4537-8b2c-097ce8483b7b@54318472-f71e-43cb-b853-5fffed1d2cad/IncomingWebhook/19784f21035c45e096446661c4844d41/d6978761-66ab-4e17-8ce4-f5fea1ee490f"
  static final String ANS_TEAMS_NOTIFICATION_WEBHOOK_PABL = "https://capitaworld.webhook.office.com/webhookb2/c3d0cd2f-afa4-4a49-8db1-6a1d50defc9a@54318472-f71e-43cb-b853-5fffed1d2cad/IncomingWebhook/522b1a1c26b046f4962349e51d931706/d6978761-66ab-4e17-8ce4-f5fea1ee490f"

  static final String ANS_TEAMS_NOTIFICATION_WEBHOOK_PNBHL = "https://capitaworld.webhook.office.com/webhookb2/b397241d-7bc5-4a82-80b1-4e45aa89cf3b@54318472-f71e-43cb-b853-5fffed1d2cad/IncomingWebhook/053e1317a7b94b96b63175c5843bb3ff/d6978761-66ab-4e17-8ce4-f5fea1ee490f"

  static final String ANS_SIT_BRANCH_SERVERNAME = "SIT"
  static final boolean ANS_SIT_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_SIT_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_SIT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_SIT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_SIT_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_SIT_SERVER_JENKINPATH = "/apps/services/jenkinsPath" 

 

  static final String ANS_PNB_BRANCH_SERVERNAME = "PNB"
  static final boolean ANS_PNB_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_PNB_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_PNB_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_PNB_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_PNB_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_PNB_SERVER_JENKINPATH = "/apps/services/jenkinsPath" 

  static final String ANS_UBI_BRANCH_SERVERNAME = "UBI"
  static final boolean ANS_UBI_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_UBI_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_UBI_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_UBI_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_UBI_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_UBI_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

  static final String ANS_SBI_BRANCH_SERVERNAME = "SBI"
  static final boolean ANS_SBI_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_SBI_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_SBI_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_SBI_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_SBI_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_SBI_SERVER_JENKINPATH = "/apps/services/jenkinsPath"
  
  static final String ANS_CANARA_BRANCH_SERVERNAME = "CANARA"
  static final boolean ANS_CANARA_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_CANARA_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_CANARA_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_CANARA_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_CANARA_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_CANARA_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

  static final String ANS_INDIAN_BRANCH_SERVERNAME = "INDIAN"
  static final boolean ANS_INDIAN_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_INDIAN_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_INDIAN_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_INDIAN_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_INDIAN_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_INDIAN_SERVER_JENKINPATH = "/apps/services/jenkinsPath"
  
  static final String ANS_QA_BRANCH_SERVERNAME = "QA"
  static final boolean ANS_QA_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_QA_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_QA_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_QA_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_QA_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_QA_SERVER_JENKINPATH = "/apps/services/jenkinsPath"  
  
  static final String ANS_RELEASE_BRANCH_SERVERNAME = "UAT"
  static final boolean ANS_UAT_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_UAT_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_UAT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_UAT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_UAT_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_UAT_SERVER_JENKINPATH = "/apps/services/jenkinsPath"
  
  static final String ANS_MASTER_BRANCH_SERVERNAME = "GSTPRODUCTION"
  static final boolean ANS_PROD_BUILD_MAIL_REQUIRE = false
  static final boolean ANS_PROD_DEPLOY_MAIL_REQUIRE = false
  static final boolean ANS_PROD_BUILD_TEAMS_NOTIFICATION_REQUIRE = false
  static final boolean ANS_PROD_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = false
  static final String ANS_PROD_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_PROD_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

  static final String ANS_MERGESHAAY_BRANCH_SERVERNAME = "MERGESHAAY"
  static final boolean ANS_MERGESHAAY_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_MERGESHAAY_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_MERGESHAAY_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_MERGESHAAY_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_MERGESHAAY_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_MERGESHAAY_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

  static final String ANS_EGSTSIT_BRANCH_SERVERNAME = "EGSTSIT"
  static final boolean ANS_EGSTSIT_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_EGSTSIT_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_EGSTSIT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_EGSTSIT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_EGSTSIT_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_EGSTSIT_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

  static final String ANS_EGSTUAT_BRANCH_SERVERNAME = "EGSTUAT"
  static final boolean ANS_EGSTUAT_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_EGSTUAT_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_EGSTUAT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_EGSTUAT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_EGSTUAT_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_EGSTUAT_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

  static final String ANS_EGSTMASTER_BRANCH_SERVERNAME = "EGSTMASTER"
  static final boolean ANS_EGSTMASTER_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_EGSTMASTER_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_EGSTMASTER_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_EGSTMASTER_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true

  static final String ANS_PABLMASTER_BRANCH_SERVERNAME = "PABLMASTER"
  static final boolean ANS_PABLMASTER_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_PABLMASTER_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_PABLMASTER_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_PABLMASTER_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true

  static final String ANS_FITMASTER_BRANCH_SERVERNAME = "FITMASTER"
  static final boolean ANS_FITMASTER_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_FITMASTER_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_FITMASTER_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_FITMASTER_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true

  static final String ANS_PNBHLMASTER_BRANCH_SERVERNAME = "PNBHLMASTER"
  static final boolean ANS_PNBHLMASTER_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_PNBHLMASTER_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_PNBHLMASTER_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_PNBHLMASTER_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true

  static final String ANS_PNBHLQA_BRANCH_SERVERNAME = "PNBHLQA"
  static final boolean ANS_PNBHLQA_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_PNBHLQA_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_PNBHLQA_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_PNBHLQA_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_PNBHLQA_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_PNBHLQA_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

  static final String ANS_PNBHLUAT_BRANCH_SERVERNAME = "PNBHLUAT"
  static final boolean ANS_PNBHLUAT_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_PNBHLUAT_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_PNBHLUAT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_PNBHLUAT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_PNBHLUAT_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_PNBHLUAT_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

  static final String ANS_OAMSIT_BRANCH_SERVERNAME = "OAMSIT"
  static final boolean ANS_OAMSIT_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_OAMSIT_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_OAMSIT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_OAMSIT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_OAMSIT_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_OAMSIT_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

  static final String ANS_OAMUAT_BRANCH_SERVERNAME = "OAMUAT"
  static final boolean ANS_OAMUAT_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_OAMUAT_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_OAMUAT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_OAMUAT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_OAMUAT_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_OAMUAT_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

  static final String ANS_OAMPROD_BRANCH_SERVERNAME = "OAMPROD"
  static final boolean ANS_OAMPROD_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_OAMPROD_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_OAMPROD_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_OAMPROD_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true

  

  static final String ANS_FITQA_BRANCH_SERVERNAME = "FITQA"
  static final boolean ANS_FITQA_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_FITQA_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_FITQA_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_FITQA_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_FITQA_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_FITQA_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

  static final String ANS_FITUAT_BRANCH_SERVERNAME = "FITUAT"
  static final boolean ANS_FITUAT_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_FITUAT_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_FITUAT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_FITUAT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_FITUAT_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_FITUAT_SERVER_JENKINPATH = "/apps/services/jenkinsPath"


  static final String ANS_FITJAVA_BRANCH_SERVERNAME = "FITJAVA"
  static final boolean ANS_FITJAVA_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_FITJAVA_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_FITJAVA_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_FITJAVA_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_FITJAVA_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_FITJAVA_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

 

  static final String ANS_BOBQA_BRANCH_SERVERNAME = "BOBQA"
  static final boolean ANS_BOBQA_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_BOBQA_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_BOBQA_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_BOBQA_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_BOBQA_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_BOBQA_SERVER_JENKINPATH = "/apps/services/jenkinsPath"  

  static final String ANS_BOBUAT_BRANCH_SERVERNAME = "BOBUAT"
  static final boolean ANS_BOBUAT_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_BOBUAT_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_BOBUAT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_BOBUAT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_BOBUAT_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_BOBUAT_SERVER_JENKINPATH = "/apps/services/jenkinsPath"  


  static final String ANS_OPLSIMQA_BRANCH_SERVERNAME = "OPLSIMQA"
  static final boolean ANS_OPLSIMQA_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_OPLSIMQA_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_OPLSIMQA_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_OPLSIMQA_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_OPLSIMQA_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_OPLSIMQA_SERVER_JENKINPATH = "/apps/services/jenkinsPath"
  static final String ANS_SONAR_PERFORM_BRANCHOPLSIMQA = "main"

  static final String ANS_GSTSAHAYUAT_BRANCH_SERVERNAME = "GSTSAHAYUAT"
  static final boolean ANS_GSTSAHAYUAT_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_GSTSAHAYUAT_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_GSTSAHAYUAT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_GSTSAHAYUAT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_GSTSAHAYUAT_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_GSTSAHAYUAT_SERVER_JENKINPATH = "/apps/services/jenkinsPath"

   static final String ANS_GSTSAHAYSIT_BRANCH_SERVERNAME = "GSTSAHAYSIT"
  static final boolean ANS_GSTSAHAYSIT_BUILD_MAIL_REQUIRE = true
  static final boolean ANS_GSTSAHAYSIT_DEPLOY_MAIL_REQUIRE = true
  static final boolean ANS_GSTSAHAYSIT_BUILD_TEAMS_NOTIFICATION_REQUIRE = true
  static final boolean ANS_GSTSAHAYSIT_DEPLOY_TEAMS_NOTIFICATION_REQUIRE = true
  static final String ANS_GSTSAHAYSIT_DEPLOY_FILENAME = "deployall.sh"
  static final String ANS_GSTSAHAYSIT_SERVER_JENKINPATH = "/apps/services/jenkinsPath"


  
  
  static final boolean ANS_SONAR_FAILURE_MAIL_REQUIRE = true
  static final boolean ANS_SONAR_TEST_PERFORM = true
  
  static final String ANS_SONAR_PERFORM_BRANCH = "development-pabl-sonar"
  
  static final String ANS_SONAR_PERFORM_BRANCHGST = "uat-sidbi"
  static final String ANS_SONAR_PERFORM_BRANCHGST1 = "uat"
  
  static final String ANS_SONAR_PERFORM_BRANCHEGST = "uat-pnb-egst"
  static final String ANS_SONAR_PERFORM_BRANCHPNBHL = "uat-pnb-hl"

  static final String ANS_SONAR_PERFORM_BRANCHFIT = "fit-score-qa"
  static final String ANS_SONAR_PERFORM_BRANCHFIT1 = "qa"

  static final String ANS_SONAR_PERFORM_BRANCHOAM = "release"

  static final String ANS_SONAR_PERFORM_BRANCHHSBC = "uat"
  
  static final boolean ANS_BUILD_ARCHIVE_FAILURE_MAIL_REQUIRE = false
  
  static final boolean ANS_MASTER_TEST_PERFORM = true
  static final String ANS_MASTER_PERFORM_BRANCH = "prod-pnb-egst"
  static final String PABL_MASTER_PERFORM_BRANCH = "live-pabl"
  static final String FIT_MASTER_PERFORM_BRANCH = "fit-score-release"
  static final String FIT_MASTER_PERFORM_BRANCH1 = "release"
  static final String FIT_MASTER_PERFORM_BRANCH2 = "sidbi-release"

   static final String PNBHL_MASTER_PERFORM_BRANCH = "prod-pnb-hl"
   static final String PNBHL_MASTER_PERFORM_BRANCH1 = "released"
   static final String PNBHL_MASTER_PERFORM_BRANCH2 = "release"
   static final String PNBHL_MASTER_PERFORM_BRANCH3 = "development-api-pnb-hl-release"
   static final String PNBHL_MASTER_PERFORM_BRANCH4 = "PROD"

  static final String ANS_MASTER_PERFORM_BRANCHGST = "production"
  static final String ANS_MASTER_PERFORM_BRANCHGST1 = "prod-sidbi"


  
  enum SonarStatus{
    ByPassed,
    Passed
  } 
  
}
    
   
