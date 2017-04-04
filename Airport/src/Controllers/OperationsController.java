package Controllers;

import Airplane.*;
import Airport.*;
import Passengers.*;
import Ticket.*;
import com.intellij.openapi.diff.impl.patch.AirContentRevision;

public class OperationsController {

    public static void main(String[] args)
    {
        Airport airport=new Airport();

        Airplane a1=new Airplane("Airplane 1", PlaneStatus.INAIRPORT,Double.valueOf("20.5"));
        Airplane a2=new Airplane("Airplane 2", PlaneStatus.INAIRPORT,Double.valueOf("40"));
        Airplane a3=new Airplane("Airplane 3", PlaneStatus.INAIRPORT,Double.valueOf("12.3"));

        airport.receiveAirplane(a1);
        airport.receiveAirplane(a2);
        airport.receiveAirplane(a3);

        Passenger p1=new Passenger("Passenger 1");
        Passenger p2=new Passenger("Passenger 2");
        Passenger p3=new Passenger("Passenger 3");



        p1.addTicket(airport.newTicketrandomNr(a1),airport);
        p2.addTicket(airport.newTicketrandomNr(a2),airport);
        p3.addTicket(airport.newTicketrandomNr(a3),airport);

        System.out.println("Airplanes at ground: ");
        airport.listAirplanes();

        System.out.println("Airport profit: "+airport.getProfit());
    }
}
