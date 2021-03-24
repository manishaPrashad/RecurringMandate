package ApiAutomation;

import ComponentFile.ApiComponent;
import DataProvider.BrowserNameProvider;
import UPIScripts.PayButtonFunctionality;
import Utils.CommonMethods;
import Utils.Reporter;
import base.SetUp;
import base.AppUIBaseClass;
import com.utilities.webUtils.WaitUtility;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.HashMap;

public class ExecuteMandateByChannel extends SetUp {
    ApiComponent apiComponent;
    CommonMethods commMethod;

    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:ExecuteMandate_Channel", "API", "ExecuteMandate", "PositiveScenario"})
    public void ExecuteMandateByChannelTest(HashMap myData) throws MalformedURLException, InterruptedException {
        Reporter.initiateTestReport(MandateHistory.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        commMethod.getUmnNo(myData,"umnNo",5,"noAction");
        Response response = apiComponent.getResponseExecuteMandateByChannel(myData, (String) myData.get("umnNo"));
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        commMethod.validateResponseField(response,status_Json_Path, status_Initiated);
        String getTxndId=commMethod.getValueFromResponse(response, txnId);
        response=apiComponent.getResponseMandateCheckStatusGet(null,getTxndId);
        commMethod.validateResponseField(response,mandatePayerstatus_Json_Path, status_Initiated);
        WaitUtility.maximumWait();
        AppUIBaseClass.launchAppium();
        PayButtonFunctionality.payButtonFunctionalityScript("Jio",properties.getProperty("ValidMpin"));

    }

    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:ExecuteMandate_Channel", "API", "ExecuteMandate", "PositiveScenario"})
    public void ExecuteMandateAfterResume(HashMap myData) throws MalformedURLException, InterruptedException {
        Reporter.initiateTestReport(MandateHistory.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        commMethod.getUmnNo(myData,"umnNo",0,"Suspend&Resume");
        //prform suspend and resume
        AppUIBaseClass.logToReport("perform suspend and resume");

        Response response = apiComponent.getResponseExecuteMandateByChannel(myData, (String) myData.get("umnNo"));
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        commMethod.validateResponseField(response,status_Json_Path, status_Initiated);
        String getTxndId=commMethod.getValueFromResponse(response, txnId);
        response=apiComponent.getResponseMandateCheckStatusGet(null,getTxndId);
        commMethod.validateResponseField(response,mandatePayerstatus_Json_Path, status_Initiated);
        WaitUtility.maximumWait();
        AppUIBaseClass.launchAppium();
        PayButtonFunctionality.payButtonFunctionalityScript("Jio",properties.getProperty("ValidMpin"));

    }

    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:ExecuteMandate_Channel", "API", "ExecuteMandate", "NegativeScenario"})
    public void ExecuteMandateByChannelTestNegative(HashMap myData) {
        Reporter.initiateTestReport(MandateHistory.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response = apiComponent.getResponseExecuteMandateByChannel(myData, (String) myData.get("transaction__standingInstruction__uniqueMandateNumber"));
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        commMethod.validateResponseField(response,status_Json_Path, status_Success);
    }
}
