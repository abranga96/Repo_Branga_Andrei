package CompartmentPackage;

import CarriablePackage.Carriable;
import CarriablePackage.Passenger;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * Created by abran on 05.01.2017.
 */
public class PassengerCompartment extends Compartment
{
    private final int MAX_PASSENGERS=100;
    private final int TICKET_PRICE=100;

    private ArrayList<Carriable> passengerList=new ArrayList<>();


    public PassengerCompartment()
    {
        super();
    }

    public void addPassenger(Passenger passenger)
    {
        if (passengerList.size()<100)
        {
            passengerList.add(passenger);
        }
        else
        {
            System.out.println("Passenger compartment full!");
        }
    }

    public int getProfit()
    {
        return passengerList.size()*TICKET_PRICE;
    }

    public int compareTo(@NotNull Compartment o) {
        return this.ID.compareTo(o.ID);

    }
}
