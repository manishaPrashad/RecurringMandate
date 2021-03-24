package base;

import java.io.File;

public interface Constants {

    String log_Type_Pass = "Pass";
    String log_Type_Fail = "Fail";
    String log_Type_Log = "Log";

    String status_Success = "SUCCESS";
    String status_Pending = "PENDING";
    String failStatus="FAILED";

    String status_Failure="FAILED";
    String status_Key="Status";

    String responseCode_Success ="200";

    String status_Initiated = "INITIATED";
    String status_Json_Path="transaction.status";

    String mandatePayerstatus_Json_Path="status";
    String mandatePayeestatus_Json_Path="mandateDtls.status";



    String txnId="transaction.idempotentKey";
    String txnIdForOtherMadate="txnId";
    String umnNoValue="mandateDtls.UMN";



    String missingParamMessage ="Some or all input parameters are missing.";
    String noConfigMessage ="No config found for give criteria";

    String responseSchemaFolderPath=System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
            + File.separator + "java" + File.separator + "ResponseSchema";

    String responseFailureSchemaPath=System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
            + File.separator + "java" + File.separator + "ResponseSchema" + File.separator + "Failure" + File.separator + "JsonFailureSchema.json";

    String TYPE_TRANSACTION = "Transaction";
    String TYPE_NON_TRANSACTION = "NonTransaction";
    String TYPE_AUTHENTICATION = "Authentication";

    String Type_Permanent_Address = "PER_ADDR";
    String Type_Correspondence_Address = "CURR_ADDR";

    // Transaction Service related data
    Integer CURRENCY_CODE = 356;
    Integer TYPE_DEBIT = 111;
    Integer TYPE_CREDIT = 213;
    Integer TYPE_AUTH = 301;
    Integer TYPE_CANCEL = 215;
    Integer TYPE_CAPTURE = 113;
    Integer TYPE_REVERSAL = 302;
    Integer SUB_TYPE_DEBIT_REVERSAL = 527;
    Integer SUB_TYPE_CREDIT_REVERSAL = 526;

    //Default SIT Payer
    String DEFAULT_SIT_PAYER_ACCOUNT = "30000000036468";
    String DEFAULT_SIT_PAYER_NAME = "Omkar Vilas Shinde";
    String DEFAULT_SIT_PAYER_BANK_IFSC = "JIOP0000001";
    Integer DEFAULT_SIT_PAYER_TYPE = 1;

    //Default Payer
    String DEFAULT_PP_PAYER_ACCOUNT = "30000000036468";
    String DEFAULT_PP_PAYER_NAME = "Omkar Vilas Shinde";
    String DEFAULT_PP_PAYER_BANK_IFSC = "JIOP0000001";
    Integer DEFAULT_PP_PAYER_TYPE = 1;

    //Default SIT Payee
    String DEFAULT_SIT_PAYEE_ACCOUNT = "30000000031911";
    String DEFAULT_SIT_PAYEE_NAME = "Vasil Grudev";
    String DEFAULT_SIT_PAYEE_BANK_IFSC = "JIOP0000001";
    Integer DEFAULT_SIT_PAYEE_TYPE = 1;

    //Default PP Payee
    String DEFAULT_PP_PAYEE_ACCOUNT = "30000000031911";
    String DEFAULT_PP_PAYEE_NAME = "Vasil Grudev";
    String DEFAULT_PP_PAYEE_BANK_IFSC = "JIOP0000001";
    Integer DEFAULT_PP_PAYEE_TYPE = 1;

    //DEBIT FREEZE SIT ACCOUNT DETAILS
    String DEFAULT_SIT_DEBIT_FREEZE_ACCOUNT = "30000000040031";
    String DEFAULT_SIT_DEBIT_FREEZE_BANK_IFSC= "JIOP0000001";

    //CREDIT FREEZE SIT ACCOUNT DETAILS
    String DEFAULT_SIT_CREDIT_FREEZE_ACCOUNT = "30000000040244";
    String DEFAULT_SIT_CREDIT_FREEZE_BANK_IFSC= "JIOP0000001";

    //CREDIT FREEZE PP ACCOUNT DETAILS
    String DEFAULT_PP_CREDIT_FREEZE_ACCOUNT = "30000000040244";
    String DEFAULT_PP_CREDIT_FREEZE_BANK_IFSC= "JIOP0000001";

    //TOTAL FREEZE SIT ACCOUNT DETAILS
    String DEFAULT_SIT_TOTAL_FREEZE_ACCOUNT = "30000000042050";
    String DEFAULT_SIT_TOTAL_FREEZE_BANK_IFSC= "JIOP0000001";

