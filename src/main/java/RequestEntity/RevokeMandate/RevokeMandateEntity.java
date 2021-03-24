
package RequestEntity.RevokeMandate;


public class RevokeMandateEntity {

    private String idempotentKey;
    private String uniqueMandateNumber;
    private String userId;
    private String userType;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
