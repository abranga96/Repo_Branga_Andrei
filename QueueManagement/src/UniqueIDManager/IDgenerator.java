package UniqueIDManager;

import java.util.UUID;

/**
 * Created by Andrei on 20.03.2017.
 */
public class IDgenerator {
    public static UUID getUniqueID()
    {
        return UUID.randomUUID();
    }
}
