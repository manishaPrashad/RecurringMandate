package base;

public class APIEndPoints {
    public static String recMandateByPayee=//"http://10.144.108.125:9002/jpb/v1/upi/mandate/process";
           // "http://10.144.108.125:9002/jpb/v1/upi/mandate/process";
          "http://10.144.11.87:9002/jpb/v1/upi/mandate/process";

    public static String recMandateHistory="http://10.144.11.87:9002/jpb/v1/upi/mandates/user/";

    public static String recUpdateMandate="http://10.144.108.125:9002/jpb/v1/upi/mandate/update";

    public static String recRevokeMandate="http://10.144.11.87:9002/jpb/v1/upi/mandate/revoke";

    public static String recSuspendOrResumeMandate="http://10.144.11.87:9002/jpb/v1/upi/mandate/Suspend/Resume";

    public static String executeMandateByChannel="http://10.144.108.125:9002/jpb/v1/upi/mandate/channel/execute";
          //  "http://10.144.108.125:9002/jpb/v1/upi/mandate/channel/execute";

    public static String recMandatePendingList="http://10.144.11.87:9002/jpb/v1/upi/mandate/requests/user/";

    public static String recMandateCheckStatus="http://10.144.11.87:9002/jpb/v1/upi/mandate/transaction/";

}
