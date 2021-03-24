package Pages;

/**
 * Class functionality-Popup received after hitting the collect pay request APi
 * Author name:- Manisha kumari
 */

import base.AppUIBaseClass;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class CollectPayRequestFromPage extends AppUIBaseClass {

    private static final Logger log = LogManager.getLogger(CollectPayRequestFromPage.class);

    public CollectPayRequestFromPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }


    @FindBy(xpath="//android.widget.TextView[@content-desc=\"No result\"]")
    public static WebElement requestFrom;

    @FindBy(xpath="//*[@resource-id='com.jio.myjio:id/ll_view_receipt']")
    public static WebElement payReceipt;

    @FindBy(xpath="//android.widget.FrameLayout//preceding-sibling::android.widget.Button[@resource-id='com.jio.myjio:id/mandate_proceed']")
    public static WebElement payButton;

    @FindBy(id="com.jio.myjio:id/tv_later_btn")
    public static WebElement later;

    @FindBy(id="com.jio.myjio:id/tv_decline_btn")
    public static WebElement decline;

    @FindBy(id="com.jio.myjio:id/pendingRequestClose")
    public static WebElement closeDailouge;

    @FindBy(xpath = "//android.widget.RelativeLayout//following::androidx.recyclerview.widget.RecyclerView//following::android.view.ViewGroup[1]")
    public static AndroidElement UPITab;

    @FindBy(id="com.jio.myjio:id/btn_notification")
    public static WebElement notification;

    public static WebElement getUpiTabVisibilty(){
        return UPITab;
    }

    public static void getUPItab(){
        UPITab.click();
    }


    public static  void clickOnNotification() throws InterruptedException {
        UPITab.click();
        Thread.sleep(2000);
        notification.click();
    }

    public static  void clickOnPayButton(){
        waitAndActionOnElement(payButton);
    }

    public static  void checkLaterButton(){
        later.click();
    }
    public static  void checkDecline(){
        decline.click();
    }

    public static Point getreceiptbutton(){
        helperClass.waitForElement(payReceipt);
        Point location = payReceipt.getLocation();
        payReceipt.click();
        return location;
    }



}
