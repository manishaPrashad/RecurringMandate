package Pages;

import base.AppUIBaseClass;
import com.utilities.webUtils.WaitUtility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public  class SendMoneyPage extends AppUIBaseClass {

    private static final Logger log = LogManager.getLogger(SendMoneyPage.class);

    @AndroidFindBy(xpath = "//*[contains(@text,'Send money')]//following::android.widget.FrameLayout//android.widget.LinearLayout//android.widget.FrameLayout//android.widget.EditText")
    public static AndroidElement UPIIdTextField;

    @AndroidFindBy(xpath = "//*[contains(@text,'To')]//following-sibling::android.widget.LinearLayout/android.widget.TextView")
    public static AndroidElement GetUPIHandle;

    @AndroidFindBy(xpath = "//*[contains(@text,'Amount')]//following-sibling::android.widget.LinearLayout/android.widget.EditText")
    public static AndroidElement setAmount;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'Proceed')]")
    public static AndroidElement ProceedBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'Pay Later')]")
    public static AndroidElement payLater;

    @AndroidFindBy(xpath = "//*[contains(@text,'Transfer money from')]//following-sibling::androidx.recyclerview.widget.RecyclerView//following::android.widget.TextView")
    public static List<AndroidElement> AccountList;


    @AndroidFindBy(xpath = "//*[contains(@text,'To')]//following-sibling::android.widget.TextView//following::android.widget.TextView//following::android.widget.FrameLayout//following::android.widget.LinearLayout//following::android.widget.TextView//following-sibling::android.widget.TextView")
    public static AndroidElement AccountTypeVerification;

    @AndroidFindBy(xpath = "//*[contains(@text,'To')]//following-sibling::android.widget.TextView//following::android.widget.TextView")
    public static AndroidElement UPIHandleVerification;

    @AndroidFindBy(xpath = "//*[contains(@text,'To')]//following-sibling::android.widget.TextView//following::android.widget.TextView//following::android.widget.Button")
    public static AndroidElement ConfirmBtn;

    @FindBy(xpath = "//android.widget.LinearLayout//android.widget.Button[@resource-id='com.jio.myjio:id/btnPayLater']")
    public static WebElement payLaterOption;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.jio.myjio:id/tvAddMessage']")
    public static WebElement enterRemarks;

    @FindBy(id = "com.jio.myjio:id/tvTransferMoneyBankListHeader")
    public static  WebElement headerTnxFromBank;

    @FindBy(id="com.jio.myjio:id/img_drop_arrow")
    public static WebElement bankArrowButton;


    @FindBy(xpath="//android.widget.TextView[@content-desc='Clear,Button']")
    public static WebElement clearNotification;

    public SendMoneyPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }




    public static void clickProceedBtn() throws InterruptedException {
      waitAndActionOnElement(ProceedBtn);
        log.info("Clicked on Proceed");
    }

    public static void clickOnPayLater() throws InterruptedException {
       waitAndActionOnElement(payLater);
        log.info("Clicked on Proceed");
    }


    public static void getUPIHandle(String UPIID) {
        helperClass.waitForElement(GetUPIHandle);
        System.out.println(GetUPIHandle.getText());
        if (GetUPIHandle.getText().contains(UPIID)) {
            Assert.assertTrue(true, "UPI Handle not found");
            log.info("UPI Handle found is : " + GetUPIHandle.getText());
        } else {
            Assert.assertFalse(true, "UPI Id found doesnt match");
            log.error("UPI Handle found is : " + GetUPIHandle.getText());
        }
    }

    public static void setAmount(String Amount) {
        helperClass.waitForElement(setAmount);
        setAmount.sendKeys(Amount);
        androidDriver.hideKeyboard();
        log.info("Amount entered is : " + Amount);
        //enter remarks

    }

    public static void setTransferAccount(String AccountType) {
        for (WebElement ele : AccountList) {
            String AccountName = ele.getText();
            System.out.println(AccountName);
            log.info("Text found " + AccountName);
            if (AccountName.equals(AccountType)) {
                log.info("Account Type found is " + AccountName);
                ele.click();
                log.info("Element is " + ele);
                break;
            }
        }
    }


    public static void verifyUPIHandle(String UPIID) {
        if (UPIHandleVerification.getText().contains(UPIID)) {
            log.info("UPI Handle verified is " + UPIHandleVerification.getText());
        } else {
            log.error("UPI Handle verified is " + UPIHandleVerification.getText());
              Assert.assertEquals(UPIHandleVerification.getText(),UPIID);
        }

    }

    public static void verifyAccountType(String AccountType) {
        Assert.assertEquals(AccountTypeVerification.getText(), AccountType);
        log.info("Account Type verified is " + AccountTypeVerification.getText());
    }

    public static void setConfirmButton() {
            waitAndActionOnElement(ConfirmBtn);
    }

    public static void validateBankName(String bankName) {
        String bankNameText = androidDriver.findElement(By.xpath("//*[@class='android.widget.TextView' and @text='" + bankName + "']")).getText();
        System.out.println(bankNameText + "bankName");
         assertUtility.assertEqual(bankNameText,bankName,"bankNameValidationFailed");

    }

    public void selectDebitBank(String bankName){
        waitAndActionOnElement(bankArrowButton);
       // unloackDevice();
       // WaitUtility.averageWait();
        WebElement selectDebitBank=androidDriver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'"+bankName+"')]."));

      //  WebElement selectDebitBank=androidDriver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'"+bankName+"')]//following-sibling::android.widget.RadioButton[@resource-id='com.jio.myjio:id/rdSelect']"));
        waitAndActionOnElement(selectDebitBank);
    }

    public static void dragAndclearNotification(){
        androidDriver.openNotifications();
        WaitUtility.minimumWait();
        WaitUtility.minimumWait();
        clearNotification.click();
        WaitUtility.minimumWait();
    }
}
