package Utils;

import ComponentFile.ApiComponent;
import Pages.TransactionSummaryPage;
import UPIScripts.PayButtonFunctionality;
import UPIScripts.SuspendAndResumeFunctionality;
import base.Constants;
import base.SetUp;
import base.AppUIBaseClass;
import com.utilities.fileUtils.PropertiesUtility;
import com.utilities.webUtils.WaitUtility;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.junit.Assert.assertThat;


public class CommonMethods extends SetUp {
    ApiComponent apiComponent;
    CommonMethods commMethod;
    PayButtonFunctionality payButtonFunctionality;


    public void validateResponseStatusCode(Response response, String statusCode) {
        try {
            Assert.assertEquals(response.statusCode() + "", statusCode, "Response status code is equal to : " + statusCode);
            Reporter.logReport(CommonMethods.class, Constants.log_Type_Pass, "Response code matches with : " + statusCode, null);
        } catch (Exception e) {
            Reporter.logReport(CommonMethods.class, log_Type_Fail, "Response code mismatch actual : " + response.statusCode() + " , Expected : " + statusCode, e);
            throw new RuntimeException("error while validating response code.", e);
        }
    }

    public void validateResponseSchema(Response response, String schemaFilePath) {
        try {
            String responseBody = response.getBody().asString();
            File fTemp = new File(schemaFilePath);
            assertThat(responseBody, matchesJsonSchema(fTemp));
            Reporter.logReport(CommonMethods.class, Constants.log_Type_Pass, "Response Schema matches", null);
        } catch (Exception e) {
            Reporter.logReport(CommonMethods.class, log_Type_Fail, "Response Schema mismatch ", e);
            throw new RuntimeException("Response Schema mismatch.", e);
        }
    }

    public void validateResponseStatusMessage(Response response,String statusValue) {
        try {
            JsonPath jsonPathEvaluator = response.jsonPath();
            String status = jsonPathEvaluator.get("status");
            Assert.assertEquals(status, statusValue, "Response Body Status Message is equal to : " + statusValue);
            Reporter.logReport(CommonMethods.class, Constants.log_Type_Pass, "Response Body Status Message matches : " + statusValue, null);

        } catch (Exception e) {
            Reporter.logReport(CommonMethods.class, log_Type_Fail, "Response Body Status Message Mismatch ", e);
            throw new RuntimeException("Response Body Status Message Mismatch .", e);
        }
    }

    public void validateResponseField(Response response,String jsonPath, String statusValue) {
        SoftAssert softAssert=new SoftAssert();
        try {
            JsonPath jsonPathEvaluator = response.jsonPath();
            String status = jsonPathEvaluator.get(jsonPath);
            softAssert.assertEquals(status, statusValue, "Response Body Status Message is equal to : " + statusValue+"response validation failed");
            Reporter.logReport(CommonMethods.class, Constants.log_Type_Pass, "Response Body Status Message matches : " + statusValue, null);
        } catch (Exception e) {
            Reporter.logReport(CommonMethods.class, log_Type_Fail, "Response Body Status Message Mismatch ", e);
            throw new RuntimeException("Response Body Status Message Mismatch .", e);
        }
    }

