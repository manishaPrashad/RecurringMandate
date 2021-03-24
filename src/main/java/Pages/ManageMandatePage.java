package Pages;

import base.AppUIBaseClass;
import com.utilities.mobileUtils.ActionsUtility;
import com.utilities.webUtils.WaitUtility;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Locale;

public  class ManageMandatePage extends AppUIBaseClass {
    private static final Logger log = LogManager.getLogger(ManageMandatePage.class);

    public  ManageMandatePage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @FindBy(id="com.jio.myjio:id/confirmDialogTitle")
    public static WebElement ManageMandate;

    @FindBy(id="com.jio.myjio:id/tv_umn")
    public static WebElement UMNnameTag;

    @FindBy(id="com.jio.myjio:id/tv_umn_value")
    public static WebElement umnNumber;

    @FindBy(xpath="//android.widget.TextView[@resource-id='com.jio.myjio:id/tv_mandate_ref']")
    public static WebElement refTag;

    @FindBy(xpath="//android.widget.TextView[@resource-id='com.jio.myjio:id/tv_ref_no_value']")
    public static WebElement utrNumber;

    @FindBy(xpath="//android.widget.TextView[@resource-id='com.jio.myjio:id/tv_date_time_value']")
    public static WebElement dateAndTime;

    @FindBy(xpath="//android.widget.TextView[@resource-id='com.jio.myjio:id/tv_ref_no_value1']")
    public static WebElement debitBank;

    @FindBy(id="com.jio.myjio:id/tv_frequency_value")
    public static WebElement freqtype;

    @FindBy(id="com.jio.myjio:id/tv_amount_rule_value")
    public static WebElement amountRule;

    @FindBy(xpath="//android.widget.TextView[@resource-id='com.jio.myjio:id/tv_remark_value']")
    public static WebElement remarks;

    @FindBy(xpath="//android.widget.ImageView[@resource-id='com.jio.myjio:id/ic_mandate_qr']")
    public static WebElement QrCode;

    @FindBy(xpath="//*[@text='Share QR Code']")
    public static WebElement shareQRCode;

    @FindBy(id = "com.jio.myjio:id/tv_money_success_title")
    public static WebElement txnStatusMsg;

    @FindBy(xpath="//android.widget.TextView[@resource-id='com.jio.myjio:id/upitxnstatus']")
    public static WebElement activeStatus;

    @FindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.jio.myjio:id/rl_modify']")
    public static WebElement modifyMandate;

    @FindBy(id="com.jio.myjio:id/rl_cancel")
    public static WebElement cancelMandate;

    @FindBy(xpath="//*[@text='Ok']")
    public static WebElement okButton;

    @FindBy(xpath="//*[@text='Done']")
    public static WebElement doneButton;

    @FindBy(id="com.jio.myjio:id/ic_actionbar_bank_filter")
    public static WebElement filterButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.jio.myjio:id/btn_apply_mandate']")
    public static WebElement applyStatusFilter;



    public  static String modifyLink="//android.widget.RelativeLayout[@resource-id='com.jio.myjio:id/rl_modify']";
    public  static String cancelMandateLink="//[@id='com.jio.myjio:id/rl_cancel']";


    MPinPage mPinPage=new MPinPage();

    public  static void cancelMandate(){
        WaitUtility.averageWait();
        ActionsUtility.swipeUp(androidDriver);
        waitAndActionOnElement(cancelMandate);
        WaitUtility.maximumWait();
        MPinPage.enterMpin("234567");
        WaitUtility.averageWait();
        waitAndActionOnElement(okButton);
        saveScreenshotPNG();
    }

    public static void validateMandateStatus(String status){
        loopToNavigateBack();
        PassbookPage passbookPage=new PassbookPage();
      //  passbookPage.navigateToPassbook();
       passbookPage.validateManageMandateField();
        saveScreenshotPNG();
        WebElement mandateStatus=androidDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.jio.myjio:id/upitxnstatus' and @text='"+status+"']"));
        String mandateUpdatedStatus=mandateStatus.getText();
        assertUtility.assertEqual(mandateUpdatedStatus,status,"mandate status validation failed");

    }

