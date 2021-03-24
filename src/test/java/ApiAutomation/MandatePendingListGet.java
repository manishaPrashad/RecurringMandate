package ApiAutomation;

import ComponentFile.ApiComponent;
import DataProvider.BrowserNameProvider;
import Utils.CommonMethods;
import Utils.Reporter;
import base.SetUp;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

public class MandatePendingListGet extends SetUp {
    ApiComponent apiComponent;
    CommonMethods commMethod;

    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:MandatePendingList", "API", "MandatePendingList", "NegativeScenario"})
    public void MandatePendingListGetTestNegative(HashMap myData) {
        Reporter.initiateTestReport(MandatePendingListGet.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response = apiComponent.getResponseMandatePendingListGet(myData,(String) myData.get("transactionId"));
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        commMethod.validateResponseField(response, mandatePayerstatus_Json_Path,status_Success);
    }
}
