
package RequestEntity.MandateAcceptByPayer;


import RequestEntity.*;

public class MandateAcceptByPayerEntity {

    private Transaction transaction;
    private Payer payer;
    private Payee payee;
    private Amount amount;
    private SignatureData signatureData;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public Payee getPayee() {
        return payee;
    }

    public void setPayee(Payee payee) {
        this.payee = payee;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public SignatureData getSignatureData() {
        return signatureData;
    }

    public void setSignatureData(SignatureData signatureData) {
        this.signatureData = signatureData;
    }

}