    public static  void validateUMNNumber() throws IOException {
        helperClass.waitForElement(UMNnameTag);
        boolean umnTag=UMNnameTag.isDisplayed();
        assertUtility.assertTrue(umnTag,"UMN tag display");
        String dsipUmnNum=umnNumber.getText();
        log.info(dsipUmnNum+"UmnNumber");
        //validate the length 32 of UMN number
        String[] split=dsipUmnNum.split("@");
        testData.put("UMNNo",dsipUmnNum);
        properties.setProperty("umnNo",dsipUmnNum);
        writeMaptoFile();
        String orgUmnNo=split[0];
        int length=orgUmnNo.length();
        assertUtility.assertEqualNo(length,32,"UMN length validation failed");
        assertUtility.assertEqual(dsipUmnNum.contains("@jio"),"UMN @jio validation failed");

    }

    public static  void validateTrnsxFields() throws InterruptedException, IOException {
        //validate utrNumber
        helperClass.waitForElement(utrNumber);
        boolean utrNo=utrNumber.isDisplayed();
        assertUtility.assertTrue(utrNo,"UMN tag display");
        String dspUtrNo=utrNumber.getText();
        log.info(dspUtrNo+"utrNo");
        testData.put("UtrNo",dspUtrNo);
        properties.setProperty("UTRNUMBER",dspUtrNo);
        //validate dateAndTime
        helperClass.waitForElement(dateAndTime);
        assertUtility.assertTrue(dateAndTime,true,"dateAndTimeValidation failed");
        String dateTime=dateAndTime.getText();
        log.info(dateTime+"date time information");
        testData.put("DateTime",dateTime);
        ActionsUtility.swipeUp(androidDriver);
        //validate debit bank
        helperClass.waitForElement(debitBank);
        String debitBankVal=debitBank.getText();
        log.info(debitBankVal+"debit bank val");
        testData.put("BankDetail",debitBankVal);
        assertUtility.assertTrue(debitBank,true,"debit bank does not appear");
        //validate freq type
        helperClass.waitForElement(debitBank);
        String freType=freqtype.getText();
        log.info(freType+"debit bank val");
        testData.put("FreqType",freType);
        assertUtility.assertTrue(freqtype,true,"freq type does not appear");
        //validate amunt rule
        helperClass.waitForElement(amountRule);
        String amounRuleVal=amountRule.getText();
        log.info(amounRuleVal+"debit bank val");
        testData.put("amountRule",amounRuleVal);
        assertUtility.assertTrue(amountRule,true,"amount rule does not appear");
        writeMaptoFile();
        //validate remarks
      //  helperClass.waitForElement(remarks);
      //  assertUtility.assertTrue(remarks,true,"remarks does not appear");

    }

    public static  void validateTransactionStatus() throws InterruptedException, IOException {
        helperClass.waitForElement(txnStatusMsg);
        String finalTxnMsg=txnStatusMsg.getText();
        ManageMandatePage ManageMandatePage=new ManageMandatePage();

        try
        {
            if (finalTxnMsg.equals(properties.getProperty("Mandate_SUCCESS_STATUS")))
            {
                WaitUtility.averageWait();
                //validate txn fields
                validateTrnsxFields();
                //validate UMN
                validateUMNNumber();
                ManageMandatePage.doneButton.click();

                log.info("mandate successful Transaction");
            }else if (finalTxnMsg.equals(properties.getProperty("Mandate_FAIL_STATUS")))
            {
                WaitUtility.averageWait();
                //validate txn fields
                validateTrnsxFields();
                //validate UMN
                validateUMNNumber();
                ManageMandatePage.doneButton.click();
                System.out.println(finalTxnMsg+"failed status");
            }
        }catch (Exception e1){

            if (finalTxnMsg.equals(properties.getProperty("Mandate_PENDING_STATUS")))
            {
                WaitUtility.averageWait();
                //validate txn fields
                validateTrnsxFields();
                //validate UMN
                validateUMNNumber();
                ManageMandatePage.doneButton.click();
                System.out.println("pending  Transaction");
            }else {
                e1.printStackTrace();
            }
        }


    }

    {
}
     public void applyFilter(String status){
        waitAndActionOnElement(filterButton);
        WebElement statusCheckbox=androidDriver.findElement(By.xpath("//android.widget.TextView[@text='"+status+"']//following-sibling::android.widget.CheckBox[@resource-id='com.jio.myjio:id/chk_"+status.toLowerCase()+"_mandate']"));
        waitAndActionOnElement(statusCheckbox);
        WebElement statusVal=androidDriver.findElement(By.xpath("//android.widget.TextView[@text='"+status+"']"));
        String statustext=statusVal.getText();
        System.out.println(statustext);
        waitAndActionOnElement(applyStatusFilter);
        saveScreenshotPNG();
        assertUtility.assertTrue(androidDriver.getPageSource().contains(status.toUpperCase(Locale.ROOT)),"status validation failed");
     }



}
