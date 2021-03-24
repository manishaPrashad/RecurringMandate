package UPIScripts;

import Pages.*;
import base.AppUIBaseClass;
import com.utilities.reportUtils.ExtentUtility;
import com.utilities.webUtils.WaitUtility;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;

import java.net.MalformedURLException;

public class PayButtonFunctionality extends AppUIBaseClass {

    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(PayButtonFunctionality.class);

    public static HomePage homePage=new HomePage();
    public static CollectPayRequestFromPage collectPayRequestFromPage=new CollectPayRequestFromPage();
    public static PayPage payPage=new PayPage();
    public static MPinPage mPinPage=new MPinPage();
    public static TransactionSummaryPage transactionSummaryPage=new TransactionSummaryPage();
    public static SendMoneyPage sendMoney = new SendMoneyPage();
    public static TransferringSendMoneyPage tf = new TransferringSendMoneyPage();

    @Step("This is pay button functionality")
    public static void payButtonFunctionalityScript(String BankName,String mpin) throws InterruptedException, MalformedURLException {
        homePage.selectUPITab();
        collectPayRequestFromPage.clickOnPayButton();
        saveScreenshotPNG();
        //validate upi shield
       // sendMoney.selectDebitBank(BankName);
        logToReport("click on proceed button");
        payPage.proceedButton();
        WaitUtility.averageWait();
        saveScreenshotPNG();
        logToReport("click on confirm button");
      //  tf.clickOnApproveButton();
        WaitUtility.averageWait();
        mPinPage.enterMpin(mpin);
        WaitUtility.maximumWait();
        saveScreenshotPNG();
        transactionSummaryPage.validateTransactionStatus();
        saveScreenshotPNG();
        //validate receipt
        assertUtility.softAssert.assertAll();

    }


}
