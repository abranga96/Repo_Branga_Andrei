package zoowsome.services.factories;
import zoowsome.models.animals.Animal;

/**
 * Created by abran on 12.11.2016.
 */
public abstract class SpeciesFactory
{
    public abstract Animal getAnimal(String type) throws Exception;
}
