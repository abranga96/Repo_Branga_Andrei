package Ticket;

import Airplane.Airplane;
import Airplane.PassengerSeat;
import UUIDManager.TicketUUID;

import java.util.UUID;

/**
 * Created by abran on 17.01.2017.
 */
public class Ticket {
    private UUID id;
    private PassengerSeat passengerSeat;

    public Airplane airplane;
    private Double ticketPrice;

    public Ticket(Airplane airplane)
    {
        passengerSeat=new PassengerSeat(airplane.getFirstFree());
        this.id= TicketUUID.getID();
        this.airplane=airplane;
        this.airplane.addPassengerSeat(passengerSeat);
        this.ticketPrice=airplane.getTicketPrice();
    }

    public Ticket(Airplane airplane,int seatNr)
    {
        passengerSeat=new PassengerSeat(seatNr);
        this.id=TicketUUID.getID();
        this.airplane=airplane;
        this.airplane.addPassengerSeat(passengerSeat);
        this.ticketPrice=airplane.getTicketPrice();
    }

    public void cancelTicket()
    {
        airplane.cancelPassengerSeat(passengerSeat);
        passengerSeat.unoccupy();
    }


}
