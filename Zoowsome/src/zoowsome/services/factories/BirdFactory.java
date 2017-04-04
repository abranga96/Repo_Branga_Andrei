package zoowsome.services.factories;

import zoowsome.models.animals.*;

/**
 * Created by abran on 12.11.2016.
 */
public class BirdFactory extends SpeciesFactory
{
    public Animal getAnimal(String type) throws Exception {
        if(Constants.Animal.Bird.Canary.equals(type))
        {
            return new Canary();
        }
        if(Constants.Animal.Bird.Eagle.equals(type))
        {
            return new Eagle();
        }
        if(Constants.Animal.Bird.Pigeon.equals(type))
        {
            return new Pigeon();
        }
        throw new Exception("Invalid animal exception!");
    }
}
