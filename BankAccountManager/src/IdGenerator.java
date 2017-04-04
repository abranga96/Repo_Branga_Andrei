/**
 * Created by abran on 17.11.2016.
 */
public class IdGenerator
{
    private static long id = 111111111;

    public static long getId()
    {
        id++;
        if (id==999999999)
        {
            System.out.println("WARNING: ID LIMIT REACHED!!!!");
        }
        return id;
    }
}
