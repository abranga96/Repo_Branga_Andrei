package zoowsome.models.employee;

import java.util.UUID;

/**
 * Created by abran on 22.11.2016.
 */
public class UniqueID
{
    public static UUID getId()
    {
        return UUID.randomUUID();
    }
}
