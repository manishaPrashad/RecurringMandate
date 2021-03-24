package Pages;

import base.AppUIBaseClass;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class TransferringSendMoneyPage extends AppUIBaseClass {

    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(TransferringSendMoneyPage.class);


    public  TransferringSendMoneyPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);

    }


    @FindBy(id="com.jio.myjio:id/confirmSendMoney")
    public static WebElement confirmButton;

    @FindBy(xpath="//*[@text='Approve']")
    public static WebElement approveButton;

    public static void clickOnApproveButton(){
        helperClass.waitForElement(approveButton);
        approveButton.click();
    }

public static void clickOnConfirmButton(){
    helperClass.waitForElement(confirmButton);
    confirmButton.click();
}
}
