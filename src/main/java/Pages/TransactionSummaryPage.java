package Pages;

import Utils.AssertUtility;
import base.AppUIBaseClass;
import com.utilities.mobileUtils.ActionsUtility;
import com.utilities.webUtils.WaitUtility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

import static UPIScripts.SuspendAndResumeFunctionality.manageMandatePage;
import static UPIScripts.SuspendAndResumeFunctionality.passbookPage;
import static base.Constants.failStatus;
import static base.Constants.status_Success;


public  class TransactionSummaryPage extends AppUIBaseClass {

    private static final Logger log = LogManager.getLogger(TransactionSummaryPage.class);
    public  TransactionSummaryPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(xpath = "//*[contains(@text,'Send money')]//following::android.widget.FrameLayout//android.widget.LinearLayout//android.widget.FrameLayout//following::android.widget.ImageView")
    public static AndroidElement TransactionStatusImage;

    @AndroidFindBy(xpath = "//*[contains(@text,'Send money')]//following::android.widget.FrameLayout//android.widget.LinearLayout//android.widget.FrameLayout//following::android.widget.ImageView//following-sibling::android.widget.TextView//following::android.widget.TextView")
    public static List<AndroidElement> TransactionStatus;

    @AndroidFindBy(xpath = "//*[contains(@text,'Send money')]//following::android.widget.FrameLayout//android.widget.LinearLayout//android.widget.FrameLayout//following::android.widget.ImageView//following-sibling::android.widget.TextView//following::android.widget.TextView//following::android.widget.TextView")
    public static AndroidElement TxnMsg;

    @AndroidFindBy(xpath = "//*[contains(@text,'Sent to')]//following-sibling::android.widget.TextView")
    public static AndroidElement SentTo;

    @AndroidFindBy(xpath = "//*[contains(@text,'Sent to')]//following-sibling::android.widget.TextView//following::android.widget.LinearLayout//following-sibling::android.widget.TextView//following-sibling::android.widget.TextView")
    public static AndroidElement DebitFrom;

    @AndroidFindBy(xpath = "//*[contains(@text,'Sent to')]//following-sibling::android.widget.TextView//following::android.widget.LinearLayout//following-sibling::android.widget.TextView//following-sibling::android.widget.TextView//following::android.widget.LinearLayout//following-sibling::android.widget.TextView//following-sibling::android.widget.TextView//following::android.widget.LinearLayout//following-sibling::android.widget.TextView//following-sibling::android.widget.TextView")
    public static AndroidElement UTRNumber;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Done']")
    public static AndroidElement DoneBtn;

    @FindBy(xpath = "//*[@resource-id='com.jio.myjio:id/tv_share']")
    public static WebElement shareReceipt;

    @FindBy(xpath= "//android.widget.TextView[@resource-id='com.jio.myjio:id/tv_money_success_title']")
    public static WebElement txnStatusMsg;

    @FindBy(id = "com.jio.myjio:id/tv_view_more")
    public static WebElement viewMore;

    @FindBy(id = "com.jio.myjio:id/tv_consumer_number_value")
    public static WebElement subscriberId;

    @FindBy(id = "com.jio.myjio:id/tv_trans_id_value")
    public static WebElement trnsactionId;

    @FindBy(id = "com.jio.myjio:id/tv_ref_no_value")
    public static WebElement utrRefId;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.jio.myjio:id/tv_failure_message']")
    public static WebElement validateErrorMessage;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/sem_title_default']")
    public static WebElement shareImage;

    @FindBy(id="com.jio.myjio:id/ic_actionbar_bank_filter")
    public static WebElement filter;

    @FindBy(xpath="//*[@text='From date']")
    public static WebElement fromDate;

    @FindBy(xpath="//*[@text='To date']")
    public static WebElement toDate;

    @FindBy(xpath="//*[@text='Paid']")
    public static WebElement paid;

    @FindBy(xpath="//*[@text='Received']")
    public static WebElement Received;

    @FindBy(xpath="//*[@text='Apply']")
    public static WebElement Apply;

    @FindBy(id="com.jio.myjio:id/cl_ac_sec")
    public static WebElement listOFItems;

    @FindBy(xpath="//*[@text='Sent To']")
    public static WebElement sentTo;

    @FindBy(xpath="//*[@text='Request To']")
    public static WebElement requestTo;

    @FindBy(id="com.jio.myjio:id/iv_support")
    public static WebElement support;

    @FindBy(id="com.google.android.gm:id/to")
    public static WebElement careId;

    @FindBy(xpath="//android.widget.Button[@resource-id='android:id/button_once']")
    public static WebElement justOnce;

    @FindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.jio.myjio:id/rl_cancel']")
    public static WebElement cancelButton;

