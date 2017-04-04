package Servicers;

import Client_Manager.Client;
import Client_Manager.Client_Profile;

import java.util.ArrayList;

/**
 * Created by Andrei on 28.03.2017.
 */
public class Servicer {
    ArrayList<Client_Profile> client=new ArrayList<Client_Profile>();
    private int serviceUnitsPerSec;
    private boolean isBusy=false;
    public volatile int noOfClients=0;
    public Servicer(){}

    public Servicer(int serviceUnitsPerSec)
    {
        this.serviceUnitsPerSec=serviceUnitsPerSec;
    }

    public void takeInService(Client_Profile client_profile)
    {
        if(client.isEmpty())
        {
            this.client.add(client_profile);
            isBusy=true;
            client.get(0).takeInService();
            noOfClients++;
        }
    }
    public boolean isDone()
    {
        if(client.isEmpty())
        {
            return true;
        }
        return client.get(0).isServiced();
    }

    public void service()
    {
        if (!isDone() && !client.isEmpty())
        {
            client.get(0).getClient().setServiceAmount(client.get(0).getClient().getServiceAmount()-serviceUnitsPerSec);
        }
    }

    public Client_Profile freeClient()
    {
        client.get(0).finnishService();
        isBusy=false;
        return client.remove(0);
    }

    public synchronized int getNoOfClients() {
        return noOfClients;
    }

    public Client_Profile getClient() {
        if(client.isEmpty())
        {
            return null;
        }
        else
        {
            return client.get(0);
        }
    }

    public synchronized boolean isBusy() {
        return isBusy;
    }
}
