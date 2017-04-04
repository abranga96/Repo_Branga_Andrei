/**
 * Created by abran on 12.11.2016.
 */

package zoowsome.services.factories;
public class AnimalFactory
{
    public SpeciesFactory getSpeciesFactory(String type) throws Exception {
        if (Constants.Species.Mammal.equals(type)) {
            return new MammalFactory();
        } else if (Constants.Species.Reptile.equals(type)) {
            return new ReptileFactory();
        } else if (Constants.Species.Bird.equals(type)) {
            return new BirdFactory();
        } else if (Constants.Species.Insect.equals(type)) {
            return new InsectFactory();
        } else if (Constants.Species.Aquatic.equals(type)) {
            return new AquaticFactory();
        } else
            throw new Exception("Invalid species exception");
    }

}
