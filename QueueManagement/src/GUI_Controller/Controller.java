package GUI_Controller;

import Client_Manager.Client;
import Client_Manager.ClientQueue;
import Client_Manager.Client_Profile;
import Client_Manager.Client_Profile_Factory;
import Logger.LoggerManager;
import Servicers.Servicer;
import Store.QueueServicerPair;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static java.nio.file.StandardOpenOption.*;

public class Controller
{
    @FXML
    private Text statusf;

    @FXML
    private Text nrq1;

    @FXML
    private Text nrq2;

    @FXML
    private Text nrq3;

    @FXML
    private Text nrq4;

    @FXML
    private Text nrq5;

    @FXML
    private Text status1;

    @FXML
    private Text nr1;

    @FXML
    private Text status2;

    @FXML
    private Text nr2;

    @FXML
    private Text status3;

    @FXML
    private Text nr3;

    @FXML
    private Text status4;

    @FXML
    private Text nr4;

    @FXML
    private Text status5;

    @FXML
    private Text nr5;

    @FXML
    private TextField secOfSimulation;

    @FXML
    private Button startSimulation;

    public Integer secOfSim;
   volatile QueueServicerPair line1;
    volatile QueueServicerPair line2;
   volatile QueueServicerPair line3;
    volatile QueueServicerPair line4;
   volatile QueueServicerPair line5;

    int  getSmallerLine()
    {
        int small=0;
        int amount=99999999;
        int time1=line1.getQueue1().getSize();
        int time2=line2.getQueue1().getSize();
        int time3=line3.getQueue1().getSize();
        int time4=line4.getQueue1().getSize();
        int time5=line5.getQueue1().getSize();
        if(time1<=amount)
        {
            amount=time1;
            small=1;
        }
        if(time2<=amount)
        {
            amount=time2;
            small=2;
        }
        if(time3<=amount)
        {
            amount=time3;
            small=3;
        }
        if(time4<=amount)
        {
            amount=time4;
            small=4;
        }
        if(time5<=amount)
        {
            amount=time5;
            small=5;
        }
        return small;
    }

    Queue<Integer> clientPool=new LinkedList<Integer>();


    @FXML
    private volatile Label status;

    @FXML
    private Text avg1;

    @FXML
    private Text avg2;

    @FXML
    private Text avg3;

    @FXML
    private Text avg4;

    @FXML
    private Text avg5;