    //TOTAL FREEZE PP ACCOUNT DETAILS
    String DEFAULT_PP_TOTAL_FREEZE_ACCOUNT = "30000000042050";
    String DEFAULT_PP_TOTAL_FREEZE_BANK_IFSC= "JIOP0000001";

    //TOTAL FREEZE SIT ACCOUNT DETAILS
    String DEFAULT_SIT_CLOSED_ACCOUNT = "30000000040970";
    String DEFAULT_SIT_CLOSED_BANK_IFSC= "JIOP0000001";

    //TOTAL FREEZE PP ACCOUNT DETAILS
    String DEFAULT_PP_CLOSED_ACCOUNT = "30000000040970";
    String DEFAULT_PP_CLOSED_BANK_IFSC= "JIOP0000001";

    //Transaction SubType
    Integer SUB_TYPE_576 = 576;
    Integer SUB_TYPE_525 = 525;
    Integer SUB_TYPE_524 = 524;
    Integer SUB_TYPE_523 = 523;
    Integer SUB_TYPE_580 = 580;

    //Application Type
    Integer APPLICATION_ID_3132 = 3132;
    Integer INVALID_APP_ID_1111 = 1111;

    //Entity IDs
    Integer ENTITY_ID_8001 = 8001;
    Integer INVALID_ENTITY_ID_9999 = 9999;
    Integer ENTITY_ID_8011 = 8011;
    Integer ENTITY_ID_8012 = 8012;
    Integer ENTITY_ID_8013 = 8013;

    //ERROR CODES
    String ERROR_CODE_30503 = "30503";
    String ERROR_CODE_30509 = "30509";
    String ERROR_CODE_6011 = "6011";
    String ERROR_CODE_30508 = "30508";
    String ERROR_CODE_30000 = "30000";
    String ERROR_CODE_30504 = "30504";
    String ERROR_CODE_30505 = "30505";
    String ERROR_CODE_21021 = "21021";
    String ERROR_CODE_30506 = "30506";
    String ERROR_CODE_30514 = "30514";
    String ERROR_CODE_21024 = "21024";
    String ERROR_CODE_21004 = "21004";
    String ERROR_CODE_21005 = "21005";
    String ERROR_CODE_30515 = "30515";
    String ERROR_CODE_30507 = "30507";
    String ERROR_CODE_30518 = "30518";
    String ERROR_CODE_21002 = "21002";

    //ERROR MESSAGES
    String INVALID_VALUE_TRAN_MSG = "Invalid value :transaction";
    String INVALID_SOME_TECHNICAL_ERROR_MSG = "Some technical error occurred. Please try after some time!";
    String INVALID_MESSAGE_FORMAT_ERROR_MSG = "Message Format Error";
    String INVALID_SYSTEM_MALFUNCTION = "System Malfunction";
    String INVALID_CURRENCY_ERROR_MSG = "Currency provided is invalid";
    String INVALID_TRANSACTION_ERROR_MSG = "transaction must not be null";
    String INVALID_IDEMPOTENT_KEY_ERROR_MSG = "idempotentKey must not be null";
    String INVALID_INVOICE_ERROR_MSG = "invoice must not be null";
    String INVALID_CURRENCY_ERROR_MSG_1 = "currency must not be null";
    String INVALID_CURRENCY_ERROR_MSG_3 = "Currency provided is invalid";
    String INVALID_SUBTYPE_ERROR_MSG = "Method SubType provided is invalid";
    String INVALID_MODE_ERROR_MSG = "Payment Mode provided is invalid";
    String INVALID_METHOD_ERROR_MSG = "method must not be null";
    String INVALID_CAPTURE_METHOD_ERROR_MSG = "Capture Method provided is invalid";
    String INVALID_LIVE_MODE_ERROR_MSG = "livemode must not be null";
    String INVALID_APPLICATION_ID_ERROR_MSG = "application must not be null";
    String INVALID_TIMESTAMP_ERROR_MSG = "initiatingEntityTimestamp must not be null";
    String INVALID_METHOD_TYPE_MSG_1 = "Method Type provided is invalid";
    String INVALID_METHOD_TYPE_MSG_2 = "type must not be null";
    String MESSAGE_FORMAT_ERROR = "Message Format Error";
    String INVALID_VALUE_AMOUNT_ERROR_MSG = "Invalid value :amount";
    String INVALID_PAYER_TYPE_ERROR_MSG = "Payer Type provided is invalid";
    String PAYER_DETAILS_REQUIRED_ERROR_MSG = "Payer details are required.";
    String SYSTEM_MALFUNCTION_ERROR_MESSAGE = "System Malfunction";
    String INSUFFICIENT_FUNDS_ERROR_MSG = "Insufficient Funds";
    String INVALID_VALUE_PAYER_ERROR_MSG = "Invalid value :payer";
    String TRANSACTION_NOT_PERMITTED_ERROR_MSG = "Transaction Not Permitted to Card Holder";
    String INVALID_INITIATING_ENTITY_ERROR_MSG = "initiatingEntity must not be null";
    String INVALID_ENTITY_ERROR_MSG = "entityId must not be null";
    String INVALID_AMOUNT_ERROR_MSG = "Invalid value :amount";
    String INVALID_PAYEE_ERROR_MSG = "Payee details are required.";
    String INVALID_PAYEE_TYPE_ERROR_MSG = "Payee Type provided is invalid";
    String INVALID_VALUE_PAYEE = "Invalid value :payee";
    String INVALID_NON_JBP_ACCOUNT_MSG = "Non JPB Account";
    String INVALID_ACCOUNT_NUMBER = "Invalid Account Number";
    String INVALID_TRANSACTION_NOT_PERMITTED = "Transaction Not Permitted to Card Holder";

