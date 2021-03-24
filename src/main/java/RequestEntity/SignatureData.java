package RequestEntity;

public class SignatureData {

    private String signer;
    private String signatureValue;
    private String signerKeyIndex;
    private String type;
    private String subType;


    public String getSigner() {
        return signer;
    }

    public SignatureData setSigner(String signer) {
        this.signer = signer;
        return this;
    }

    public String getSignatureValue() {
        return signatureValue;
    }

    public SignatureData setSignatureValue(String signatureValue) {
        this.signatureValue = signatureValue;
        return this;
    }

    public String getSignerKeyIndex() {
        return signerKeyIndex;
    }

    public SignatureData setSignerKeyIndex(String signerKeyIndex) {
        this.signerKeyIndex = signerKeyIndex;
        return this;
    }

    public String getType() {
        return type;
    }

    public SignatureData setType(String type) {
        this.type = type;
        return this;
    }

    public String getSubType() {
        return subType;
    }

    public SignatureData setSubType(String subType) {
        this.subType = subType;
        return this;
    }
}