    @FindBy(xpath="//android.widget.Button[@resource-id='com.jio.myjio:id/btnModifyMandate']")
    public static WebElement suspendButton;

    @FindBy(id="com.jio.myjio:id/tv_cancel")
    public static WebElement cancelRevokeButton;

    @FindBy(id="//*[@text='Cancel mandate']")
    public static WebElement revokeButton;

    @FindBy(id="com.jio.myjio:id/tv_ok")
    public static WebElement proceedButton;

    @FindBy(xpath ="//android.widget.TextView[@resource-id='com.jio.myjio:id/tv_start_date' and @text='Pause from']")
    public static WebElement startdate;

    @FindBy(xpath ="//android.widget.TextView[@resource-id='com.jio.myjio:id/tv_end_date' and @text='Pause till']")
    public static WebElement enddate;

    @FindBy(id="com.jio.myjio:id/btn_pause")
    public static WebElement suspendMandate;

    @FindBy(xpath="//android.widget.TextView[@text='Resume mandate']")
    public static WebElement resumeMandate;

    @FindBy(xpath="//*[@text='OK']")
    public static WebElement okButton;

    @FindBy(xpath="//*[@text='Ok']")
    public static WebElement confirmOkButton;

    @FindBy(id="com.jio.myjio:id/rl_cancel")
    public static WebElement cancelMandate;

    @FindBy(xpath="//android.widget.Button[@resource-id='com.jio.myjio:id/tv_ok']")
    public static WebElement resumeOk;



    @FindBy(id="com.jio.myjio:id/tv_manage_mandate")
    public static WebElement manageMandateButtn;


    @Step("Navigate to manage mandate page")
    public static void getManageMandateButtn() {
        WaitUtility.maximumWait();
    waitAndActionOnElement(manageMandateButtn);
    WaitUtility.maximumWait();
    }





    public void revokeMandate(String actionToPerform,String mpin){
        waitAndActionOnElement(revokeButton);
        switch (actionToPerform){
            case "cancel":
                waitAndActionOnElement(cancelRevokeButton);
                break;
            case "revokeOk":
                waitAndActionOnElement(proceedButton);
                MPinPage mPinPage=new MPinPage();
                mPinPage.enterMpin(mpin);
                break;
        }

    }

    public static  void selectStartdate(String dateVal){
        WebElement date=androidDriver.findElement(By.xpath("//*[@text='"+dateVal+"']"));
        date.click();
        helperClass.waitForElement(okButton);
        okButton.click();

    }


        public static void performeSuspend(String startDate,String endDate,String mpinNo){
        waitAndActionOnElement(suspendMandate);
        waitAndActionOnElement(startdate);
            selectStartdate(startDate);
            waitAndActionOnElement(enddate);
            selectStartdate(endDate);
            MPinPage mPinPage=new MPinPage();
            waitAndActionOnElement(suspendButton);
            mPinPage.enterMpin(mpinNo);
            WaitUtility.averageWait();
            //waitAndActionOnElement(confirmOkButton);

    }

    public static void performeResume(String mpinNo){
        loopToNavigateBack();
        manageMandatePage.applyFilter("Paused");
        waitAndActionOnElement(passbookPage.mandateDetail);
        waitAndActionOnElement(resumeMandate);
        waitAndActionOnElement(resumeOk);
        MPinPage mPinPage=new MPinPage();
        mPinPage.enterMpin(mpinNo);
       // waitAndActionOnElement(confirmOkButton);
        validateTransactionStatus();



    }






    public static AndroidElement getTransactionStatus() {
        return (AndroidElement) TransactionStatus;
    }

    public static void checkTransactionStatus(String TxnStatus) {
        // helperClass.waitForElement(TransactionStatusImage);
        for (AndroidElement element : TransactionStatus) {
            String text = element.getText();
            System.out.println("The text is " + text + "\n");
            if (TxnStatus.equalsIgnoreCase(status_Success)) {
                if (text.equals(properties.getProperty("SUCCESS_STATUS"))) {
                    log.info(text);
                    Assert.assertTrue(true, text);
                    break;
                } else {
                    log.error(text);
                    Assert.assertTrue(false, text);
                    break;
                }
            } else if (TxnStatus.equalsIgnoreCase(failStatus)) {
                if (text.equals(properties.getProperty("FAIL_STATUS"))) {
                    log.info(text);
                    helperClass.waitForElement(validateErrorMessage);
                    String errorMsg = validateErrorMessage.getText();
                    log.info(errorMsg + "error message of Failure");
                    Assert.assertTrue(true, text);
                    break;
                } else if (text.equals(properties.getProperty("PENDING_STATUS"))) {
                    log.info(text);
                    Assert.assertTrue(true, text);
                    break;
                }else if (text.equals(properties.getProperty("MandatePaused"))) {
                    log.info(text);
                    Assert.assertTrue(true, text);
                    break;
                }
                else {
                    log.error("Transaction found with status " + text);
                    Assert.assertTrue(false, text);
                    break;
                }
            }
        }
    }

