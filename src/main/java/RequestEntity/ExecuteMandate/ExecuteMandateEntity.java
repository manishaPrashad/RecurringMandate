
package RequestEntity.ExecuteMandate;


import RequestEntity.Amount;
import RequestEntity.Payee;
import RequestEntity.Payer;
import RequestEntity.Transaction;

public class ExecuteMandateEntity {

    private Transaction transaction;
    private Amount amount;
    private Payer payer;
    private Payee payee;
    private Secure secure;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
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

    public Secure getSecure() {
        return secure;
    }

    public void setSecure(Secure secure) {
        this.secure = secure;
    }

}
