package CompartmentPackage;

import CarriablePackage.CargoItem;
import CarriablePackage.Carriable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * Created by abran on 05.01.2017.
 */
public class CargoCompartment extends Compartment
{
    private CargoItem item;
    private ArrayList<Carriable> carriableList=new ArrayList<>();
    public CargoCompartment()
    {
        super();
    }

    public CargoCompartment(CargoItem item)
    {
        super();
        this.item=item;
    }

    public void addItem()
    {
        carriableList.add(this.item);
    }

    public int getProfit()
    {
        return carriableList.size()*item.getProfit();
    }

    @Override
    public int compareTo(@NotNull Compartment o) {
        return this.ID.compareTo(o.ID);
    }
}
