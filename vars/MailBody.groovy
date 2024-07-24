import org.ans.Constants


def call(String bodyType, String sonarURL='', deploymentServerName='',SonarStatus='') {


  def mailBody = ""
  def color =""

         switch(SonarStatus)
         {
           case Constants.SonarStatus.ByPassed :

           color = "red"
           break;

           case Constants.SonarStatus.Passed :
                color = "green"
                 break;
         }
         case "buildMailBody" :

                      mailBody += "<html><table boarder='1' width='100%'>"
           


  

















9
