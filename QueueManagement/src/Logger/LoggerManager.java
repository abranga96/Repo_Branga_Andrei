package Logger;

import Client_Manager.ClientQueue;
import Client_Manager.Client_Profile;
import GUI_Controller.Controller;
import Servicers.Servicer;

import java.time.LocalTime;
import java.util.Queue;

/**
 * Created by Andrei on 28.03.2017.
 */
public class LoggerManager {

    public static String servicesOpen()
    {
        return LocalTime.now().toString()+" "+"Queues and services are now open... \n";
    }

    public static String servicesClosed()
    {
        return LocalTime.now().toString()+" "+"All services are now closed... \n";
    }

    public static String newClientInQueue(Client_Profile client_profile,int i)
    {
        return LocalTime.now().toString()+" "+"New client in queue "+i+":"+client_profile.getClient().getClientID()+" ...\n";
    }

    public static String newClientInService(Client_Profile client_profile)
    {
        return LocalTime.now().toString()+" "+"New client in service :"+client_profile.getClient().getClientID()+" ...\n";
    }

    public static String clientLeft(Client_Profile client_profile)
    {
        return LocalTime.now().toString()+" "+"Client left :"+client_profile.getClient().toString()+" ...\n";
    }

    public static String servicerNoOfClients(int i,Servicer s)
    {
        return LocalTime.now().toString()+" "+"Servicer "+i+" number of clients serviced: "+s.getNoOfClients()+"...\n";
    }

    public static String peakHour(ClientQueue q)
    {
        return "Peak hour: "+q.getPeakHour().toString()+"\n";
    }
}
