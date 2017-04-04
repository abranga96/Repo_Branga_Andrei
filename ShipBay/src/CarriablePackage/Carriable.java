package CarriablePackage;

/**
 * Created by abran on 05.01.2017.
 */
public class Carriable implements CarriableInterface {
    private final String name;

    public Carriable()
    {
        name="DEFAULT";
    }

    public Carriable(String name)
    {
        this.name=name;
    }

    public String getName()
    {
        return name;
    }
}
