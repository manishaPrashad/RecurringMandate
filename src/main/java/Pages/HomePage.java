package Pages;

/**
 * Class functionality-My JIo Home page
 * Author name:- Manisha kumari and Hemanth.Vanapalli
 */

import base.AppUIBaseClass;
import com.utilities.webUtils.WaitUtility;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AppUIBaseClass {

    private static final Logger log = LogManager.getLogger(HomePage.class);

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//" +
            "following::android.view.ViewGroup//following-sibling::android.widget.TextView" +
            "[contains(@text,'UPI')]")
    public static WebElement UPITab;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//" +
            "following::android.view.ViewGroup//following-sibling::android.widget.TextView" +
            "[contains(@text,'FINANCE')]")
    public static AndroidElement FINanceTab;


    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout//following::androidx.recyclerview.widget.RecyclerView//following::android.view.ViewGroup)[2]")
    private static AndroidElement BankTab;

    @FindBy(xpath = "//*[@resource-id='com.jio.myjio:id/iv_acc_click_arrow']")
    public static WebElement arrowButton;

    @FindBy(xpath = "//android.widget.TextView[@text='MORE']")
    public static WebElement moreButton;

    @FindBy(xpath = "//android.widget.TextView[@text='UPI']")
    public static WebElement UPIButton;

    @FindBy(xpath = "//*[@bounds='[550,692][568,710]']")
    public static WebElement swipeLeft;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.jio.myjio:id/no_internet_connection']")
    public static WebElement internetConnection;

    public static void selectUPITab() {
        WaitUtility.maximumWait();
        System.out.println(androidDriver.getContext());
           waitAndActionOnElement(UPITab);
        System.out.println(androidDriver.getContext());
            log.info("Clicked on UPI Tab");
    }



}
