  
    def call(String serviceName) {
 
  def services = []

  
 
 
 
  services.add('sahay-app-service-jak')
  services.add('sahay-app-service-einvoice') 


 //============================OAM PROJECT SERVICES LIST START================================*/
  
  services.add('oam-config')
  services.add('service-mca-probe')
  services.add('oam-api-client')
 
  // services.add('service-kcc-vendor-apis-ans')
 
 //============================OAM PROJECT SERVICES LIST END================================*/


 //============================OAM PLUS PROJECT SERVICES LIST START================================*/
  
  
  
  services.add('oam-service-panverification')
  services.add('oam-service-mca-probe')
 
 //============================OAM PLUS PROJECT SERVICES LIST END================================*/

//============================PNB-HL PROJECT SERVICES LIST START================================*/
  services.add('service-analyzer-msme-surrogate')
  services.add('service-notifications-msme-surrogate')
  

 //============================PNB-HL PROJECT SERVICES LIST END================================*/
               
  //============================FIT PROJECT SERVICES LIST START================================*/

  services.add('opl-utils')
  services.add('common-itr-utils')
  services.add('commons-lib-fit-score')
  services.add('api-fit-score')
  services.add('client-fit-score')
  services.add('service-consent-master')
  services.add('service-otp')
  

 //============================FIT PROJECT SERVICES LIST END================================*/

         
 //============================OPL SIMULATOR PROJECT SERVICES LIST START================================*/

  services.add('service-simulator')
  services.add('service-simulator-core')
  services.add('service-simulator-liquibase')
  services.add('service-simulator-soap-api')
  services.add('service-simulator-sync-api')
 
 //============================OPL SIMULATOR PROJECT SERVICES LIST END================================*/

 //============================HSBC PROJECT SERVICES LIST START================================*/

  // services.add('service-itr')
  // services.add('api-hsbc')
  


 
 //============================HSBC PROJECT SERVICES LIST END================================*/
 
 
 
  return services.contains(serviceName)
    
}
  
