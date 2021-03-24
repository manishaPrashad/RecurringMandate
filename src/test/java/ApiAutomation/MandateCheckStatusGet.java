package ApiAutomation;

import ComponentFile.ApiComponent;
import DataProvider.BrowserNameProvider;
import Utils.CommonMethods;
import Utils.Reporter;
import base.SetUp;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

public class MandateCheckStatusGet extends SetUp {
    ApiComponent apiComponent;
    CommonMethods commMethod;

    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:MandateChkStatusGet", "API", "MandateCheckStatus", "NegativeScenario"})
    public  void MandateCheckStatusGetTestNegative(HashMap myData) {
        Reporter.initiateTestReport(MandateCheckStatusGet.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response = apiComponent.getResponseMandateCheckStatusGet(myData,(String) myData.get("transactionId"));
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        commMethod.validateResponseField(response,mandatePayerstatus_Json_Path, status_Success);
    }

    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:MandateChkStatusGet", "API", "MandateCheckStatus", "NegativeScenario"})
    public  void MandateCheckStatusGetTestPsitive(HashMap myData) {
        Reporter.initiateTestReport(MandateCheckStatusGet.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response = apiComponent.getResponseMandateCheckStatusGet(myData,(String) myData.get("transactionId"));
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        commMethod.validateResponseField(response,mandatePayerstatus_Json_Path, status_Success);
    }




}
