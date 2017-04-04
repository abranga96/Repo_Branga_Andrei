package Passengers;

import Airplane.Airplane;
import Airport.Airport;
import Ticket.Ticket;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;

/**
 * Created by abran on 17.01.2017.
 */
public class Passenger extends Person
{
    public Passenger()
    {
        super();
    }

    private ArrayList<Ticket> ticketList=new ArrayList<Ticket>();

    public void addTicket(Ticket ticket,Airport airport)
    {
        if(!ticketList.contains(ticket))
        {
            ticketList.add(ticket);
        }
    }

    public void cancelTicketinAirplane(String airPlaneName)
    {
        for (Ticket t:ticketList
             ) {
            if(t.airplane.getName()==airPlaneName)
            {
                t.cancelTicket();
                ticketList.remove(t);
            }

        }
    }

    public   Passenger(String name)
    {
        super(name);
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }
}
