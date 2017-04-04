/**
 * Created by abran on 17.11.2016.
 */
public class CheckingAccount extends Account
{

    public AccountType type=AccountType.Checking;

    public CheckingAccount()
    {
        super();
    }

    public CheckingAccount(double balance,int openDay, int openMonth, int openYear)
    {
        super(balance,openDay,openMonth,openYear);
    }

    public void displayAccountType()
    {
        System.out.println("This is an Checking Account.");
    }

    public void getDetails()
    {
        System.out.print("Opening date: ");getOpenDate();
        System.out.println("Balance: " + getBalance());
    }

}
