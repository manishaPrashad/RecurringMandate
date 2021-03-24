package ApiAutomation;

import ComponentFile.ApiComponent;
import DataProvider.BrowserNameProvider;
import UPIScripts.PayButtonFunctionality;
import UPIScripts.RevokeButtonFunctionality;
import Utils.CommonMethods;
import Utils.Reporter;
import base.APIEndPoints;
import base.Constants;
import base.SetUp;
import base.AppUIBaseClass;
import com.utilities.webUtils.WaitUtility;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class RecurringMandateByPayee extends SetUp {
    ApiComponent apiComponent;
    CommonMethods commMethod;
    PayButtonFunctionality payButtonFunctionality;
    RevokeButtonFunctionality revokeButtonFunctionality;

    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:ReccuringCreateMandate_Payee", "API", "RecurringMandate", "PositiveScenario"})
    public void RecurringMandatePP(HashMap myData) throws IOException, InterruptedException {
        Reporter.initiateTestReport(RecurringMandateByPayee.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response=apiComponent.getResponseCreateByPayee(myData);
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        commMethod.validateResponseField(response,status_Json_Path, status_Initiated);
        String getTxndId=commMethod.getValueFromResponse(response, txnId);

        response=apiComponent.getResponseMandateCheckStatusGet(null,getTxndId);
        apiComponent.writeToNotepad(APIEndPoints.recMandateCheckStatus+getTxndId,"no request data",response.headers(),response.prettyPrint(),(String) myData.get("TestDescription"),"getResponseMandateCheckStatusGet");
       commMethod.validateResponseField(response,mandatePayerstatus_Json_Path, status_Success);
       commMethod.validateResponseField(response,mandatePayeestatus_Json_Path, status_Pending);

    }


    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:ReccuringCreateMandate_Payee", "API", "RecurringMandate", "PositiveScenario"})
    public void RecurringMandateCreateByPayeeNegative_AFTER_EXACT(HashMap myData) throws IOException {
        Reporter.initiateTestReport(RecurringMandateByPayee.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response = apiComponent.getResponseCreateByPayee(myData);
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        System.out.println(response.prettyPrint()+"response");
        commMethod.validateResponseField(response,status_Json_Path, status_Initiated);
        String getTxndId=commMethod.getValueFromResponse(response, txnId);
        response=apiComponent.getResponseMandateCheckStatusGet(null,getTxndId);
        apiComponent.writeToNotepad(APIEndPoints.recMandateCheckStatus+getTxndId,"no request data",response.headers(),response.prettyPrint(),(String) myData.get("TestDescription"),"getResponseMandateCheckStatusGet");
        commMethod.validateResponseField(response,mandatePayerstatus_Json_Path, status_Success);
        commMethod.validateResponseField(response,mandatePayeestatus_Json_Path, status_Pending);

    }

    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:ReccuringCreateMandate_Payee", "API", "RecurringMandate", "PositiveScenario"})
    public void RecurringMandateCreateByPayeeNegative_AFTER_MAX(HashMap myData) throws IOException {
        Reporter.initiateTestReport(RecurringMandateByPayee.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response = apiComponent.getResponseCreateByPayee(myData);
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        System.out.println(response.prettyPrint()+"response");
        commMethod.validateResponseField(response,status_Json_Path, status_Initiated);
        String getTxndId=commMethod.getValueFromResponse(response, txnId);
        response=apiComponent.getResponseMandateCheckStatusGet(null,getTxndId);
        apiComponent.writeToNotepad(APIEndPoints.recMandateCheckStatus+getTxndId,"no request data",response.headers(),response.prettyPrint(),(String) myData.get("TestDescription"),"getResponseMandateCheckStatusGet");
        commMethod.validateResponseField(response,mandatePayerstatus_Json_Path, status_Success);
        commMethod.validateResponseField(response,mandatePayeestatus_Json_Path, status_Pending);

    }

    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:ReccuringCreateMandate_Payee", "API", "RecurringMandate", "PositiveScenario"})
    public void RecurringMandateCreateByPayeeNegative_BEFORE_EXACT(HashMap myData) throws IOException {
        Reporter.initiateTestReport(RecurringMandateByPayee.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response = apiComponent.getResponseCreateByPayee(myData);
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        System.out.println(response.prettyPrint()+"response");
        commMethod.validateResponseField(response,status_Json_Path, status_Initiated);
        String getTxndId=commMethod.getValueFromResponse(response, txnId);
        response=apiComponent.getResponseMandateCheckStatusGet(null,getTxndId);
        apiComponent.writeToNotepad(APIEndPoints.recMandateCheckStatus+getTxndId,"no request data",response.headers(),response.prettyPrint(),(String) myData.get("TestDescription"),"getResponseMandateCheckStatusGet");
        commMethod.validateResponseField(response,mandatePayerstatus_Json_Path, status_Success);
        commMethod.validateResponseField(response,mandatePayeestatus_Json_Path, status_Pending);

    }

    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:ReccuringCreateMandate_Payee", "API", "RecurringMandate", "PositiveScenario"})
    public void RecurringMandateCreateByPayeeNegative_BEFORE_MAX(HashMap myData) throws IOException {
        Reporter.initiateTestReport(RecurringMandateByPayee.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response = apiComponent.getResponseCreateByPayee(myData);
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        System.out.println(response.prettyPrint()+"response");
        commMethod.validateResponseField(response,status_Json_Path, status_Initiated);
        String getTxndId=commMethod.getValueFromResponse(response, txnId);
        response=apiComponent.getResponseMandateCheckStatusGet(null,getTxndId);
        apiComponent.writeToNotepad(APIEndPoints.recMandateCheckStatus+getTxndId,"no request data",response.headers(),response.prettyPrint(),(String) myData.get("TestDescription"),"getResponseMandateCheckStatusGet");

        commMethod.validateResponseField(response,mandatePayerstatus_Json_Path, status_Success);
        commMethod.validateResponseField(response,mandatePayeestatus_Json_Path, status_Pending);

    }

    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:ReccuringCreateMandate_Payee", "API", "RecurringMandate", "PositiveScenario"})
    public void RecurringMandateCreateByPayeeNegative_ON_EXACT(HashMap myData) throws IOException {
        Reporter.initiateTestReport(RecurringMandateByPayee.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response = apiComponent.getResponseCreateByPayee(myData);
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        System.out.println(response.prettyPrint()+"response");
        commMethod.validateResponseField(response,status_Json_Path, status_Initiated);
        String getTxndId=commMethod.getValueFromResponse(response, txnId);
        response=apiComponent.getResponseMandateCheckStatusGet(null,getTxndId);
        apiComponent.writeToNotepad(APIEndPoints.recMandateCheckStatus+getTxndId,"no request data",response.headers(),response.prettyPrint(),(String) myData.get("TestDescription"),"getResponseMandateCheckStatusGet");

        commMethod.validateResponseField(response,mandatePayerstatus_Json_Path, status_Success);
        commMethod.validateResponseField(response,mandatePayeestatus_Json_Path, status_Pending);

    }

    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:ReccuringCreateMandate_Payee", "API", "RecurringMandate", "PositiveScenario"})
    public void RecurringMandateCreateByPayeeNegative_ON_MAX(HashMap myData) throws IOException {
        Reporter.initiateTestReport(RecurringMandateByPayee.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response = apiComponent.getResponseCreateByPayee(myData);
        commMethod.writeToFile("RecurringMandateCreateByPayeeNegative_ON_MAX",response.prettyPrint(), apiComponent.createRecMandateByPayeePayload(myData), (String) myData.get("TestDescription"),myData);
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        System.out.println(response.prettyPrint()+"response");
        commMethod.validateResponseField(response,status_Json_Path, status_Initiated);
        String getTxndId=commMethod.getValueFromResponse(response, txnId);
        response=apiComponent.getResponseMandateCheckStatusGet(null,getTxndId);
        apiComponent.writeToNotepad(APIEndPoints.recMandateCheckStatus+getTxndId,"no request data",response.headers(),response.prettyPrint(),(String) myData.get("TestDescription"),"getResponseMandateCheckStatusGet");

        commMethod.validateResponseField(response,mandatePayerstatus_Json_Path, status_Success);
        commMethod.validateResponseField(response,mandatePayeestatus_Json_Path, status_Pending);

    }



    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:ReccuringCreateMandate_Payee", "API", "RecurringMandate", "PositiveScenario"})
    public void RecurringMandateCreateByPayeeBackDateScenario(HashMap myData) throws IOException {
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

    }


    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:ReccuringCreateMandate_Payee", "API", "RecurringMandate", "NegativeScenario"})
    public void RecurringMandateCreateByPayeeNegative(HashMap myData) {
        Reporter.initiateTestReport(RecurringMandateByPayee.class, String.format((String) myData.get("TestDescription")));
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        Response response = apiComponent.getResponseCreateByPayee(myData);
        commMethod.validateResponseStatusCode(response, responseCode_Success);
        commMethod.validateResponseField(response, status_Json_Path,status_Success);
    }


    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:ReccuringCreateMandate_Payee", "API", "RecurringMandate", "PositiveScenario"})
    public void RecurringMandateCreateByPayeeMonthlyTest(HashMap myData) throws IOException {
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
    }


    @Test(dataProvider = "BrowserNameList", dataProviderClass = BrowserNameProvider.class, groups = {"SheetName:ReccuringCreateMandate_Payee", "API", "RecurringMandate", "PositiveScenario"})
    public void RevokeMandateWithValidMpin(HashMap myData) throws IOException, InterruptedException {
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
        payButtonFunctionality.payButtonFunctionalityScript("Jio Payments Bank limited",properties.getProperty("ValidMpin"));
        revokeButtonFunctionality=new RevokeButtonFunctionality();
        revokeButtonFunctionality.validateRevokeFunctionality("revokeOk",properties.getProperty("ValidMpin"),"REVOKEDj");

    }

    @Test
    public void tt(){
        System.out.println(RecurringMandateByPayee.class.getMethods().getClass().getTypeName());
    }

}
