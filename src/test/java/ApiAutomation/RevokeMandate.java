package ApiAutomation;

import ComponentFile.ApiComponent;
import DataProvider.BrowserNameProvider;
import UPIScripts.PayButtonFunctionality;
import UPIScripts.RevokeButtonFunctionality;
import Utils.CommonMethods;
import Utils.Reporter;
import base.APIEndPoints;
import base.AppUIBaseClass;
import base.SetUp;
import com.utilities.reportUtils.ExtentUtility;
import com.utilities.webUtils.WaitUtility;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class RevokeMandate extends SetUp {
    ApiComponent apiComponent;
    CommonMethods commMethod;
    PayButtonFunctionality payButtonFunctionality;
    RevokeButtonFunctionality revokeButtonFunctionality;

    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:RevokeMandate", "API", "RevokeMandate", "PositiveScenario"})
    public void RevokeMandateTest(HashMap myData) {
        Reporter.initiateTestReport(RevokeMandate.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response = apiComponent.getResponseRevokeMandate(myData);
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        commMethod.validateResponseStatusMessage(response,status_Initiated);
        String getTxndId=commMethod.getValueFromResponse(response, txnIdForOtherMadate);
        response=apiComponent.getResponseMandateCheckStatusGet(null,getTxndId);
        commMethod.validateResponseField(response,mandatePayerstatus_Json_Path, status_Success);
        commMethod.validateResponseField(response,mandatePayeestatus_Json_Path, status_Success);
    }

    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:RevokeMandate", "API", "RevokeMandate", "NegativeScenario"})
    public void RevokeMandateTestNegative(HashMap myData) {
        Reporter.initiateTestReport(RevokeMandate.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response = apiComponent.getResponseRevokeMandate(myData);
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        commMethod.validateResponseField(response,status_Json_Path, status_Success);
    }

    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:ReccuringCreateMandate_Payee", "API", "RecurringMandate", "PositiveScenario"})
    public void RevokeCreatedMandate(HashMap myData) throws IOException, InterruptedException {
        AppUIBaseClass.launchAppium();
        Reporter.initiateTestReport(RevokeMandate.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response = apiComponent.getResponseCreateByPayee(myData);
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        commMethod.validateResponseField(response,status_Json_Path, status_Initiated);
        String getTxndId=commMethod.getValueFromResponse(response, txnId);
        response=apiComponent.getResponseMandateCheckStatusGet(null,getTxndId);
        apiComponent.writeToNotepad(APIEndPoints.recMandateCheckStatus+getTxndId,"no request data",response.headers(),response.prettyPrint(),(String) myData.get("TestDescription"),"getResponseMandateCheckStatusGet");
        commMethod.validateResponseField(response,mandatePayerstatus_Json_Path, status_Success);
        WaitUtility.averageWait();
        WaitUtility.averageWait();

        payButtonFunctionality=new PayButtonFunctionality();
        payButtonFunctionality.payButtonFunctionalityScript("Jio Payments Bank limited",properties.getProperty("mpin"));
        revokeButtonFunctionality=new RevokeButtonFunctionality();
        revokeButtonFunctionality.validateRevokeFunctionality("revokeOk",properties.getProperty("mpin"),"REVOKEDj");

    }


    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:ReccuringCreateMandate_Payee", "API", "RecurringMandate", "PositiveScenario"})
    public void RevokeMandateWithIncorrectUpiPin(HashMap myData) throws IOException, InterruptedException {
        AppUIBaseClass.launchAppium();
        Reporter.initiateTestReport(RecurringMandateByPayee.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response = apiComponent.getResponseCreateByPayee(myData);
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        commMethod.validateResponseField(response,status_Json_Path, status_Initiated);
        String getTxndId=commMethod.getValueFromResponse(response, txnId);
        response=apiComponent.getResponseMandateCheckStatusGet(null,getTxndId);
        apiComponent.writeToNotepad(APIEndPoints.recMandateCheckStatus+getTxndId,"no request data",response.headers(),response.prettyPrint(),(String) myData.get("TestDescription"),"getResponseMandateCheckStatusGet");
        commMethod.validateResponseField(response,mandatePayerstatus_Json_Path, status_Success);
        commMethod.validateResponseField(response,mandatePayeestatus_Json_Path, status_Pending);
        WaitUtility.averageWait();
        WaitUtility.averageWait();
        payButtonFunctionality=new PayButtonFunctionality();
        payButtonFunctionality.payButtonFunctionalityScript("Jio Payments Bank limited",properties.getProperty("incorrectUpiPin"));

        revokeButtonFunctionality=new RevokeButtonFunctionality();
        revokeButtonFunctionality.validateRevokeFunctionality("revokeOk","7898","REVOKEDj");

    }

}
