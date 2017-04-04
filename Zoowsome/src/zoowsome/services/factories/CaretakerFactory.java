package zoowsome.services.factories;


import zoowsome.models.employee.Caretaker;
import zoowsome.models.employee.Employee;

/**
 * Created by abran on 22.11.2016.
 */
public class CaretakerFactory {

    public Caretaker getCareTaker()
    {
        return new Caretaker();
    }

}
