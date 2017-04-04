/**
 * Created by abran on 17.11.2016.
 */
public class SavingsAccount extends Account
{
    private  double yearlyInterest;
    public AccountType type=AccountType.Savings;
    public SavingsAccount()
    {
        super();
        yearlyInterest=0;
    }

    public SavingsAccount(double balance,int openDay, int openMonth, int openYear,double yearlyInterest)
    {
        super(balance,openDay,openMonth,openYear);
        this.yearlyInterest=yearlyInterest;
    }

    public void displayAccountType()
    {
        System.out.println("This is an Savings Account.");
    }

    public double getInterest()
    {
        return yearlyInterest;
    }

    public void setInterest(double yearlyInterest)
    {
        this.yearlyInterest=yearlyInterest;
    }

    public void getDetails()
    {
        System.out.print("Opening date: ");getOpenDate();
        System.out.println("Balance: " + getBalance());
    }
}
