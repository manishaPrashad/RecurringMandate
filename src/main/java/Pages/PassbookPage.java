package Pages;

import base.AppUIBaseClass;
import com.utilities.webUtils.WaitUtility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public  class PassbookPage extends AppUIBaseClass {



    private static final Logger log = LogManager.getLogger(PassbookPage.class);



    @AndroidFindBy(xpath = "//*[contains(@text,'Passbook')]//following::android.widget.FrameLayout")
    public static AndroidElement PassbookAccountCheck;

    @AndroidFindBy(xpath = "//*[contains(@text,'Passbook')]//following::android.widget.FrameLayout//following::android.widget.LinearLayout//following-sibling::android.widget.LinearLayout//following::android.widget.RelativeLayout//following::android.widget.LinearLayout//following::android.widget.TextView//following-sibling::android.widget.TextView")
    public static AndroidElement AmountSent;

   /* @FindBy(xpath="//*[@class='android.widget.LinearLayout']//*[@resource-id='com.jio.myjio:id/cl_root_layout'][1]//*[@resource-id='com.jio.myjio:id/upi_bene_name_drawable_lay']")
    public static WebElement requestFrom;*/

    @FindBy(xpath="//*[@class='android.widget.TextView' and @text='UPI payments']")
    public static WebElement requestFrom;

    @FindBy(xpath="//*[@class='android.widget.TextView' and @text='Request From']")
    public static WebElement requestFromPassbook;

    @FindBy(id="com.jio.myjio:id/iv_mandate_next")
    public static WebElement manageMandate;

    @FindBy(xpath="//android.widget.TextView[@resource-id='com.jio.myjio:id/tv_history_type']")
    public static WebElement mandateDetail;

    @FindBy(xpath="//android.widget.TextView[@resource-id='com.jio.myjio:id/upitxnstatus' and @text='PAUSED']")
    public static WebElement suspendedMndate;

    @FindBy(xpath="//*[@text='UPI payments")
    public static WebElement upiPayments;



    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'E-mail')]//preceding::android.widget.FrameLayout//following::android.widget.FrameLayout//following::android.widget.LinearLayout//following::android.widget.TextView")
    public static List<AndroidElement> TransactionResultPageVerification;

    public  PassbookPage() {
        PageFactory.initElements(new AppiumFieldDecorator((AndroidDriver) androidDriver), this);
    }

    public  static void verifyAmount() {
        helperClass.waitForElement(PassbookAccountCheck);
        String[] actualAmount = AmountSent.getText().split("₹", 2);
        try {
            Assert.assertEquals(actualAmount[1], properties.getProperty("AMOUNT"));
            log.info("Amount verification done");
            PassbookAccountCheck.click();
        } catch (AssertionError e) {
            throw new AssertionError(e.getMessage() + "Actual amount " + actualAmount[1] + " and Expected amount " + properties.getProperty("AMOUNT") + " are not equal");
        }
    }

    public static  void verifySentTo(String UPIHandle,String AccountType,String UTRNumber) {
        List<String> values = new ArrayList<>();
        for (WebElement ele : TransactionResultPageVerification) {
            String value = ele.getText();
            System.out.println(value);
            values.add(value);
        }
        System.out.println(values);
        if (values.contains(UPIHandle)) {
            log.info("UPI Handle Present");
        } else {
            throw new AssertionError("Actual UPI Handle expected was "+UPIHandle);
        }
        if (values.contains("Debited from")) {
            log.info("Debit from text Present");
            if (values.contains(AccountType)){
                log.info("Acount type is present");
            }
            else {
                log.error("Account type is not present");
                throw new AssertionError("Actual debit account expected was "+AccountType);
            }
        }
        else {
            log.error("Transaction is pending ");
        }
        if (values.contains(UTRNumber)) {
            log.info("UTR Present");
        } else {
            throw new AssertionError("Actual UTR expected was "+UTRNumber);
        }

    }

    public static  void validateManageMandateField(){
        helperClass.waitForElement(manageMandate);
        manageMandate.click();
        WaitUtility.averageWait();

    }

    public static  void navigateToPassbook(){
        HomePage HomePage=new HomePage();
       // unloackDevice();
        waitAndActionOnElement(HomePage.UPIButton);
        UPIPage upiPage=new UPIPage();
        upiPage.selectPassbook();
    }

}