    public String returnResponseStatus(Response response,String jsonPath) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        String status = jsonPathEvaluator.get(jsonPath);
        //   Reporter.logReport(CommonMethods.class, Constants.log_Type_Pass, "Response Body Status Message matches : " , null);
        return status;
    }

    public void assertResponseMethod(Response response,String jsonPath){
        JsonPath jsonPathEvaluator = response.jsonPath();
        String statusVal = jsonPathEvaluator.get(jsonPath);
        if(statusVal.equals(status_Success)||statusVal.equals(status_Initiated)){
            Assert.assertEquals(statusVal,status_Success, "Response Body Status Message is equal to : " + statusVal);
            Reporter.logReport(CommonMethods.class, Constants.log_Type_Pass, "Response Body Status Message matches : "+statusVal , null);
        }else if(statusVal.equals(status_Pending)){
            Assert.assertEquals(statusVal,status_Pending, "Response Body Status Message is equal to : " + statusVal);
            Reporter.logReport(CommonMethods.class,Constants.log_Type_Fail,"Response Body Status Message matches : "+statusVal , null);
        } else if(statusVal.equals(status_Failure)){
          //  Assert.assertEquals(statusVal,status_Failure, "Response Body Status Message is equal to : " + statusVal);
            Reporter.logReport(CommonMethods.class,Constants.log_Type_Fail,"Response Body Status Message matches : "+statusVal , null);
        }

    }



    public void getStartDateCount(){

    }


    public static String getTimeStamp() {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd 00:00:00.00").format(new Date());
        String finalTimestamp = timeStamp.replace(" ", "T");
        return finalTimestamp.concat("Z");
    }

    public static String generateRndom() {
        Random random = new Random();
        int num = 0;
        for (int j = 1; j <= 9; j++) {
            num = random.nextInt(100);
        }
        return String.valueOf(num);

    }
    public static String getSaltString() {
        String adddValue = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * adddValue.length());
            salt.append(adddValue.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }


    //  JIOl1Y421H3gDyfD1F14DM1G9MBw02Z

    public static String generateIdempotentKey() {
        properties = PropertiesUtility.getApplicationProperties(configFileName);
        String addNum = getSaltString();
        String idempotentId = properties.getProperty("IdempotentKeyVal")+"UtU5w5Ggmk87IfJmk34".concat(addNum);
        return idempotentId;
    }

    public static String constructEndDate(int noOfDays){
        LocalDate today = LocalDate.now();
        LocalDate weekLater=today.plusDays(noOfDays);
        String timeStamp=weekLater.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String addHoursFormat="T23:59:59.999Z";
        return timeStamp.concat(addHoursFormat);
    }

    public static String getEndDateVal(HashMap testData,String HashMapKey){
        int getDaysCount= (Integer.parseInt((String) testData.get(HashMapKey)));
        String endDate=constructEndDate(getDaysCount);
        return endDate;
    }

    public void writeToFile(String apiName, String responseVal,String description,String payload,HashMap myData) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"\\TestData\\ResponseFilePayload.txt", true)));
        BufferedWriter bw = new BufferedWriter(out);
        bw.write(apiName +'\n'+String.valueOf(myData.get(description))+ '\n' +responseVal +'\n'+payload);
        bw.close();

    }

    public static String recurenceVal(int days){
        LocalDate today = LocalDate.now().plusDays(days);
        String date=today.format(DateTimeFormatter.ofPattern("dd"));
        return date;
    }



    public static String fetchValuesFromHashMap(String hashMapKey, HashMap tempData, String caseVal) {
        String tmp = (String) tempData.get(hashMapKey);
        String entityVal = "";
        if (tmp.equals(hashMapKey)) {
            switch (caseVal) {
                case "initiatingEntityTimestamp":
                    tempData.put(hashMapKey, getTimeStamp());
                    entityVal = (String) tempData.get(hashMapKey);
                    break;
                case "scheduledAt":
                    tempData.put(hashMapKey, getTimeStamp());
                    entityVal = (String) tempData.get(hashMapKey);
                    break;
                case "createdAt":
                    tempData.put(hashMapKey, getTimeStamp());
                    entityVal = (String) tempData.get(hashMapKey);
                    break;
                case "idempotentKey":
                    tempData.put(hashMapKey, generateIdempotentKey());
                    entityVal = (String) tempData.get(hashMapKey);
                    break;

            }
        } else {
            entityVal = (String) tempData.get(hashMapKey);
            System.out.println("take data from excel file");
        }
        return entityVal;
    }

    public static String getValueFromResponse(Response response, String ReqParameter)
    {
        try {
            JsonPath jsonPathEvaluator = response.jsonPath();
            String actualValue = jsonPathEvaluator.get(ReqParameter);
            System.out.println(actualValue+"status val");
            Reporter.logReport(CommonMethods.class, Constants.log_Type_Pass, "given parameter is available in response body ", null);
            return actualValue;
        }
        catch  (Exception e)
        {
            Reporter.logReport(CommonMethods.class, log_Type_Fail, "given parameter is not available in response body ", null);
            throw new RuntimeException("given parameter is not available in response body", null);
        }
    }

    public static void validateResponseStatus(Response apiResponse, int apiExpectedStatus) {
        try {

            Assert.assertEquals(apiResponse.getStatusCode(), apiExpectedStatus);

            Reporter.logReport(CommonMethods.class, log_Type_Pass,
                    "collectRequest API status code validated. Status code is  : " + apiResponse.getStatusCode(), null);

        } catch (Exception e) {
            Reporter.logReport(CommonMethods.class, log_Type_Fail,
                    "error while validating the collectRequest API response status.", e);

            throw new RuntimeException("error while validating the collectRequest API response status.", e);
        }
    }

    @Step("Get umn value for APi request")
    public  void getUmnNo(HashMap myData,String entityName,int time,String additionalAct) throws MalformedURLException, InterruptedException {
        apiComponent = new ApiComponent();
        commMethod = new CommonMethods();
        System.out.println("test1");
        AppUIBaseClass.launchAppium();
        System.out.println("test1");
        WaitUtility.averageWait();
        Response response = apiComponent.getResponseCreateByPayee(myData);
        String getTxndId=commMethod.getValueFromResponse(response, txnId);

        PayButtonFunctionality.payButtonFunctionalityScript("Jio Payments Bank limited","2356");
        applyWaitForGetStatus(time);
        System.out.println("umnNoWait");
        response=apiComponent.getResponseMandateCheckStatusGet(null,getTxndId);
        myData.put(entityName,commMethod.getValueFromResponse(response, umnNoValue));
        System.out.println(myData.get(entityName)+"umnNo");
        WaitUtility.averageWait();
        switch (additionalAct){
            case "noAction":
                  AppUIBaseClass.exitApp();
                  break;
            case "Suspend&Resume":
                SuspendAndResumeFunctionality suspendAndResumeFunctionality=new SuspendAndResumeFunctionality();
                suspendAndResumeFunctionality.validateSuspendMandateFunctionality(commMethod.recurenceVal(0),commMethod.recurenceVal(2),properties.getProperty("ValidMpin"),"SUSPENDED");
                //suspend mandate not woring on front end so not able to get the view of resume mandate functionality
                suspendAndResumeFunctionality.resumeMandate(properties.getProperty("ValidMpin"));
                break;
        }


    }}



