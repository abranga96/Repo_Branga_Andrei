package ShipBay;

import ShipPackage.Ship;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by abran on 05.01.2017.
 */
public class ShipBay {

    private final String name;

    public SortedSet<Ship> shipList=new TreeSet<Ship>();


    public ShipBay()
    {
        name="DEFAULT";
    }

    public ShipBay(String name)
    {
        this.name=name;
    }

    public void addShip(Ship ship)
    {
        shipList.add(ship);
    }

    public int  getProfit()
    {
        int sum=0;
        for (Ship s:shipList
             ) {sum+=s.getProfit();

        }
        return sum;
    }

    public void listShips()
    {
        for (Ship s:shipList
             ) {System.out.println(s.getName());

        }
    }

    public boolean isInBay(String name)
    {
        for (Ship s:shipList
             ) {
            if(s.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }

    public Ship getByName(String name)
    {
        for (Ship s:shipList
                ) {
            if(s.getName().equals(name))
            {
                return s;
            }
        }
        return null;
    }

    public void departShip(String name)
    {
        if (isInBay(name))
        {
            shipList.remove(getByName(name));
        }
    }

}
