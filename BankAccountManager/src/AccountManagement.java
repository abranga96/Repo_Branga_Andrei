/**
 * Created by abran on 17.11.2016.
 */
public class AccountManagement
{
    public static void deposit(Client client,Employee employee,double amount,String Details,int day,int month,int year,AccountType accountType)
    {
        if (accountType==AccountType.Bussiness == client.hasbusinessAccount==true)
        {
            employee.addClient(client);
            client.bussinessAccount.addTransaction(day,month,year,Details,TransactionType.UPLOAD,amount);
            client.bussinessAccount.setBalance(client.bussinessAccount.getBalance()+amount);
        }
        if (accountType==AccountType.Savings == client.hassavingsAccount==true)
        {
            employee.addClient(client);
            client.savingsAccount.addTransaction(day,month,year,Details,TransactionType.UPLOAD,amount);
            client.savingsAccount.setBalance(client.savingsAccount.getBalance()+amount);
        }
        if (accountType==AccountType.Checking == client.hascheckingAccount==true)
        {
            employee.addClient(client);
            client.checkingAccount.addTransaction(day,month,year,Details,TransactionType.UPLOAD,amount);
            client.checkingAccount.setBalance(client.checkingAccount.getBalance()+amount);
        }
    }

    public static void withdraw(Client client,Employee employee,double amount,String Details,int day,int month,int year,AccountType accountType)
    {
        if (accountType==AccountType.Bussiness == client.hasbusinessAccount==true)
        {
            employee.addClient(client);
            client.bussinessAccount.addTransaction(day,month,year,Details,TransactionType.WITHDRAW,amount);
            client.bussinessAccount.setBalance(client.bussinessAccount.getBalance()-amount);
        }
        if (accountType==AccountType.Savings == client.hassavingsAccount==true)
        {
            employee.addClient(client);
            client.savingsAccount.addTransaction(day,month,year,Details,TransactionType.WITHDRAW,amount);
            client.savingsAccount.setBalance(client.savingsAccount.getBalance()-amount);
        }
        if (accountType==AccountType.Checking == client.hascheckingAccount==true)
        {
            employee.addClient(client);
            client.checkingAccount.addTransaction(day,month,year,Details,TransactionType.WITHDRAW,amount);
            client.checkingAccount.setBalance(client.checkingAccount.getBalance()-amount);
        }
    }

    public static void send(Client client,Employee employee,double amount,String Details,int day,int month,int year,AccountType accountType)
    {
        if (accountType==AccountType.Bussiness == client.hasbusinessAccount==true)
        {
            employee.addClient(client);
            client.bussinessAccount.addTransaction(day,month,year,Details,TransactionType.SEND,amount);
            client.bussinessAccount.setBalance(client.bussinessAccount.getBalance()-amount);
        }
        if (accountType==AccountType.Savings == client.hassavingsAccount==true)
        {
            employee.addClient(client);
            client.savingsAccount.addTransaction(day,month,year,Details,TransactionType.SEND,amount);
            client.savingsAccount.setBalance(client.savingsAccount.getBalance()-amount);
        }
        if (accountType==AccountType.Checking == client.hascheckingAccount==true)
        {
            employee.addClient(client);
            client.checkingAccount.addTransaction(day,month,year,Details,TransactionType.SEND,amount);
            client.checkingAccount.setBalance(client.checkingAccount.getBalance()-amount);
        }
    }

}
