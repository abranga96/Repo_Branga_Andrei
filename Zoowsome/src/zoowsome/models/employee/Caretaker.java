package zoowsome.models.employee;

import org.w3c.dom.Element;
import zoowsome.models.animals.Animal;
import zoowsome.models.interfaces.XML_Parsable;
import zoowsome.services.factories.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import java.math.BigDecimal;
import java.util.UUID;

import static zoowsome.repositories.AnimalRepository.createNode;

/**
 * Created by abran on 22.11.2016.
 */
public class Caretaker extends Employee implements Caretaker_I,XML_Parsable
{
    private double workingHours;

    public Caretaker()
    {
        super();
        this.workingHours=0;
    }

    public  Caretaker(String name, BigDecimal salary, boolean isDead,double workingHours)
    {
        super(name, salary, isDead);
        this.workingHours=workingHours;
    }

    public double getWorkingHours()
    {
        return workingHours;
    }

    public void setWorkingHours(double workingHours)
    {
        this.workingHours=workingHours;
    }

    @Override
    public String takeCareOf(Animal animal) {
        if (animal.kill())
        {
            return Constants.Employee.Caretakers.TCO_KILLED;
        }

        if (this.workingHours<animal.getMaintenanceCost())
        {
            return Constants.Employee.Caretakers.TCO_NO_TIME;
        }

        animal.setTakenCareOf(true);

        this.workingHours-=animal.getMaintenanceCost();

        return  Constants.Employee.Caretakers.TCO_SUCCESS;
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {

        createNode(eventWriter, "name", String.valueOf(this.name));
        createNode(eventWriter, "salary", String.valueOf(this.salary));
        createNode(eventWriter, "isDead", String.valueOf(this.isDead));
        createNode(eventWriter, "id", String.valueOf(this.id));
        createNode(eventWriter, "workingHours", String.valueOf(this.workingHours));
    }

    @Override
    public void decodeFromXml(Element element) {

        setName(element.getElementsByTagName("name").item(0).getTextContent());
        setSalary(BigDecimal.valueOf(Double.valueOf(element.getElementsByTagName("salary").item(0).getTextContent())));
        setIsDead(Boolean.valueOf(element.getElementsByTagName("isDead").item(0).getTextContent()));
        setID(UUID.fromString(element.getElementsByTagName("id").item(0).getTextContent()));
        setWorkingHours(Double.valueOf(element.getElementsByTagName("workingHours").item(0).getTextContent()));
    }
}
