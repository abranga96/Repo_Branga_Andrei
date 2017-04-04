/**
 * Created by abran on 17.11.2016.
 */
public class BussinessAccount extends  Account
{
    private String companyName;
    public AccountType type=AccountType.Bussiness;

    public BussinessAccount()
    {
        super();
        companyName="Default";
    }

    public BussinessAccount(double balance,int openDay, int openMonth, int openYear,String companyName)
    {
        super(balance,openDay,openMonth,openYear);
        this.companyName=companyName;
    }

    public void displayAccountType()
    {
        System.out.println("This is an Business Account afilliated to the company: " + companyName);
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName=companyName;
    }

    public void getDetails()
    {
        System.out.print("Opening date: ");getOpenDate();
        System.out.println("Balance: " + getBalance());
    }

}
