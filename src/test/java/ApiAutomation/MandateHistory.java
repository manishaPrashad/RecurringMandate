package ApiAutomation;

import ComponentFile.ApiComponent;
import DataProvider.BrowserNameProvider;
import Utils.CommonMethods;
import Utils.Reporter;
import base.SetUp;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

public class MandateHistory extends SetUp {
    ApiComponent apiComponent;
    CommonMethods commMethod;

    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:MandHistory", "API", "MandateHistory", "PositiveScenario"})
    public void MandateHistoryTest(HashMap myData) {
        Reporter.initiateTestReport(MandateHistory.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response = apiComponent.getResponseMandateHistory(myData);
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        commMethod.validateResponseField(response, status_Json_Path,status_Success);
    }

    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:MandateHistory", "API", "MandateHistory", "NegativeScenario"})
    public void MandateHistoryTestNegative(HashMap myData) {
        Reporter.initiateTestReport(MandateHistory.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response = apiComponent.getResponseMandateHistory(myData);
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        commMethod.validateResponseField(response,status_Json_Path, status_Success);
    }
}
