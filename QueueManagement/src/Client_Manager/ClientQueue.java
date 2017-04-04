package Client_Manager;

import java.time.LocalTime;
import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Andrei on 28.03.2017.
 */
public class ClientQueue {
    Queue<Client_Profile> clientQueue=new LinkedList<Client_Profile>();
    private int queueSize=-1;
    LocalTime peakHour;
    public ClientQueue(){}

    public synchronized  void enqueue(Client_Profile client_profile)
    {
        clientQueue.add(client_profile);
        if(clientQueue.size()>queueSize)
        {
            peakHour=LocalTime.now();
            queueSize=clientQueue.size();
        }
    }

    public synchronized Client_Profile dequeue()
    {
        Client_Profile client_profile=clientQueue.remove();
        return client_profile;
    }

    public int getSize()
    {
        return clientQueue.size();
    }

    public int getWaitingTime()
    {
        LocalTime time=LocalTime.now();
        int total=0;
        for (Client_Profile cp:clientQueue
             ) {
            total+=(time.getSecond()-cp.getArrivalTime().getSecond());

        }
        return total;
    }

    public int getServiceAmount()
    {
        int amount=0;
        for (Client_Profile cp:clientQueue
             ) {amount+=cp.getServiceAmount();

        }
        return  amount;
    }

    public LocalTime getPeakHour()
    {
        return peakHour;
    }

    public boolean isEmpty()
    {
        return clientQueue.isEmpty();
    }

    @Override
    public String toString() {
        String ret="ClientQueue: \n";
        if(clientQueue.isEmpty())
        {
            ret+="<<EMPTY QUEUE>>\n";
            return ret;
        }
        for (Client_Profile c:clientQueue
             ) {ret+="..................................................\nclient id: "+c.getClient().getClientID()+"\n";
             ret+="arrival time: "+c.getArrivalTime().toString()+"\n";
             ret+="current wating time: "+(LocalTime.now().getSecond()-c.getArrivalTime().getSecond())/60;
             ret+="\n..................................................";

        }
        return ret;
    }


}
