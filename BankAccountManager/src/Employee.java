/**
 * Created by abran on 17.11.2016.
 */
public class Employee
{
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Client[] updatedClients = new Client[9999999];
    private int clientIndex=0;

    public Employee()
    {
        id= IdGenerator.getId();
        firstName="DEFAULT";
        lastName="DEFAULT";
        email="default@default.com";
    }

    public Employee(String firstName,String lastName, String email)
    {
        id= IdGenerator.getId();
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
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

    public boolean hasClient(Client c)
    {
        for (int i=0; i<clientIndex; i++)
        {
            if (updatedClients[i].getID()==c.getID())
            {
                return true;
            }
        }
         return false;
    }
    public void addClient(Client client)
    {
        if (hasClient(client)==false)
        {
            updatedClients[clientIndex]=client;
            clientIndex++;
        }
    }

    public void getClients()
    {
        for (int i=0; i<clientIndex; i++)
        {
            System.out.println(updatedClients[i].getID() + "  " + updatedClients[i].getFirstName() + "  " + updatedClients[i].getLastName());
        }
    }

    public boolean equals(Employee employee)
    {
        if (this.id==employee.getID())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
