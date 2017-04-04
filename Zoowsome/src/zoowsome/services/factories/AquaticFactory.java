package zoowsome.services.factories;

import zoowsome.models.animals.*;

/**
 * Created by abran on 12.11.2016.
 */
public class AquaticFactory extends SpeciesFactory
{
    public Animal getAnimal(String type) throws Exception {
        if(Constants.Animal.Aquatic.Dolphin.equals(type))
        {
            return new Dolphin();
        }
        if(Constants.Animal.Aquatic.Shark.equals(type))
        {
            return new Shark();
        }
        if(Constants.Animal.Aquatic.Whale.equals(type))
        {
            return new Whale();
        }
        throw new Exception("Invalid animal exception!");
    }
}
