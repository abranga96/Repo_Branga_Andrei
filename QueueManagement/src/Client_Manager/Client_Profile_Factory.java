package Client_Manager;

/**
 * Created by Andrei on 28.03.2017.
 */
public class Client_Profile_Factory {
    public static Client_Profile createNewClientProfile(int serviceAmount)
    {
        Client client=new Client(serviceAmount);
        Client_Profile client_profile=new Client_Profile(client);
        return client_profile;
    }
}
