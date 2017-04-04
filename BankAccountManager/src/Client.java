import com.thoughtworks.xstream.core.ReferenceByIdMarshaller;

/**
 * Created by abran on 17.11.2016.
 */
public class Client
{
    private long id;
    private String firstName;
    private String lastName;
    private String email;

    CheckingAccount checkingAccount;
    SavingsAccount savingsAccount;
    BussinessAccount bussinessAccount;

    boolean hascheckingAccount= false;
    boolean hassavingsAccount= false;
    boolean hasbusinessAccount = false;

    public Client()
    {
        id= IdGenerator.getId();
        firstName="DEFAULT";
        lastName="DEFAULT";
        email="default@default.com";
    }

    public Client(String firstName,String lastName, String email)
    {
        id= IdGenerator.getId();
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }

    public void openCheckingAccount()
    {
        if (hascheckingAccount==false)
        {
            checkingAccount = new CheckingAccount();
        }
        else
        {
            System.out.println("Client "+id+" already has an Checking Account!");
        }
    }

    public void openSavingsAccount()
    {
        if (hassavingsAccount==false)
        {
            savingsAccount = new SavingsAccount();
        }
        else
        {
            System.out.println("Client "+id+" already has an Savings Account!");
        }
    }

    public void openBusinessAccount()
    {
        if (hasbusinessAccount==false)
        {
            bussinessAccount = new BussinessAccount();
        }
        else
        {
            System.out.println("Client "+id+" already has an Business Account!");
        }
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName=firstName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email=email;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName=lastName;
    }

    public long getID()
    {
        return id;
    }


}
