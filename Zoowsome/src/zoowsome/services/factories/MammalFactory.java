package zoowsome.services.factories;

import zoowsome.models.animals.Animal;
import zoowsome.models.animals.Cow;
import zoowsome.models.animals.Dog;
import zoowsome.models.animals.Tiger;

/**
 * Created by abran on 12.11.2016.
 */
public class MammalFactory extends SpeciesFactory
{
    public Animal getAnimal(String type) throws Exception {
        if(Constants.Animal.Mammal.Dog.equals(type))
        {
            return new Dog();
        }
        if(Constants.Animal.Mammal.Cow.equals(type))
        {
            return new Cow();
        }
        if(Constants.Animal.Mammal.Tiger.equals(type))
        {
            return new Tiger();
        }
        throw new Exception("Invalid animal exception!");
    }
}
