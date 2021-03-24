
package RequestEntity.ExecuteMandateByChannel;


import RequestEntity.Amount;
import RequestEntity.Payee;
import RequestEntity.Payer;
import RequestEntity.Transaction;

public class ExecuteMandateByChannelEntity {

    private Transaction transaction;
    private Amount amount;
    private Payer payer;
    private Payee payee;

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

}
