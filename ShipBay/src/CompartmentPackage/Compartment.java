package CompartmentPackage;

import UUID_Manager.UUID;

/**
 * Created by abran on 05.01.2017.
 */
public abstract class Compartment implements java.lang.Comparable<Compartment>
{
    public final java.util.UUID ID;

    public Compartment()
    {
        ID=UUID.getID();
    }
    public abstract int getProfit();


}
