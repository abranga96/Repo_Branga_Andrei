package ShipPackage;

import CompartmentPackage.Compartment;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by abran on 05.01.2017.
 */
public class Ship<T extends Compartment> implements java.lang.Comparable<Ship> {
    private final String name;

    private SortedSet<T> compartmentList=new TreeSet<T>();

    public Ship()
    {
        name="DEFAULT";
    }

    public Ship(String name)
    {
        this.name=name;
    }

    public void addCompartment(T t)
    {
        compartmentList.add(t);
    }

    public int getProfit()
    {
        int sum=0;
        for (T comp:compartmentList
             ) {sum+=comp.getProfit();
            
        }
        return sum;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public int compareTo(@NotNull Ship o) {
        return this.name.compareTo(o.getName());
    }
}
