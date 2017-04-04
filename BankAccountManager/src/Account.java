/**
 * Created by abran on 17.11.2016.
 */
public abstract class Account
{
    private double balance;
    private Date openDate = new Date();
    private Transaction[] transactions=new Transaction[9999999];
    private int  transactionIndex=1;

    public Account()
    {
        balance = 0;
    }

    public Account(double balance,int openDay, int openMonth, int openYear)
    {
        this.balance=balance;
        openDate.setDate(openDay,openMonth,openYear);
    }

    public double getBalance()
    {
        return this.balance;
    }

    public void setBalance(double balance)
    {
        this.balance=balance;
    }

    public abstract void displayAccountType();

    public void displayBalance()
    {
        System.out.println("Account balance: " + this.balance);
    }


    public void getOpenDate()
    {
        openDate.getDate();
    }

    public void setOpenDate(int day,int month,int year)
    {
        openDate.setDate(day,month,year);
    }

    public void addTransaction(int day,int month, int year,String details,TransactionType type,double amount)
    {
        transactions[transactionIndex]=new Transaction(day,month,year,details,type,amount);
        transactionIndex++;
    }

    public int getTransactionIndex()
    {
        return transactionIndex;
    }

    public Transaction getTransaction(int transactionIndex)
    {
        return transactions[transactionIndex];
    }


}
