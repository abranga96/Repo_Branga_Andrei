package zoowsome.controllers;

import zoowsome.models.animals.Animal;
import zoowsome.models.employee.Caretaker;
import zoowsome.repositories.AnimalRepository;
import zoowsome.repositories.CaretakerRepository;
import zoowsome.services.factories.AnimalFactory;
import zoowsome.services.factories.Constants;
import zoowsome.services.factories.CaretakerFactory;
import zoowsome.services.factories.SpeciesFactory;
import zoowsome.views.MainMenuFrame;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception
    {
        new MainMenuController(new MainMenuFrame("Main Menu"),false);

       /* AnimalFactory abstractFactory = new AnimalFactory();
        CaretakerFactory abstractCareFactory = new CaretakerFactory();

        ArrayList<Animal> animals = new ArrayList<Animal>();
        ArrayList<Caretaker> careTakers = new ArrayList<Caretaker>();

        SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Mammal);
        SpeciesFactory speciesFactory2 = abstractFactory.getSpeciesFactory(Constants.Species.Aquatic);
        SpeciesFactory speciesFactory3 = abstractFactory.getSpeciesFactory(Constants.Species.Insect);

        animals.add(speciesFactory1.getAnimal(Constants.Animal.Mammal.Cow));
        animals.add(speciesFactory1.getAnimal(Constants.Animal.Mammal.Tiger));

        animals.add(speciesFactory2.getAnimal(Constants.Animal.Aquatic.Dolphin));
        animals.add(speciesFactory2.getAnimal(Constants.Animal.Aquatic.Shark));

        animals.add(speciesFactory3.getAnimal(Constants.Animal.Insect.Butterfly));
        animals.add(speciesFactory3.getAnimal(Constants.Animal.Insect.Cockroach));

        careTakers.add(abstractCareFactory.getCareTaker());
        careTakers.add(abstractCareFactory.getCareTaker());
        careTakers.add(abstractCareFactory.getCareTaker());
        careTakers.add(abstractCareFactory.getCareTaker());
        careTakers.add(abstractCareFactory.getCareTaker());
        careTakers.add(abstractCareFactory.getCareTaker());
        String result;
        for (Caretaker c:careTakers
                )
        {
            for (Animal a:animals
                    )
            {
                if (!c.getIsDead() && !a.getTakenCareOf())
                {
                    result=c.takeCareOf(a);
                    if (result.equals(Constants.Employee.Caretakers.TCO_KILLED))
                    {
                        System.out.println("Caretaker: " + c.getName() + " is dead!");
                    }
                    else
                    {
                        if (result.equals(Constants.Employee.Caretakers.TCO_NO_TIME))
                        {
                            continue;
                        }
                        else
                        {
                            a.setTakenCareOf(true);
                        }
                    }
                }

            }

        }


        for (Animal a:animals
                ) {
            if(a.getTakenCareOf()==false)
            {
                System.out.println("Animal: "+ a.getName() + " not taken care of!");
            }

        }

        AnimalRepository rep =new AnimalRepository();
        rep.save(animals);

        ArrayList<Animal> animals2=rep.load();

        CaretakerRepository  carrep=new CaretakerRepository();
        carrep.save(careTakers);

        ArrayList<Caretaker> listcare= carrep.load();*/


    }
}
