package Pages;

import base.AppUIBaseClass;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SMSvalidationPage extends AppUIBaseClass {

    private static final Logger log = LogManager.getLogger(TransactionSummaryPage.class);

    public  SMSvalidationPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @FindBy(id="android:id/big_text")
    public WebElement revokeSMS;

    public void validateRevokeSMS(){
    androidDriver.openNotifications();
    String revokeSMSText=revokeSMS.getText();
    System.out.println(revokeSMSText+"revokesms");
        saveScreenshotPNG();
        if(revokeSMSText.contains(properties.getProperty("RevokeFailSMS"))){
        System.out.println("revoke failed");
            saveScreenshotPNG();
        }else if (revokeSMSText.contains(properties.getProperty("RevokeSuccessSMS"))){
        System.out.println("revoke success");
            saveScreenshotPNG();
        }
    androidDriver.navigate().back();
}


}
