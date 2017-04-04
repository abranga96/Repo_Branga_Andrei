package zoowsome.services.factories;

import zoowsome.models.animals.*;

/**
 * Created by abran on 12.11.2016.
 */
public class InsectFactory extends SpeciesFactory
{
    public Animal getAnimal(String type) throws Exception {
        if(Constants.Animal.Insect.Butterfly.equals(type))
        {
            return new Butterfly();
        }
        if(Constants.Animal.Insect.Cockroach.equals(type))
        {
            return new Cockroach();
        }
        if(Constants.Animal.Insect.Spider.equals(type))
        {
            return new Spider();
        }
        throw new Exception("Invalid animal exception!");
    }
}
