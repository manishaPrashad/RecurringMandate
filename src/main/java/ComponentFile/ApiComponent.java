
package ComponentFile;

import RequestEntity.*;
import RequestEntity.ExecuteMandateByChannel.ExecuteMandateByChannelEntity;
import RequestEntity.MandateHistory.MandateHistoryEntity;
import RequestEntity.RecurringMandateByPayee.RecurringMandateByPayeeEntity;
import RequestEntity.RevokeMandate.RevokeMandateEntity;
import RequestEntity.SuspendOrResumeMandate.SuspendOrResumeMandateEntity;
import RequestEntity.UpdateMandate.UpdateMandateEntity;
import Utils.CommonMethods;
import Utils.Reporter;
import base.APIEndPoints;
import base.SetUp;
import com.google.gson.Gson;
import com.utilities.apiUtils.RestUtil;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApiComponent extends SetUp {

    Gson request = new Gson();
    CommonMethods commMethod;

    String folderPath=System.getProperty("user.dir")+"\\TestData\\API Responses";
    public Response getResponseCreateByPayee(HashMap myData) {
        try {
            Response response = null;
            String payload = createRecMandateByPayeePayload(myData);
            Map<String, String> request = new HashMap<String, String>();
            request.put("X-CHANNEL-ID", (String) myData.get("x-channel-id"));
            request.put("X-API-KEY", (String) myData.get("x-api-key"));
            request.put("X-DEVICE-INFO", (String) myData.get("x-device-info"));
            request.put("X-ACCESS-ID", (String) myData.get("x-access-id"));
            request.put("X-AUTH-TOKEN", (String) myData.get("x-auth-token"));
            request.put("Content-Type", (String) myData.get("Content-Type"));
            response = RestUtil.postByJson(payload, APIEndPoints.recMandateByPayee, request);
            writeToNotepad(APIEndPoints.recMandateByPayee,payload,response.headers(),response.prettyPrint(),(String) myData.get("TestDescription"),"getResponseCreateByPayee");
            Reporter.logReport(ApiComponent.class, log_Type_Pass, "Response received against CreateRecMandateByPayee :" + response.prettyPrint(), null);
            return response;
        } catch (Exception e) {
            Reporter.logReport(ApiComponent.class, log_Type_Fail, "error while creating the Create Recurring Mandate By Payee response.", e);
            throw new RuntimeException("error while creating the Create Recurring Mandate By Payee response.", e);
        }
    }

    public String createRecMandateByPayeePayload(HashMap myData) {
        try {
            Transaction transaction=new Transaction();
            transaction.setIdempotentKey(commMethod.fetchValuesFromHashMap("transaction__idempotentKey",myData,"idempotentKey"));
            transaction.setInitiatingEntityTimestamp(commMethod.fetchValuesFromHashMap("transaction__initiatingEntityTimestamp",myData,"initiatingEntityTimestamp"));
            //  transaction.setCreated(commMethod.fetchValuesFromHashMap("transaction__created",myData,"createdAt"));
            transaction.setCreated(commMethod.getEndDateVal(myData,"transaction__created"));
            transaction.setLivemode(Boolean.parseBoolean((String) myData.get("transaction__livemode")));
            transaction.setCurrency(Integer.parseInt((String) myData.get("transaction__currency")));
            transaction.setExpireAfter((String) myData.get("transaction__expireAfter"));
            transaction.setApplication(Integer.parseInt((String) myData.get("transaction__application")));
            transaction.setInvoice((String) myData.get("transaction__invoice"));
            transaction.setStatementDescriptor((String) myData.get("transaction__statementDescriptor"));
            transaction.setDescription((String) myData.get("transaction__description"));
            transaction.setMode(Integer.parseInt((String) myData.get("transaction__mode")));
            Method method=new Method();
            method.setType(Integer.parseInt((String) myData.get("transaction__method__type")));
            method.setSubType(Integer.parseInt((String) myData.get("transaction__method__subType")));
            transaction.setMethod(method);
            InitiatingEntity initiatingEntity=new InitiatingEntity();
            initiatingEntity.setEntityId(Integer.parseInt((String) myData.get("transaction__initiatingEntity__entityId")));
            initiatingEntity.setCallbackUrl((String) myData.get("transaction__initiatingEntity__callbackUrl"));
            transaction.setInitiatingEntity(initiatingEntity);
            StandingInstruction standingInstruction=new StandingInstruction();
            standingInstruction.setFrequency(Integer.parseInt((String) myData.get("transaction__standingInstruction__frequency")));
            // standingInstruction.setScheduledAt(commMethod.fetchValuesFromHashMap("transaction__standingInstruction__scheduledAt",myData,"scheduledAt"));
            standingInstruction.setScheduledAt(commMethod.getEndDateVal(myData,"transaction__standingInstruction__scheduledAt"));
            standingInstruction.setScheduledEnd(commMethod.getEndDateVal(myData,"transaction__standingInstruction__scheduledEnd"));
            standingInstruction.setShare(Boolean.parseBoolean((String) myData.get("transaction__standingInstruction__share")));
            standingInstruction.setRevocable(Boolean.parseBoolean((String) myData.get("transaction__standingInstruction__revocable")));
            standingInstruction.setRuleRecurrence((String) myData.get("transaction__standingInstruction__ruleRecurrence"));
            standingInstruction.setRuleRecurrenceValue((String) myData.get("transaction__standingInstruction__ruleRecurrenceValue"));
            standingInstruction.setRuleAmountValue(Float.parseFloat((String)myData.get("transaction__standingInstruction__ruleAmountValue")));
            standingInstruction.setRuleAmount((String) myData.get("transaction__standingInstruction__ruleAmount"));
            standingInstruction.setBlockFund(Boolean.parseBoolean((String) myData.get("transaction__standingInstruction__blockFund")));
            transaction.setStandingInstruction(standingInstruction);
            Payer payer=new Payer();
            payer.setName((String) myData.get("payer__name"));
            payer.setVpa((String) myData.get("payer__vpa"));
            Payee payee=new Payee();
            payee.setVpa((String) myData.get("payee__vpa"));
            Amount amount=new Amount();
            amount.setNetAmount(Float.parseFloat((String) myData.get("amount__netAmount")));
            RecurringMandateByPayeeEntity recurringMandateByPayeeEntity=new RecurringMandateByPayeeEntity();
            recurringMandateByPayeeEntity.setTransaction(transaction);
            recurringMandateByPayeeEntity.setPayer(payer);
            recurringMandateByPayeeEntity.setPayee(payee);
            recurringMandateByPayeeEntity.setAmount(amount);
            String payload = request.toJson(recurringMandateByPayeeEntity);
            Reporter.logReport(ApiComponent.class, log_Type_Pass,
                    "Create Recurring Mandate By Payee Api. Payload : " + payload, null);
            return payload;
        } catch (Exception e) {
            Reporter.logReport(ApiComponent.class, log_Type_Fail, "error while creating the Create Recurring Mandate By Payee payload.", e);
            throw new RuntimeException("error while creating the Create Recurring Mandate By Payee payload.", e);
        }

    }

    public Response getResponseMandateHistory(HashMap myData)
    {
        try {
            Response response = null;
            String payload = createMandateHistoryPayload(myData);

            Map<String, String> request = new HashMap<String, String>();
            request.put("Content-Type", (String) myData.get("Content-Type"));
            request.put("X-CHANNEL-ID", (String) myData.get("x-channel-id"));
            request.put("X-API-KEY", (String) myData.get("x-api-key"));
            request.put("X-DEVICE-INFO", (String) myData.get("x-device-info"));
            request.put("X-ACCESS-ID", (String) myData.get("x-access-id"));
            request.put("X-AUTH-TOKEN", (String) myData.get("x-auth-token"));

            String apiEndpoint=APIEndPoints.recMandateHistory+myData.get("userId");
            System.out.println(apiEndpoint+"mandateHistory");

            response = RestUtil.postByJson(payload, apiEndpoint, request);
            Reporter.logReport(ApiComponent.class, log_Type_Pass, "Response received against Mandate History :" + response.prettyPrint(), null);
            return response;
        } catch (Exception e) {
            Reporter.logReport(ApiComponent.class, log_Type_Fail, "error while creating the Mandate History response.", e);
            throw new RuntimeException("error while creating Mandate History response.", e);
        }
    }

    private String createMandateHistoryPayload(HashMap myData)
    {
        try
        {
            MandateHistoryEntity manHistEnty=new MandateHistoryEntity();
            manHistEnty.setStartDate(commMethod.fetchValuesFromHashMap("startDate",myData,"scheduledAt"));
            manHistEnty.setEndDate(commMethod.getEndDateVal(myData,"endDate"));

            manHistEnty.setPageSize((String) myData.get("pageSize"));
            manHistEnty.setLastPageNum((String) myData.get("lastPageNum"));
            manHistEnty.setEntryType((String) myData.get("entryType"));
            String payload = request.toJson(manHistEnty);
            Reporter.logReport(ApiComponent.class, log_Type_Pass,
                    "Create Mandate History Api. Payload : " + payload, null);
            return payload;
        }
        catch(Exception e) {
            Reporter.logReport(ApiComponent.class, log_Type_Fail, "error while creating Mandate History payload.", e);
            throw new RuntimeException("error while creating the Mandate History payload.", e);
        }
    }

    public Response getResponseUpdateMandate(HashMap myData,String umnNo)
    {
        try {
            Response response = null;
            String payload = createUpdateMandatePayload(myData,umnNo);


            Map<String, String> request = new HashMap<String, String>();
            request.put("X-CHANNEL-ID", (String) myData.get("x-channel-id"));
            request.put("X-API-KEY", (String) myData.get("x-api-key"));
            request.put("X-DEVICE-INFO", (String) myData.get("x-device-info"));
            request.put("X-ACCESS-ID", (String) myData.get("x-access-id"));
            request.put("X-AUTH-TOKEN", (String) myData.get("x-auth-token"));
            request.put("Content-Type", (String) myData.get("Content-Type"));


            response = RestUtil.postByJson(payload, APIEndPoints.recUpdateMandate, request);
            writeToNotepad(APIEndPoints.recUpdateMandate,payload,response.headers(),response.prettyPrint(),(String) myData.get("TestDescription"),"getResponseCreateByPayee");

            Reporter.logReport(ApiComponent.class, log_Type_Pass, "Response received against Update Mandate :" + response.prettyPrint(), null);
            return response;
        } catch (Exception e) {
            Reporter.logReport(ApiComponent.class, log_Type_Fail, "error while creating the  Update Mandate response.", e);
            throw new RuntimeException("error while creating  Update Mandate response.", e);
        }
    }

    private String createUpdateMandatePayload(HashMap myData,String umnNo)
    {
        try
        {
            UpdateMandateEntity updateMandate=new UpdateMandateEntity();

            updateMandate.setIdempotentKey(commMethod.fetchValuesFromHashMap("idempotentKey",myData,"idempotentKey"));
            updateMandate.setUniqueMandateNumber(umnNo);
            updateMandate.setEndDate(commMethod.getEndDateVal(myData,"endDate"));

            updateMandate.setAmount((String) myData.get("amount"));
            updateMandate.setUserId((String) myData.get("userId"));
            updateMandate.setMobileNumber((String) myData.get("mobileNumber"));
            updateMandate.setUserType((String) myData.get("userType"));
            String payload = request.toJson(updateMandate);
            Reporter.logReport(ApiComponent.class, log_Type_Pass,
                    "Create  Update Mandate Api. Payload : " + payload, null);
            return payload;
        }
        catch(Exception e) {
            Reporter.logReport(ApiComponent.class, log_Type_Fail, "error while creating Update Mandate payload.", e);
            throw new RuntimeException("error while creating the Update Mandate payload.", e);
        }
    }

    public Response getResponseRevokeMandate(HashMap myData) 
    {
        try {
            Response response = null;
            String payload = createRevokeMandatePayload(myData);


            Map<String, String> request = new HashMap<String, String>();
            request.put("X-CHANNEL-ID", (String) myData.get("x-channel-id"));
            request.put("X-API-KEY", (String) myData.get("x-api-key"));
            request.put("X-DEVICE-INFO", (String) myData.get("x-device-info"));
            request.put("X-ACCESS-ID", (String) myData.get("x-access-id"));
            request.put("X-AUTH-TOKEN", (String) myData.get("x-auth-token"));
            request.put("Content-Type", (String) myData.get("Content-Type"));


            response = RestUtil.postByJson(payload, APIEndPoints.recRevokeMandate, request);
            Reporter.logReport(ApiComponent.class, log_Type_Pass, "Response received against Revoke Mandate :" + response.prettyPrint(), null);
            return response;
        } catch (Exception e) {
            Reporter.logReport(ApiComponent.class, log_Type_Fail, "error while creating the  Revoke Mandate response.", e);
            throw new RuntimeException("error while creating  Revoke Mandate response.", e);
        }
    }

    private String createRevokeMandatePayload(HashMap myData)
    {
        try
        {
            RevokeMandateEntity revokeMandate=new RevokeMandateEntity();
            revokeMandate.setIdempotentKey(commMethod.fetchValuesFromHashMap("idempotentKey",myData,"idempotentKey"));

            revokeMandate.setUniqueMandateNumber((String) myData.get("uniqueMandateNumber"));
            revokeMandate.setUserId((String) myData.get("userId"));
            revokeMandate.setUserType((String) myData.get("userType"));

            String payload = request.toJson(revokeMandate);
            Reporter.logReport(ApiComponent.class, log_Type_Pass,
                    "Create  Revoke Mandate Api. Payload : " + payload, null);
            return payload;
        }
        catch(Exception e) {
            Reporter.logReport(ApiComponent.class, log_Type_Fail, "error while creating Revoke Mandate payload.", e);
            throw new RuntimeException("error while creating the Revoke Mandate payload.", e);
        }
    }

    public Response getResponseSuspendResumeMandate(HashMap myData)
    {
        try {
            Response response = null;
            String payload = createSuspendResumeMandatePayload(myData);


            Map<String, String> request = new HashMap<String, String>();
            request.put("Content-Type", (String) myData.get("Content-Type"));
            request.put("X-CHANNEL-ID", (String) myData.get("x-channel-id"));
            request.put("X-API-KEY", (String) myData.get("x-api-key"));
            request.put("X-DEVICE-INFO", (String) myData.get("x-device-info"));
            request.put("X-ACCESS-ID", (String) myData.get("x-access-id"));
            request.put("X-AUTH-TOKEN", (String) myData.get("x-auth-token"));

            response = RestUtil.postByJson(payload, APIEndPoints.recSuspendOrResumeMandate, request);
            Reporter.logReport(ApiComponent.class, log_Type_Pass, "Response received against Suspend or Resume Mandate :" + response.prettyPrint(), null);
            return response;
        } catch (Exception e) {
            Reporter.logReport(ApiComponent.class, log_Type_Fail, "error while creating the  Suspend or Resume Mandate response.", e);
            throw new RuntimeException("error while creating  Suspend or Resume Mandate response.", e);
        }
    }

    private String createSuspendResumeMandatePayload(HashMap myData)
    {
        try
        {
            SuspendOrResumeMandateEntity suspendResumeMandate=new SuspendOrResumeMandateEntity();
            suspendResumeMandate.setIdempotentKey(commMethod.fetchValuesFromHashMap("idempotentKey",myData,"idempotentKey"));
            suspendResumeMandate.setUniqueMandateNumber((String) myData.get("uniqueMandateNumber"));
            suspendResumeMandate.setUserType((String) myData.get("userType"));
            suspendResumeMandate.setAction((String) myData.get("action"));
            suspendResumeMandate.setStartDate(commMethod.getEndDateVal(myData,"startDate"));

            suspendResumeMandate.setEndDate(commMethod.getEndDateVal(myData,"endDate"));
            suspendResumeMandate.setUserId((String) myData.get("userId"));
            suspendResumeMandate.setMobileNumber((String) myData.get("mobileNumber"));

            SignatureData signatureData=new SignatureData();
            signatureData.setSigner((String) myData.get("signatureData_signer"));
            signatureData.setSignatureValue((String) myData.get("signatureData_signatureValue"));
            signatureData.setSignerKeyIndex((String) myData.get("signatureData_signerKeyIndex"));
            signatureData.setType((String) myData.get("signatureData_type"));
            signatureData.setSubType((String) myData.get("signatureData_subType"));

            suspendResumeMandate.setSignatureData(signatureData);

            String payload = request.toJson(suspendResumeMandate);
            Reporter.logReport(ApiComponent.class, log_Type_Pass,
                    "Create  Suspend or Resume Mandate Api. Payload : " + payload, null);
            return payload;
        }
        catch(Exception e) {
            Reporter.logReport(ApiComponent.class, log_Type_Fail, "error while creating Suspend or Resume Mandate payload.", e);
            throw new RuntimeException("error while creating the Suspend or Resume Mandate payload.", e);
        }
    }


    public Response getResponseExecuteMandateByChannel(HashMap myData,String umnNo) {
        {
            try {
                Response response = null;
                String payload = createExecuteMandateByChannelPayload(myData,umnNo);
                Map<String, String> request = new HashMap<String, String>();
                request.put("Content-Type", (String) myData.get("Content-Type"));
                request.put("X-CHANNEL-ID", (String) myData.get("x-channel-id"));
                request.put("X-API-KEY", (String) myData.get("x-api-key"));
                request.put("X-DEVICE-INFO", (String) myData.get("x-device-info"));
                request.put("X-ACCESS-ID", (String) myData.get("x-access-id"));
                request.put("X-AUTH-TOKEN", (String) myData.get("x-auth-token"));

                response = RestUtil.postByJson(payload, APIEndPoints.executeMandateByChannel, request);
                Reporter.logReport(ApiComponent.class, log_Type_Pass, "Response received against Execute mandate by channel :" + response.prettyPrint(), null);
                return response;
            } catch (Exception e) {
                Reporter.logReport(ApiComponent.class, log_Type_Fail, "error while creating the execute mandate by channel response", e);
                throw new RuntimeException("error while creating the execute mandate by channel response.", e);
            }
        }
    }

    private String createExecuteMandateByChannelPayload(HashMap myData,String umnNO) {
        try{
            Transaction transaction=new Transaction();
            transaction.setIdempotentKey(commMethod.fetchValuesFromHashMap("executetransaction_idempotentKey",myData,"idempotentKey"));
            transaction.setInitiatingEntityTimestamp((String) myData.get("transaction__initiatingEntityTimestamp"));
            transaction.setLivemode(Boolean.parseBoolean((String) myData.get("transaction__livemode")));
            transaction.setInvoice((String) myData.get("transaction__invoice"));
            transaction.setExpireAfter((String) myData.get("transaction__expireAfter"));
            transaction.setApplication(Integer.parseInt((String) myData.get("transaction__application")));
            transaction.setCurrency(Integer.parseInt((String) myData.get("transaction__currency")));
            StandingInstruction standingInstruction=new StandingInstruction();
            standingInstruction.setUniqueMandateNumber(umnNO);
            Method method=new Method();
            method.setType(Integer.parseInt((String) myData.get("transaction__method__type")));
            method.setSubType(Integer.parseInt((String) myData.get("transaction__method__subType")));
            InitiatingEntity initiatingEntity=new InitiatingEntity();
            initiatingEntity.setEntityId(Integer.parseInt((String) myData.get("transaction__initiatingEntity__entityId")));
            Amount amount=new Amount();
            amount.setNetAmount(Float.parseFloat((String) myData.get("executeamount__netAmount")));
            Payer payer=new Payer();
            payer.setVpa((String) myData.get("executepayer__vpa"));
            Payee payee=new Payee();
            payee.setUserId((String) myData.get("executepayee__userId"));
            payee.setVpa((String) myData.get("executepayee__vpa"));
            transaction.setStandingInstruction(standingInstruction);
            transaction.setMethod(method);
            transaction.setInitiatingEntity(initiatingEntity);
            ExecuteMandateByChannelEntity executeMandateByChannelEntity=new ExecuteMandateByChannelEntity();
            executeMandateByChannelEntity.setTransaction(transaction);
            executeMandateByChannelEntity.setAmount(amount);
            executeMandateByChannelEntity.setPayer(payer);
            executeMandateByChannelEntity.setPayee(payee);
            String payload = request.toJson(executeMandateByChannelEntity);
            Reporter.logReport(ApiComponent.class, log_Type_Pass,
                    "Create  execute mandate by channel. Payload : " + payload, null);
            return payload;
        } catch (Exception e) {
            Reporter.logReport(ApiComponent.class, log_Type_Fail, "error while creating execute mandate by channel payload.", e);
            throw new RuntimeException("error while creating execute mandate by channel payload.", e);        }
    }

    public Response getResponseMandatePendingListGet(HashMap myData, String transactionId) {
        {
            try {
                Response response = null;
                Map<String, String> request = new HashMap<String, String>();

                if(myData.size() > 0)
                {
                    request.put("X-CHANNEL-ID", (String) myData.get("x-channel-id"));
                    request.put("X-API-KEY", (String) myData.get("x-api-key"));
                    request.put("X-DEVICE-INFO", (String) myData.get("x-device-info"));
                    request.put("X-ACCESS-ID", (String) myData.get("x-access-id"));
                    request.put("X-AUTH-TOKEN", (String) myData.get("x-auth-token"));
                }
                else
                {
                    request.put("X-CHANNEL-ID","3133");
                    request.put("X-API-KEY", "Fb0Yj56-4WaJ7w-ehJlBx-tqGshFeljE");
                    request.put("X-DEVICE-INFO", "{\"app\":\"com.mgs.jio.qa\",\"capability\":\"5200000200010004000639292929292\",\"os\":\"Android9\",\"ip\":\"127.0.0.1\",\"geocode\":{\"latitude\":\"19.0911\",\"longitude\":\"72.9208\"},\"mobile\":\"919920665290\",\"location\":\"Mumbai\",\"id\":\"864422037322790\",\"type\":\"MOB\"}");
                    request.put("X-ACCESS-ID", "abc");
                    request.put("X-AUTH-TOKEN", "klm");
                }

            String apiEndpoint=APIEndPoints.recMandatePendingList+transactionId;
                response = RestUtil.get(null,request,apiEndpoint);
                Reporter.logReport(ApiComponent.class, log_Type_Pass, "Response received against Mandate Pending List :" + response.prettyPrint(), null);
                return response;
            } catch (Exception e) {
                Reporter.logReport(ApiComponent.class, log_Type_Fail, "error while creating the   Mandate Pending List response.", e);
                throw new RuntimeException("error while creating   Mandate Pending List response.", e);
            }


    }
}

    public Response getResponseMandateCheckStatusGet(HashMap myData, String transactionId) {
        {
            try {
                Response response = null;
                Map<String, String> request = new HashMap<String, String>();

                if (myData!=null) {
                    request.put("X-CHANNEL-ID", (String) myData.get("x-channel-id"));
                    request.put("X-API-KEY", (String) myData.get("x-api-key"));
                    request.put("X-DEVICE-INFO", (String) myData.get("x-device-info"));
                    request.put("X-ACCESS-ID", (String) myData.get("x-access-id"));
                    request.put("X-AUTH-TOKEN", (String) myData.get("x-auth-token"));
                } else {
                    request.put("X-CHANNEL-ID", "3133");
                    request.put("X-API-KEY", "Fb1s61w-WaTJ7w-eh6JBx-Yjdf6df6Fe");
                    request.put("X-DEVICE-INFO", "{\"app\":\"com.mgs.jio.qa\",\"capability\":\"5200000200010004000639292929292\",\"os\":\"Android9\",\"ip\":\"127.0.0.1\",\"geocode\":{\"latitude\":\"19.0911\",\"longitude\":\"72.9208\"},\"mobile\":\"918271025445\",\"location\":\"Mumbai\",\"id\":\"864422037322790\",\"type\":\"MOB\"}");
                    request.put("X-ACCESS-ID", "abc");
                    request.put("X-AUTH-TOKEN", "klm");
                }
                String apiEndpoint = APIEndPoints.recMandateCheckStatus+transactionId;
                System.out.println(apiEndpoint+"endpoints");
                response = RestUtil.getByUrl(apiEndpoint,request);

                Reporter.logReport(ApiComponent.class, log_Type_Pass, "Response received against Mandate Check Status :" + response.prettyPrint(), null);
                return response;
            } catch (Exception e) {
                Reporter.logReport(ApiComponent.class, log_Type_Fail, "error while creating the   Mandate Check Status response.", e);
                throw new RuntimeException("error while creating   Mandate Check Status response.", e);
            }
        }}


    public Response getResponseMandateCheckStatusGetPrintToFile(HashMap myData, String transactionId,String apiName,String responseVal) {
        {
            try {
                Response response = null;
                Map<String, String> request = new HashMap<String, String>();

                if (myData!=null) {
                    request.put("X-CHANNEL-ID", (String) myData.get("x-channel-id"));
                    request.put("X-API-KEY", (String) myData.get("x-api-key"));
                    request.put("X-DEVICE-INFO", (String) myData.get("x-device-info"));
                    request.put("X-ACCESS-ID", (String) myData.get("x-access-id"));
                    request.put("X-AUTH-TOKEN", (String) myData.get("x-auth-token"));
                } else {
                    request.put("X-CHANNEL-ID", "3133");
                    request.put("X-API-KEY", "Fb0Yj56-4WaJ7w-ehJlBx-tqGshFeljE");
                    request.put("X-DEVICE-INFO", "{\"app\":\"com.mgs.jio.qa\",\"capability\":\"5200000200010004000639292929292\",\"os\":\"Android9\",\"ip\":\"127.0.0.1\",\"geocode\":{\"latitude\":\"19.0911\",\"longitude\":\"72.9208\"},\"mobile\":\"919920665290\",\"location\":\"Mumbai\",\"id\":\"864422037322790\",\"type\":\"MOB\"}");
                    request.put("X-ACCESS-ID", "abc");
                    request.put("X-AUTH-TOKEN", "klm");
                }
                String apiEndpoint = APIEndPoints.recMandateCheckStatus+transactionId;
                System.out.println(apiEndpoint+"endpoints");
                response = RestUtil.getByUrl(apiEndpoint,request);
                Reporter.logReport(ApiComponent.class, log_Type_Pass, "Response received against Mandate Check Status :" + response.prettyPrint(), null);
                return response;
            } catch (Exception e) {
                Reporter.logReport(ApiComponent.class, log_Type_Fail, "error while creating the   Mandate Check Status response.", e);
                throw new RuntimeException("error while creating   Mandate Check Status response.", e);
            }
        }}

    //need to delete
    public void writeToNotepad(String apiEndPoint, String requestBody, Headers headers, String responseBody, String testDescription, String methodName) throws IOException {
        String mainString="API Endpoint : "+apiEndPoint;
        mainString=mainString+"\n";
        mainString=mainString+"=============================================================";
        mainString=mainString+"\n";
        mainString=mainString+"Request Body : "+requestBody;
        mainString=mainString+"\n";
        mainString=mainString+"=============================================================";
        mainString=mainString+"\n";

        mainString=mainString+"Headers : "+headers;
        mainString=mainString+"\n";
        mainString=mainString+"=============================================================";
        mainString=mainString+"\n";

        mainString=mainString+"Response Body : "+responseBody;
        mainString=mainString+"\n";
        mainString=mainString+"=============================================================";
        mainString=mainString+"\n";

        String fileName=methodName+"_"+testDescription+".txt";
        createNotepadFileIfNotExist(fileName);
        appendDataInNotepad(folderPath+"\\"+fileName+".txt",mainString);
    }

    //need to delete
    public void createNotepadFileIfNotExist(String testname) throws IOException
    {
        File file = new File(folderPath+"\\"+testname+".txt");
        file.createNewFile();
    }

    //need to delete
    public void appendDataInNotepad(String txtFilePath,String dataToWrite) throws IOException, IOException {
        File f1 = new File(txtFilePath);
        System.out.println(txtFilePath);
        FileWriter fileWritter = new FileWriter(txtFilePath,true);

        // adding bifurcation

        fileWritter.write("\n");
        fileWritter.write("**********************************************************************************");
        fileWritter.write("\n");
        fileWritter.write("*********************************START********************************************");
        fileWritter.write("\n");
        fileWritter.write("\n");
        fileWritter.write(dataToWrite);

        fileWritter.write("\n");
        fileWritter.write("**********************************************************************************");
        fileWritter.write("\n");
        fileWritter.write("*********************************END********************************************");
        fileWritter.write("\n");
        fileWritter.write("\n");
        fileWritter.close();
        System.out.println("Done");
    }
}
