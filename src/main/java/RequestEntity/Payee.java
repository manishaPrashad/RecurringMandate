package RequestEntity;

import RequestEntity.ExecuteMandate.Mobile_;

public class Payee {
    public String getVpa() {
        return vpa;
    }

    public void setVpa(String vpa) {
        this.vpa = vpa;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankIfsc() {
        return bankIfsc;
    }

    public void setBankIfsc(String bankIfsc) {
        this.bankIfsc = bankIfsc;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Mobile_ getMobile() {
        return mobile;
    }

    public void setMobile(Mobile_ mobile) {
        this.mobile = mobile;
    }

    private String vpa;
    private String userId;
    private Integer type;
    private String accountNumber;
    private String bankIfsc;
    private Integer accountType;
    private String bankName;
    private Mobile_ mobile;
    //private Object userId;

}
