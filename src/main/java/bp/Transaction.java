package bp;

/**
 * Created by q on 12/12/14.
 */
public class Transaction {
    private int debitAccount;
    private int creditAccount;
    private TranType tranType;
    private float tranAmount;

    public Transaction(String debitAccount, String creditAccount, String tranType, String tranAmmount) {
        this.debitAccount = Integer.parseInt(debitAccount);
        this.creditAccount = Integer.parseInt(creditAccount);
        this.tranType = TranType.valueOf(tranType);
        this.tranAmount = Float.parseFloat(tranAmmount);
    }

    public int getFirstAccount() {
        return debitAccount;
    }

    public int getSecondAccount() {
        return creditAccount;
    }

    public TranType getTranType() {
        return tranType;
    }

    public float getTranAmount() {
        return tranAmount;
    }
}
