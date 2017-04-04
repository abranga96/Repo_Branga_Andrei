package zoowsome.models.animals;

import zoowsome.services.factories.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static zoowsome.repositories.AnimalRepository.createNode;

/**
 * Created by abran on 12.11.2016.
 */
public class Cockroach extends Insect
{
    public Cockroach()
    {
        super();
        setNrOfLegs(6);
        setName("Cockroach");
        setCanFly(false);
        setIsDangerous(false);
    }

    public Cockroach(int nrOfLegs, String name, boolean canFly, boolean isDangerous,double maintenanceCost)
    {
        super(nrOfLegs,name,canFly,isDangerous,maintenanceCost,0.2);
    }

    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException
    {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Insect.Cockroach);
    }
}
