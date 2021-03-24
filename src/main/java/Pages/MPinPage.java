package Pages;

import base.AppUIBaseClass;
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

public  class MPinPage extends AppUIBaseClass {

    private static final Logger log = LogManager.getLogger(MPinPage.class);


    @AndroidFindBy(id = "form_item_input")
    private AndroidElement mPinField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"ENTER UPI PIN\")")
    private AndroidElement npciPageTitle;

    @AndroidFindBy(xpath = "//android.widget.TableLayout//android.widget.ImageView[2]")
    public  static AndroidElement submitButttonForMpin;

    @FindBy(id="com.jio.myjio:id/tvForgotMpin")
    public  static WebElement forgotMpin;

    @FindBy(id="com.jio.myjio:id/iv_dob_calender")
    public  static WebElement setDOB;

    @FindBy(id="com.jio.myjio:id/edt_enter_ovd")
    public  static WebElement enterPan;

    @FindBy(id="com.jio.myjio:id/btn_upi_validate_ovd")
    public  static WebElement proceedButton;

    @FindBy(xpath="//*[@text='OK']")
    public  static WebElement okButton;

    @FindBy(id="com.jio.myjio:id/tv_dialog_content")
    public  static WebElement mpinErrorMsg;


    public  MPinPage() {

        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }


    public static  void enterMpin(String mPin){
        //helperClass.waitForElement(npciPageTitle);
        for(int i=0;i<mPin.length();i++){
            char pin= mPin.charAt(i);
            ((AndroidDriver) androidDriver).findElement(By.xpath("//android.widget.TextView[@text='"+pin+"']")).click();
            //saveScreenshotPNG();
        }
        submitButttonForMpin.click();
       // saveScreenshotPNG();
    }


}
