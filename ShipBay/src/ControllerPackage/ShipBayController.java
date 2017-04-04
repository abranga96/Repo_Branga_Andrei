package ControllerPackage;

import CarriablePackage.CargoItem;
import CarriablePackage.Passenger;
import CompartmentPackage.CargoCompartment;
import CompartmentPackage.PassengerCompartment;
import GUI.MainMenu;
import ShipBay.ShipBay;
import ShipPackage.Ship;

public class ShipBayController {

    public static void main(String[] args) {
        ShipBay shipBay=new ShipBay("ShipBay");
        MainMenu form=new MainMenu(shipBay);
        form.setVisible(true);
       /* PassengerCompartment p1=new PassengerCompartment();
        p1.addPassenger(new Passenger("pass1"));
        p1.addPassenger(new Passenger("pass2"));
        p1.addPassenger(new Passenger("pass3"));
        p1.addPassenger(new Passenger("pass4"));
        PassengerCompartment p2=new PassengerCompartment();
        p2.addPassenger(new Passenger("pass1"));
        p2.addPassenger(new Passenger("pass2"));
        p2.addPassenger(new Passenger("pass3"));
        p2.addPassenger(new Passenger("pass4"));
        PassengerCompartment p3=new PassengerCompartment();
        p3.addPassenger(new Passenger("pass1"));
        p3.addPassenger(new Passenger("pass2"));
        p3.addPassenger(new Passenger("pass3"));
        p3.addPassenger(new Passenger("pass4"));
        PassengerCompartment p4=new PassengerCompartment();
        p4.addPassenger(new Passenger("pass1"));
        p4.addPassenger(new Passenger("pass2"));
        p4.addPassenger(new Passenger("pass3"));
        p4.addPassenger(new Passenger("pass4"));

        CargoItem c1=new CargoItem("car1",5);
        CargoItem c2=new CargoItem("car2",5);
        CargoItem c3=new CargoItem("car3",5);
        CargoItem c4=new CargoItem("car4",5);

        CargoCompartment cargo1=new CargoCompartment(c1);
        cargo1.addItem();
        cargo1.addItem();
        CargoCompartment cargo2=new CargoCompartment(c2);
        cargo2.addItem();
        cargo2.addItem();
        CargoCompartment cargo3=new CargoCompartment(c3);
        cargo3.addItem();
        cargo3.addItem();
        CargoCompartment cargo4=new CargoCompartment(c4);
        cargo4.addItem();
        cargo4.addItem();

       Ship<CargoCompartment> cargoCompartmentShip=new Ship<CargoCompartment>("Cargo Ship");


        Ship<PassengerCompartment> passengerCompartmentShip=new Ship<PassengerCompartment>("Passenger Ship");

        cargoCompartmentShip.addCompartment(cargo1);
        cargoCompartmentShip.addCompartment(cargo2);
        cargoCompartmentShip.addCompartment(cargo3);
        cargoCompartmentShip.addCompartment(cargo4);

        passengerCompartmentShip.addCompartment(p1);
        passengerCompartmentShip.addCompartment(p2);
        passengerCompartmentShip.addCompartment(p3);
        passengerCompartmentShip.addCompartment(p4);


        ShipBay shipBay=new ShipBay("First ShipBay");

        shipBay.addShip(passengerCompartmentShip);

        shipBay.addShip(cargoCompartmentShip);

        shipBay.departShip("Cargo Ship");

        shipBay.departShip("Passenger Ship");

        shipBay.addShip(passengerCompartmentShip);
        shipBay.addShip(cargoCompartmentShip);

        */
    }
}
