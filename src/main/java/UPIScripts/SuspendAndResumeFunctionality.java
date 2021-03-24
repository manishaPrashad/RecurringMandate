package UPIScripts;

import Pages.*;
import base.AppUIBaseClass;
import com.utilities.mobileUtils.ActionsUtility;

public class SuspendAndResumeFunctionality extends AppUIBaseClass {

    public static PassbookPage passbookPage =new PassbookPage();
    public static HomePage homePage=new HomePage();
    public static TransactionSummaryPage transactionSummaryPage=new TransactionSummaryPage();
    public static SMSvalidationPage smSvalidationPage=new SMSvalidationPage();
    public static ManageMandatePage manageMandatePage=new ManageMandatePage();


    public static void validateSuspendMandateFunctionality(String startDate,String endDate,String mpinNo,String mandateStatus){
        transactionSummaryPage.getManageMandateButtn();
        //apply filter
        manageMandatePage.applyFilter("Active");
        waitAndActionOnElement(passbookPage.mandateDetail);
        ActionsUtility.swipeUp(androidDriver);
        transactionSummaryPage.performeSuspend(startDate,endDate,mpinNo);
        saveScreenshotPNG();
        manageMandatePage.validateMandateStatus(mandateStatus);
        saveScreenshotPNG();

    }

    public void validateResumeMandateFunctionality(String mpinNo,String mandateStatus){
        loopToNavigateBack();
        waitAndActionOnElement(passbookPage.suspendedMndate);
        ActionsUtility.swipeUp(androidDriver);
        transactionSummaryPage.performeResume(mpinNo);
        saveScreenshotPNG();
        loopToNavigateBack();
        saveScreenshotPNG();
        loopToNavigateBack();
      //  waitAndActionOnElement(passbookPage.manageMandate);
       // manageMandatePage.validateMandateStatus(mandateStatus);
    }

    public void resumeMandate(String mpinNo){
        transactionSummaryPage.performeResume(mpinNo);

    }



}
