package UPIScripts;

import Pages.*;
import base.AppUIBaseClass;
import com.utilities.mobileUtils.ActionsUtility;

public class RevokeButtonFunctionality extends AppUIBaseClass {

    public static PassbookPage passbookPage =new PassbookPage();
    public static HomePage homePage=new HomePage();
    public static TransactionSummaryPage transactionSummaryPage=new TransactionSummaryPage();
    public static SMSvalidationPage smSvalidationPage=new SMSvalidationPage();
    public static ManageMandatePage manageMandatePage=new ManageMandatePage();


    public static void validateRevokeFunctionality(String actionToPerform,String mandateStatus,String mpin){
        loopToNavigateBack();
        unloackDevice();
        passbookPage.navigateToPassbook();
        waitAndActionOnElement(passbookPage.manageMandate);
        saveScreenshotPNG();
        unloackDevice();
        waitAndActionOnElement(passbookPage.mandateDetail);
        ActionsUtility.swipeUp(androidDriver);
        transactionSummaryPage.revokeMandate(actionToPerform,mpin);
        saveScreenshotPNG();
        smSvalidationPage.validateRevokeSMS();
        loopToNavigateBack();
        unloackDevice();
        passbookPage.navigateToPassbook();
        waitAndActionOnElement(passbookPage.manageMandate);
        manageMandatePage.validateMandateStatus(mandateStatus);
        saveScreenshotPNG();

    }
}
