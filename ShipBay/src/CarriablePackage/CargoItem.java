package CarriablePackage;

/**
 * Created by abran on 05.01.2017.
 */
public class CargoItem extends Carriable {
    private final int profit;

    public CargoItem()
    {
        super();
        profit=0;
    }

    public CargoItem(String name,int profit)
    {
        super(name);
        this.profit=profit;
    }

    public int getProfit()
    {
        return profit;
    }
}
