package zoowsome.services.factories;

import zoowsome.models.animals.*;

/**
 * Created by abran on 12.11.2016.
 */
public class ReptileFactory extends SpeciesFactory
{
    public Animal getAnimal(String type) throws Exception {
        if(Constants.Animal.Reptile.Camaleon.equals(type))
        {
            return new Camaleon();
        }
        if(Constants.Animal.Reptile.Crocodile.equals(type))
        {
            return new Crocodile();
        }
        if(Constants.Animal.Reptile.Snake.equals(type))
        {
            return new Snake();
        }
        throw new Exception("Invalid animal exception!");
    }
}