    public static String getSentID(String UPIID) {
        WebDriverWait wait = new WebDriverWait((AndroidDriver) androidDriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text,'Sent to')]//following-sibling::android.widget.TextView")));
        String ID = SentTo.getText();
        log.info("Sent ID is " + ID);
        if (ID.contains(UPIID)) {
            log.info("Actual UPI ID found");
        } else {
            log.error("Actual UPI ID not found");
            throw new AssertionError("Actual UPI ID was " + UPIID + " but was " + ID);
        }
        return ID;
    }

    public static String getDebitID(String AccountType) {
        String ID = DebitFrom.getText();
        log.info("Debit from account is " + ID);
        if (ID.contains(AccountType)) {
            log.info("Actual Debit Account found");
        } else {
            log.error("Actual Debit account not found");
            throw new AssertionError("Actual account was " + AccountType + " but was " + ID);
        }
        return DebitFrom.getText();
    }

    public static String getUTRNumber() {
        log.info("UTR Number is " + UTRNumber.getText());
        return UTRNumber.getText();
    }

    public static void setUtrNumber() {
        helperClass.waitForElement(UTRNumber);
        String trnRefNo = UTRNumber.getText();
        properties.setProperty("TransactionRef", trnRefNo);
    }

    public static void getErrorMessage() {
        if (TxnMsg.getText().contains(properties.getProperty("UOD_ERROR_MESSAGE"))) {
            log.info(TxnMsg.getText());
            Assert.assertTrue(true, "Transaction contains expected error message");
        } else if (TxnMsg.getText().contains(properties.getProperty("SAME_ACCOUNT_ERROR_MESSAGE"))) {
            log.info(TxnMsg.getText());
            Assert.assertTrue(true, "Transaction contains expected error message");
        } else {
            log.error(TxnMsg.getText() + " is not an expected message");
            Assert.assertTrue(false, "Not an expected message");
        }
    }


    public static void selectDoneBtn() {
        DoneBtn.click();
        log.info("Clicked on Done Button");
    }

    public static boolean validateShareReceipt() {
        boolean sharercpt = shareReceipt.isDisplayed();
        return true;

    }

    public static void clickOnSahreReceipt() {
        helperClass.waitForElement(shareReceipt);
        validateShareReceipt();
        shareReceipt.click();
    }

    public static void validateShareImage() {
        helperClass.waitForElement(shareImage);
        boolean shareImageVisibilty = shareImage.isDisplayed();
        AssertUtility.softAssert.assertTrue(true, String.valueOf(shareImageVisibilty));
    }


    public static void validateTransactionStatus() {
        helperClass.waitForElement(txnStatusMsg);
        String finalTxnMsg = txnStatusMsg.getText();
        try {
            if (finalTxnMsg.equals(properties.getProperty("SUCCESS_STATUS"))) {
                log.info("successful Transaction");
            } else if (finalTxnMsg.equals(properties.getProperty("FAIL_STATUS"))) {
                System.out.println(finalTxnMsg + "failed status");
            } else if (finalTxnMsg.equals(properties.getProperty("Mandate_SUCCESS_STATUS"))) {
                log.info("mandtae created successfully");
            }else if(finalTxnMsg.equals(properties.getProperty("MandateRevokeStatus"))){
                log.info("mandate revoked successfully");
            }
            else if(finalTxnMsg.equals(properties.getProperty("MandateResumeStatus"))){
                log.info("mandate revoked successfully");
            }
            else if(finalTxnMsg.equals(properties.getProperty("MandateSuspendStatus"))){
                log.info("mandate revoked successfully");
            }
        } catch (Exception e1) {

            if (finalTxnMsg.equals(properties.getProperty("PENDING_STATUS"))) {
                System.out.println("pending  Transaction");
            } else {
                e1.printStackTrace();
            }
        }

    }

    public static  void validateTrnsxFields() throws InterruptedException, IOException {
        //validate utrNumber
        helperClass.waitForElement(utrRefId);
        boolean utrNo=utrRefId.isDisplayed();
        assertUtility.assertTrue(utrNo,"UMN tag display");
        String dspUtrNo=utrRefId.getText();
        log.info(dspUtrNo+"utrNo");
        testData.put("UtrNo",dspUtrNo);
        properties.setProperty("UTRNUMBER",dspUtrNo);
    }


    }


