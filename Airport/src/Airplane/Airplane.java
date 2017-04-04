package Airplane;

import Passengers.Person;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by abran on 17.01.2017.
 */
public class Airplane
{
    private String name;
    private PlaneStatus status;
    private final int MAX_PASS=100;
    private Double ticketPrice;

    private SortedSet<Seat> seatList=new TreeSet<Seat>();
   
    private boolean[] occ=new boolean[MAX_PASS];

    private void occ()
    {
        for (int i=0; i<occ.length; i++)
        {
            occ[i]=false;
        }
    }

    public Airplane()
    {
        this.name="DEFAULT";
        this.status=PlaneStatus.INAIRPORT;
        occ();
        this.ticketPrice= Double.valueOf(10);
    }

    public String getName()
    {
        return this.name;
    }

    public Airplane(String name,PlaneStatus status,Double price)
    {
        this.name=name;
        this.status=status;
        occ();
        this.ticketPrice=price;
    }

    public int getFirstFree()
    {
        for (int i=0; i<occ.length; i++)
        {
            if (occ[i]==true)
            {
                return i;
            }
        }
        return -1;
    }

    public void addCrewSeat(CrewSeat crewSeat)
    {
        if (seatList.size()<=MAX_PASS) {
            seatList.add(crewSeat);
            occ[crewSeat.getSeatNr()] = true;
        }
    }
    
    public void addPassengerSeat(PassengerSeat passengerSeat)
    {
        if (seatList.size()<=MAX_PASS) {
            seatList.add(passengerSeat);

        }
    }
    
    public void cancelPassengerSeat(PassengerSeat passengerSeat)
    {
        if (seatList.contains(passengerSeat))
        {
            occ[passengerSeat.getSeatNr()]=false;
            seatList.remove(passengerSeat);
        }
    }
    public void getAllFreeSeats()
    {
        for (int i=0; i<occ.length; i++)
        {
            if (occ[i]==false)
            {
                System.out.print(i+" ");
            }
        }
    }

    public Double getTicketPrice()
    {
        return ticketPrice;
    }

    
    public Double getProfit()
    {
        int nr=0;;

        for (Seat s:seatList
             ) {if(s.getSeatType()==SeatType.PASSENGER){
            nr++;


        }

        }
        return ticketPrice*nr-(0.3*(MAX_PASS-nr));
    }
}