    @FXML
    void startSimulation(ActionEvent event) throws InterruptedException, IOException {
        try
        {
            if(Integer.valueOf(secOfSimulation.getText()).equals(Integer.valueOf(0)))
            {
                throw new Exception("Time of simulation cannot be zero!");
            }
            FileOutputStream writer = new FileOutputStream("log.txt");
            writer.write(("").getBytes());
            writer.close();
            try
            {
                String filename= "log.txt";
                FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                fw.write("QUEUE MANAGEMENT SYSTEM SIMULATION LOG\n");
                fw.write(LocalTime.now().toString()+"\n");//appends the string to the file
                fw.close();
            }
            catch(IOException ioe)
            {
                System.err.println("IOException: " + ioe.getMessage());
            }
            startSimulation.setDisable(true);
            status.setText("Simulation started: "+LocalTime.now().toString());
            secOfSim=Integer.valueOf(secOfSimulation.getText());
            LocalTime end=LocalTime.now().plusSeconds(secOfSim);
            System.out.println(LoggerManager.servicesOpen());
            try
            {
                String filename= "log.txt";
                FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                fw.write(LoggerManager.servicesOpen());//appends the string to the file
                fw.close();
            }
            catch(IOException ioe)
            {
                System.err.println("IOException: " + ioe.getMessage());
            }


            line1=new QueueServicerPair(secOfSim);
            line2=new QueueServicerPair(secOfSim);
            line3=new QueueServicerPair(secOfSim);
            line4=new QueueServicerPair(secOfSim);
            line5=new QueueServicerPair(secOfSim);

            Thread t1=new Thread(line1);
            Thread t2=new Thread(line2);
            Thread t3=new Thread(line3);
            Thread t4=new Thread(line4);
            Thread t5=new Thread(line5);

            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();

            Thread guieditor=new Thread(new Runnable() {
                @Override
                public  synchronized void  run() {
                    while(LocalTime.now().isBefore(end))
                    {
                        avg1.setText(String.valueOf(line1.getAvgWaitingTime()));
                        avg2.setText(String.valueOf(line2.getAvgWaitingTime()));
                        avg3.setText(String.valueOf(line3.getAvgWaitingTime()));
                        avg4.setText(String.valueOf(line4.getAvgWaitingTime()));
                        avg5.setText(String.valueOf(line5.getAvgWaitingTime()));
                        if(line1.servicer1.isBusy())
                        {
                            status1.setText("working");
                        }
                        else
                        {
                            status1.setText("idle");
                        }
                        nr1.setText(String.valueOf(line1.servicer1.noOfClients));
                        if(line2.servicer1.isBusy())
                        {
                            status2.setText("working");
                        }
                        else
                        {
                            status2.setText("idle");
                        }
                        nr2.setText(String.valueOf(line2.servicer1.noOfClients));
                        if(line3.servicer1.isBusy())
                        {
                            status3.setText("working");
                        }
                        else
                        {
                            status3.setText("idle");
                        }
                        nr3.setText(String.valueOf(line3.servicer1.noOfClients));
                        if(line4.servicer1.isBusy())
                        {
                            status4.setText("working");
                        }
                        else
                        {
                            status4.setText("idle");
                        }
                        nr4.setText(String.valueOf(line4.servicer1.noOfClients));
                        if(line5.servicer1.isBusy())
                        {
                            status5.setText("working");
                        }
                        else
                        {
                            status5.setText("idle");
                        }
                        nr5.setText(String.valueOf(line5.servicer1.noOfClients));
                        nrq1.setText(String.valueOf(line1.getQueue1().getSize()));
                        nrq2.setText(String.valueOf(line2.getQueue1().getSize()));
                        nrq3.setText(String.valueOf(line3.getQueue1().getSize()));
                        nrq4.setText(String.valueOf(line4.getQueue1().getSize()));
                        nrq5.setText(String.valueOf(line5.getQueue1().getSize()));
                    }
                }
            });guieditor.start();

            Thread clientPoolManager=new Thread(new Runnable() {
                @Override
                public void run() {
                    while(LocalTime.now().isBefore(end))
                    {
                        if(!clientPool.isEmpty())
                        {

                            int smaller=getSmallerLine();
                            if(smaller==1)
                            {
                                Client_Profile cp=Client_Profile_Factory.createNewClientProfile(clientPool.remove());
                                line1.getQueue1().enqueue(cp);
                                System.out.println(LoggerManager.newClientInQueue(cp,1));
                                try
                                {
                                    String filename= "log.txt";
                                    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                                    fw.write(LoggerManager.newClientInQueue(cp,1));//appends the string to the file
                                    fw.close();
                                }
                                catch(IOException ioe)
                                {
                                    System.err.println("IOException: " + ioe.getMessage());
                                }
                            }
                            else
                            {
                                if(smaller==2)
                                {
                                    Client_Profile cp=Client_Profile_Factory.createNewClientProfile(clientPool.remove());
                                    line2.getQueue1().enqueue(cp);
                                    System.out.println(LoggerManager.newClientInQueue(cp,2));
                                    try
                                    {
                                        String filename= "log.txt";
                                        FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                                        fw.write(LoggerManager.newClientInQueue(cp,2));//appends the string to the file
                                        fw.close();
                                    }
                                    catch(IOException ioe)
                                    {
                                        System.err.println("IOException: " + ioe.getMessage());
                                    }
                                }
                                else
                                {
                                    if(smaller==3)
                                    {
                                        Client_Profile cp=Client_Profile_Factory.createNewClientProfile(clientPool.remove());
                                        line3.getQueue1().enqueue(cp);
                                        System.out.println(LoggerManager.newClientInQueue(cp,3));
                                        try
                                        {
                                            String filename= "log.txt";
                                            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                                            fw.write(LoggerManager.newClientInQueue(cp,3));//appends the string to the file
                                            fw.close();
                                        }
                                        catch(IOException ioe)
                                        {
                                            System.err.println("IOException: " + ioe.getMessage());
                                        }
                                    }
                                    else
                                    {
                                        if(smaller==4)
                                        {
                                            Client_Profile cp=Client_Profile_Factory.createNewClientProfile(clientPool.remove());
                                            line4.getQueue1().enqueue(cp);
                                            System.out.println(LoggerManager.newClientInQueue(cp,4));
                                            try
                                            {
                                                String filename= "log.txt";
                                                FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                                                fw.write(LoggerManager.newClientInQueue(cp,4));//appends the string to the file
                                                fw.close();
                                            }
                                            catch(IOException ioe)
                                            {
                                                System.err.println("IOException: " + ioe.getMessage());
                                            }
                                        }
                                        else
                                        {
                                            if(smaller==5)
                                            {
                                                Client_Profile cp=Client_Profile_Factory.createNewClientProfile(clientPool.remove());
                                                line5.getQueue1().enqueue(cp);
                                                System.out.println(LoggerManager.newClientInQueue(cp,5));
                                                try
                                                {
                                                    String filename= "log.txt";
                                                    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                                                    fw.write(LoggerManager.newClientInQueue(cp,5));//appends the string to the file
                                                    fw.close();
                                                }
                                                catch(IOException ioe)
                                                {
                                                    System.err.println("IOException: " + ioe.getMessage());
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            });

            clientPoolManager.start();


            Thread logger=new Thread(new Runnable() {
                @Override
                public void run() {

                    while(LocalTime.now().isBefore(end))
                    {
                        try
                        {
                            Thread.sleep((secOfSim+2)*1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        statusf.setText("SIMULATION HAS ENDED!!! Please note the people left in line unserviced!!!");
                        status1.setText("idle");
                        status2.setText("idle");
                        status3.setText("idle");
                        status4.setText("idle");
                        status5.setText("idle");
                        startSimulation.setDisable(true);
                        addClient.setDisable(true);
                        System.out.println("\n\n");
                        System.out.println(LoggerManager.servicesClosed());
                        System.out.println(LoggerManager.servicerNoOfClients(1,line1.getServicer1()));
                        System.out.println(LoggerManager.servicerNoOfClients(2,line2.getServicer1()));
                        System.out.println(LoggerManager.servicerNoOfClients(3,line3.getServicer1()));
                        System.out.println(LoggerManager.servicerNoOfClients(4,line4.getServicer1()));
                        System.out.println(LoggerManager.servicerNoOfClients(5,line5.getServicer1()));
                        try
                        {
                            String filename= "log.txt";
                            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                            fw.write(LoggerManager.servicesClosed());
                            fw.write(LoggerManager.servicerNoOfClients(1,line1.getServicer1()));
                            fw.write(LoggerManager.servicerNoOfClients(2,line2.getServicer1()));
                            fw.write(LoggerManager.servicerNoOfClients(3,line3.getServicer1()));
                            fw.write(LoggerManager.servicerNoOfClients(4,line4.getServicer1()));
                            fw.write(LoggerManager.servicerNoOfClients(5,line5.getServicer1()));
                            fw.write("Queue 1 peak hour: "+LoggerManager.peakHour(line1.getQueue1()));
                            fw.write("Queue 2 peak hour: "+LoggerManager.peakHour(line2.getQueue1()));
                            fw.write("Queue 3 peak hour: "+LoggerManager.peakHour(line3.getQueue1()));
                            fw.write("Queue 4 peak hour: "+LoggerManager.peakHour(line4.getQueue1()));
                            fw.write("Queue 5 peak hour: "+LoggerManager.peakHour(line5.getQueue1()));//appends the string to the file
                            fw.close();
                        }
                        catch(IOException ioe)
                        {
                            System.err.println("IOException: " + ioe.getMessage());
                        }
                    }
                }
            });
            logger.start();
        }
        catch(Exception e)
        {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).showAndWait();
        }

    }

    @FXML
    private Button addClient;

    @FXML
    private TextField clientServiceAmount;



    @FXML
   synchronized void addClient(ActionEvent event) {
        Integer am=Integer.valueOf(clientServiceAmount.getText());
        clientPool.add(am);
    }
}
