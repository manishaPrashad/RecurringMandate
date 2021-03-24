package RequestEntity;

public class SignatureData_ {
    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer;
    }

    public String getSignatureValue() {
        return signatureValue;
    }

    public void setSignatureValue(String signatureValue) {
        this.signatureValue = signatureValue;
    }

    public String getSignerKeyIndex() {
        return signerKeyIndex;
    }

    public void setSignerKeyIndex(String signerKeyIndex) {
        this.signerKeyIndex = signerKeyIndex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    private String signer;
    private String signatureValue;
    private String signerKeyIndex;
    private String type;
    private String subType;

}
