
package RequestEntity.SuspendOrResumeMandate;


import RequestEntity.SignatureData;

public class SuspendOrResumeMandateEntity {

    private String idempotentKey;
    private String uniqueMandateNumber;
    private String userType;
    private String action;
    private String startDate;
    private String endDate;
    private String userId;
    private String mobileNumber;
    private SignatureData signatureData;

    public String getIdempotentKey() {
        return idempotentKey;
    }

    public void setIdempotentKey(String idempotentKey) {
        this.idempotentKey = idempotentKey;
    }

    public String getUniqueMandateNumber() {
        return uniqueMandateNumber;
    }

    public void setUniqueMandateNumber(String uniqueMandateNumber) {
        this.uniqueMandateNumber = uniqueMandateNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public SignatureData getSignatureData() {
        return signatureData;
    }

    public void setSignatureData(SignatureData signatureData) {
        this.signatureData = signatureData;
    }

}
