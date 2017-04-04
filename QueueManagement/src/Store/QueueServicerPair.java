package Store;

import Client_Manager.ClientQueue;
import Client_Manager.Client_Profile;
import Logger.LoggerManager;
import Servicers.Servicer;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

/**
 * Created by Andrei on 01.04.2017.
 */
public class QueueServicerPair implements Runnable
{
    public LocalTime startSimulation=LocalTime.now();
    public LocalTime endSimulation;
    public volatile ClientQueue queue1=new ClientQueue();
    public volatile Servicer servicer1=new Servicer(5);
    public volatile double avgWaitingTime=0;
    public volatile double waitingtime=0;

    public QueueServicerPair(int SecOfSimulation)
    {
        this.endSimulation=LocalTime.now().plusSeconds(SecOfSimulation);
    }


    @Override
    public void run() {
       while (LocalTime.now().isBefore(endSimulation))
       {
           if(!queue1.isEmpty() && servicer1.isDone())
           {
               servicer1.takeInService(queue1.dequeue());
               System.out.println(LoggerManager.newClientInService(servicer1.getClient()));
               try
               {
                   String filename= "log.txt";
                   FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                   fw.write(LoggerManager.newClientInService(servicer1.getClient()));//appends the string to the file
                   fw.close();
               }
               catch(IOException ioe)
               {
                   System.err.println("IOException: " + ioe.getMessage());
               }
           }
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           if(!servicer1.isDone())
           {

               servicer1.service();
           }
           if(servicer1.getClient()!=null &&servicer1.getClient().getServiceAmount()<=0)
           {
               Client_Profile cp=servicer1.freeClient();
               int aux=cp.getWaitingInQueue();
               if(aux>=0)
               {
                   waitingtime+=aux;

                   if(servicer1.getNoOfClients()!=0)
                   {
                       avgWaitingTime=waitingtime/servicer1.getNoOfClients();
                   }
                   else
                   {
                       avgWaitingTime=0;
                   }
               }
               System.out.println(LoggerManager.clientLeft(cp));
               try
               {
                   String filename= "log.txt";
                   FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                   fw.write(LoggerManager.clientLeft(cp));//appends the string to the file
                   fw.close();
               }
               catch(IOException ioe)
               {
                   System.err.println("IOException: " + ioe.getMessage());
               }
           }
       }
    }

    public synchronized double getAvgWaitingTime() {
        return Math.floor(avgWaitingTime * 100) / 100;
    }

    public ClientQueue getQueue1() {
        return queue1;
    }

    public Servicer getServicer1() {
        return servicer1;
    }

    public void setQueue1(ClientQueue queue1) {
        this.queue1 = queue1;
    }

    public void setServicer1(Servicer servicer1) {
        this.servicer1 = servicer1;
    }
}
