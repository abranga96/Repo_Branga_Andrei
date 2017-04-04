/**
 * Created by abran on 17.11.2016.
 */
public class Bank
{
    public Client[] clients= new Client[9999999];
    public Employee[] employee= new Employee[9999999];
    int clientIndex=1;
    int employeeIndex=1;

    public String bankName;

    public Bank()
    {
        bankName="Default";
    }

    public Bank(String bankName)
    {
        this.bankName=bankName;
    }

    public void addEmployee(String firstName,String lastName, String email)
    {
        employee[employeeIndex]=new Employee(firstName,lastName,email);
        employeeIndex++;
    }

    public void addClient(String firstName,String lastName, String email)
    {
        clients[clientIndex]=new Client(firstName,lastName,email);
        clientIndex++;
    }

    public void getInfo(long id,AccountType type)
    {
        for (int i=0; i<clientIndex; i++)
        {
            if (clients[i].getID()==id)
            {
                if (type==AccountType.Checking)
                {
                    if (clients[i].hascheckingAccount)
                    {
                        clients[i].checkingAccount.getDetails();break;
                    }
                }
                if (type==AccountType.Savings)
                {
                    if (clients[i].hassavingsAccount)
                    {
                        clients[i].savingsAccount.getDetails();break;
                    }
                }
                if (type==AccountType.Checking)
                {
                    if (clients[i].hassavingsAccount)
                    {
                        clients[i].savingsAccount.getDetails();break;
                    }
                }
            }
        }
    }

    public void listGreater500()
    {
        for (int i=0; i<clientIndex; i++)
        {
            if (clients[i].checkingAccount.getBalance()>500 || clients[i].savingsAccount.getBalance()>500 || clients[i].bussinessAccount.getBalance()>500)
            {
                System.out.println("Client ID: " + clients[i].getID());
            }
        }
    }


}
