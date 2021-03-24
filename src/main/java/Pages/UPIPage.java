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


public  class UPIPage extends AppUIBaseClass {

    private static final Logger log = LogManager.getLogger(UPIPage.class);

    @AndroidFindBy(xpath = "//*[contains(@text,'Passbook')]//following::android.widget.FrameLayout")
    public static  AndroidElement MyUPIHandleButton;

    @AndroidFindBy(xpath = "//*[contains(@text,'Passbook')]//following::android.widget.FrameLayout//following::android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
    public static  AndroidElement MyUPIHandle;

    @AndroidFindBy(xpath = "((//*[contains(@text,'My bank accounts')]//following::android.widget.FrameLayout//android.widget.RelativeLayout)[2]//following::android.widget.LinearLayout/following-sibling::android.widget.TextView)[2]")
    public static  AndroidElement Primary;

    @AndroidFindBy(xpath = "(//*[contains(@text,'Bank accounts')]//following::android.widget.FrameLayout/android.widget.RelativeLayout//following-sibling::android.widget.TextView)[6]")
    public static  AndroidElement SODTextCheck;

    @AndroidFindBy(xpath = "(//*[contains(@resource-id,'layout_home_screen')]//androidx.recyclerview.widget.RecyclerView)[2]//android.widget.RelativeLayout")
    public static  AndroidElement SendMoneyBtn;

    @FindBy(xpath="//android.widget.TextView[@text='Passbook']")
    public static  AndroidElement Passbook;

    @FindBy(xpath="//*[@resource-id='com.jio.myjio:id/iv_acc_click_arrow']")
    public static  WebElement profileArrowTab;

    @FindBy(xpath="//android.widget.TextView[@text='Request money']")
    public static  WebElement requestMoney;

    @FindBy(xpath="//android.widget.TextView[@text='DTH']")
    public static  WebElement dthConnection;

    @FindBy(xpath="//android.widget.TextView[@text='Bill']")
    public static  WebElement bilPayment;


    public UPIPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }


    public static void selectPassbook() {
        WaitUtility.minimumWait();
        Passbook.click();
        log.info("Clicked on Passbook");
    }

    public static void actionOnRequestMoney(){
        helperClass.waitForElement(requestMoney);
        requestMoney.click();
    }

}
