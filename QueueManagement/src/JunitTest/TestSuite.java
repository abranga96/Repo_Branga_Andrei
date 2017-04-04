package JunitTest;

import Client_Manager.Client_Profile;
import Client_Manager.Client_Profile_Factory;
import Logger.LoggerManager;
import Servicers.Servicer;
import Store.QueueServicerPair;
import UniqueIDManager.IDgenerator;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Andrei on 20.03.2017.
 */
public class TestSuite
{
    @Test
    public void testUniqueID()
    {
        System.out.println(IDgenerator.getUniqueID().toString());
    }


    @Test
    public void testTime()
    {
        LocalTime lt=LocalTime.now();

        System.out.println(lt.toString());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime lt2=LocalTime.now();
        System.out.println(lt2.toString());

        LocalTime lt3=lt2.minusSeconds(lt.getSecond());
        System.out.println(lt3.getSecond());
    }

    @Test
    public void arrayLlist()
    {
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(Integer.valueOf(222));
        System.out.println(l.get(0).toString());
    }

    @Test
    public void testFactory()
    {
        Client_Profile cp= Client_Profile_Factory.createNewClientProfile(15);
        System.out.println(cp.getArrivalTime().toString());
    }

    @Test
    public void TestLogger()
    {
        System.out.println(LoggerManager.servicesClosed());
        System.out.println(LoggerManager.servicesOpen());
        System.out.println(LoggerManager.servicerNoOfClients(1,new Servicer(3)));
    }

    @Test
    public void testServicing() throws InterruptedException {
        QueueServicerPair line=new QueueServicerPair(10);
        line.getQueue1().enqueue(Client_Profile_Factory.createNewClientProfile(2));
        line.getQueue1().enqueue(Client_Profile_Factory.createNewClientProfile(2));
        line.getQueue1().enqueue(Client_Profile_Factory.createNewClientProfile(2));

        Thread t=new Thread(line);
        t.start();
        t.join();
    }
}