    String[] arr_enach_all = {"email","name"};
    String[] arr_enach_def = {"email","name"};

    String ACTION_SET = "set";
    String ACTION_DELETE = "delete";

    //paramsName
    String TRANSACTION = "transaction";
    String IDEMPOTENT_KEY = "idempotentKey";
    String CURRENCY = "currency";
    String INVOICE = "invoice";
    String METHOD = "method";
    String METHOD_TYPE = "methodType";
    String METHOD_SUBTYPE = "methodSubType";
    String MODE = "mode";
    String LIVE_MODE = "livemode";
    String APPLICATION_ID = "application";
    String INITIATING_ENTITY_TIMESTAMP = "timestamp";
    String INITIATING_ENTITY = "initiatingEntity";
    String ENTITY_ID = "entityId";
    String CALLBACK_URL = "callbackUrl";
    String CAPTURE_METHOD = "captureMethod";
    String ORIGINAL_ID = "originalId";
    String AUTHORIZATION_CODE = "authorizationCode";
    String AMOUNT = "amount";
    String AMOUNT_NET_AMOUNT = "netAmount";
    String AMOUNT_GROSS_AMOUNT = "grossAmount";
    String PAYER = "payer";
    String PAYEE = "payee";
    String TYPE = "type";
    String ACCOUNT_NUMBER = "accountNumber";
    String BANK_IFSC = "bankIfsc";

    String PATH_TRANSACTION = "transaction";
    String PATH_IDEMPOTENT_KEY = "transaction.idempotentKey";
    String PATH_CURRENCY = "transaction.currency";
    String PATH_INVOICE = "transaction.invoice";
    String PATH_METHOD = "transaction.method";
    String PATH_METHOD_TYPE = "transaction.method.type";
    String PATH_METHOD_SUBTYPE = "transaction.method.subType";
    String PATH_MODE = "transaction.mode";
    String PATH_LIVE_MODE = "transaction.livemode";
    String PATH_APPLICATION_ID = "transaction.application";
    String PATH_INITIATING_ENTITY_TIMESTAMP = "transaction.initiatingEntityTimestamp";
    String PATH_INITIATING_ENTITY = "transaction.initiatingEntity";
    String PATH_ENTITY_ID = "transaction.initiatingEntity.entityId";
    String PATH_CALLBACK_URL = "transaction.initiatingEntity.callbackUrl";
    String PATH_CAPTURE_METHOD = "transaction.captureMethod";
    String PATH_ORIGINAL_ID = "transaction.originalId";
    String PATH_AUTHORIZATION_CODE = "transaction.authorizationCode";
    String PATH_AMOUNT = "amount";
    String PATH_AMOUNT_NET_AMOUNT = "amount.netAmount";
    String PATH_AMOUNT_GROSS_AMOUNT = "amount.grossAmount";
    String PATH_PAYER = "payer";
    String PATH_PAYER_TYPE = "payer.type";
    String PATH_PAYER_ACCOUNT_NUMBER = "payer.accountNumber";
    String PATH_PAYER_BANK_IFSC = "payer.bankIfsc";
    String PATH_PAYEE = "payee";
    String PATH_PAYEE_TYPE = "payee.type";
    String PATH_PAYEE_ACCOUNT_NUMBER = "payee.accountNumber";
    String PATH_PAYEE_BANK_IFSC = "payee.bankIfsc";

    //ACCOUNT TYPES
    String DEBIT_FREEZE = "DEBIT FREEZE";
    String TOTAL_FREEZE = "TOTAL FREEZE";
}
