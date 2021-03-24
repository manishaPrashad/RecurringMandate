package Pages;

import base.AppUIBaseClass;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public  class PayPage extends AppUIBaseClass {

    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(PayPage.class);


    public PayPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }
    SoftAssert softAssert=new SoftAssert();

    @FindBy(id="com.jio.myjio:id/btn_notification")
    public static WebElement notification;

    @FindBy(id="com.jio.myjio:id/upi_shield_icon")
    public static WebElement upiShield;

    @FindBy(id="com.jio.myjio:id/tv_send_to_vpa")
    public static WebElement upiId;

   // @FindBy(id="com.jio.myjio:id/btnSendMoneyCollect")
    @FindBy(xpath ="//android.widget.LinearLayout[@resource-id='com.jio.myjio:id/llActionButtons']//android.widget.Button[2]")
    public static WebElement proceedPay;



    @FindBy(xpath="//*[@text()='Jio payments bank']")
    public static WebElement jioPaymentbank;

    @FindBy(xpath="//*[@text()='Mypsp']")
    public static WebElement mypsp;

    @FindBy(xpath="//*[@text()='Mybank']")
    public static WebElement Mybank;

    @FindBy(xpath="//[@text()='Check balance']")
    public static WebElement checkBalance;



    public static  void proceedButton(){
        proceedPay.click();
    }
     public static String upiIdText;
    public static String upiIdValidate(){
        upiIdText=upiId.getText();
        System.out.println(upiIdText+"upi id value");
        return upiIdText;

    }

    public static  void getNotificationPopup(){
        waitAndActionOnElement(notification);
    }








}
