package Passengers;

/**
 * Created by abran on 17.01.2017.
 */
public abstract class Person implements PersonI
{
    private String name;
    public abstract void setName(String  name);
    public abstract String getName();
    public Person()
    {
        this.name="DEFAULT";
    }
    public Person(String name)
    {
        this.name=name;
    }
}
