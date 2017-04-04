package Client_Manager;

import java.time.LocalTime;

/**
 * Created by Andrei on 28.03.2017.
 */
public class Client_Profile {
    private Client client;
    private volatile LocalTime arrivalTime;
    private volatile LocalTime takenInServiceTime;
    private volatile LocalTime leavingTime;
    private volatile int waitingInQueue,waitingToBeServiced,totalWaitingTime;//in seconds
    private boolean serviced=false;
    private boolean takenInService=false;

    public Client_Profile(){}

    public Client_Profile(Client client)
    {
        this.client=client;
        arrivalTime=LocalTime.now();
    }

    public void takeInService()
    {
        takenInService=true;
        takenInServiceTime=LocalTime.now();
        waitingInQueue=takenInServiceTime.getSecond()-arrivalTime.getSecond();
    }

    public void finnishService()
    {
        serviced=true;
        leavingTime=LocalTime.now();
        waitingToBeServiced=leavingTime.getSecond()-takenInServiceTime.getSecond();
        totalWaitingTime=waitingInQueue+waitingToBeServiced;
    }

    public Client getClient() {
        return client;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalTime getTakenInServiceTime() {
        return takenInServiceTime;
    }

    public LocalTime getLeavingTime() {
        return leavingTime;
    }

    public int getWaitingInQueue() {

        if (takenInService)
        {
            return waitingInQueue;
        }
        return 0;
    }

    public int getWaitingToBeServiced() {
        return waitingToBeServiced;
    }

    public int getTotalWaitingTime() {
        return totalWaitingTime;
    }

    public boolean isServiced() {
        return serviced;
    }

    public boolean isTakenInService() {
        return takenInService;
    }

    @Override
    public String toString() {
        return "Client_Profile{" +
                "client=" + client.toString() +
                ", arrivalTime=" + arrivalTime.toString() +
                ", takenInServiceTime=" + takenInServiceTime.toString() +
                ", leavingTime=" + leavingTime.toString() +
                ", waitingInQueue=" + waitingInQueue/60 +" minutes " +
                ", waitingToBeServiced=" + waitingToBeServiced/60 +" minutes " +
                ", totalWaitingTime=" + totalWaitingTime/60 +" minutes "+
                ", serviced=" + serviced +
                ", takenInService=" + takenInService +
                '}';
    }

    public int getServiceAmount()
    {
        return client.getServiceAmount();
    }

}
