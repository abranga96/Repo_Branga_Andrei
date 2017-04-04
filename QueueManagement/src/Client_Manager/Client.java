package Client_Manager;


import UniqueIDManager.IDgenerator;

import java.util.UUID;

/**
 * Created by Andrei on 20.03.2017.
 */
public class Client
{
    private UUID clientID;
    private int serviceAmount; //in service units


    public Client(){
        this.clientID=IDgenerator.getUniqueID();
        this.serviceAmount=0;
    }

    public Client(int serviceAmount)
    {
       this.clientID=IDgenerator.getUniqueID();
       this.serviceAmount=serviceAmount;
    }

    public int getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(int serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public UUID getClientID() {
        return clientID;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientID +
                ", serviceAmount=" + serviceAmount +
                " (serviceunits) }";
    }
}
