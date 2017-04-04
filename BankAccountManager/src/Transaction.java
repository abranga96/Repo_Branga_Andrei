/**
 * Created by abran on 17.11.2016.
 */
public class Transaction
{
    private Date transactionDate;
    private String details;
    private TransactionType type;
    private double amount;

    public Transaction()
    {
        transactionDate=new Date();
        details="Default.";
        type=TransactionType.UPLOAD;
        amount=0;
    }

    public Transaction(int day,int month, int year,String details,TransactionType type,double amount)
    {
        transactionDate=new Date(day,month,year);
        this.details=details;
        this.type=type;
        this.amount=amount;
    }

    public Date getTransactionDate()
    {
        return transactionDate;
    }

    public String getDetails()
    {
        return details;
    }

    public TransactionType getType()
    {
        return  type;
    }

    public double getAmount()
    {
        return amount;
    }
}
