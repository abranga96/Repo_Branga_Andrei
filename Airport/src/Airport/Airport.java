package Airport;

import Airplane.Airplane;
import Ticket.Ticket;

import java.util.ArrayList;

/**
 * Created by abran on 17.01.2017.
 */
public class Airport
{
    public ArrayList<Ticket> ticketList=new ArrayList<Ticket>();
    public ArrayList<Airplane> airplaneList=new ArrayList<Airplane>();
    public  void receiveAirplane(Airplane airplane)
    {
        if(!airplaneList.contains(airplane))
        {
            airplaneList.add(airplane);
        }
    }
    public void listAirplanes()
    {
        for (Airplane a:airplaneList
             ) {
            System.out.println(a.getName());

        }
    }

    public String listAirplanesStr()
    {
        String s="";
        for (Airplane a:airplaneList
                ) {
            s.concat("/n");
            s.concat(a.getName());

        }
    }

    public void departAirplane(String name)
    {
        for (Airplane a:airplaneList
             ) {
            if (a.getName().equalsIgnoreCase(name))
            {
                airplaneList.remove(a);
            }

        }
    }

    public boolean isInAirport(String name)
    {
        for (Airplane a:airplaneList
             ) {
            if(a.getName().equalsIgnoreCase(name))
            {
                return true;
            }

        }
        return false;
    }

    public Double getProfit()
    {
        Double sum= Double.valueOf(0);
        for (Airplane a:airplaneList
             ) {
            sum+=a.getProfit();
        }
        return sum;
    }

    public Ticket newTicketrandomNr(Airplane airplane)
    {
        if(airplaneList.contains(airplane))
        {
            return new Ticket(airplane);
        }
        return null;
    }

    public Ticket newTicketCustomNr(Airplane airplane,int nr)
    {
        if(airplaneList.contains(airplane))
        {
            return new Ticket(airplane,nr);
        }
        return null;
    }


}
