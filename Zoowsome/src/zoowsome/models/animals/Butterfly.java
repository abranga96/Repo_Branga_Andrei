package zoowsome.models.animals;

import zoowsome.services.factories.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static zoowsome.repositories.AnimalRepository.createNode;

/**
 * Created by abran on 12.11.2016.
 */
public class Butterfly extends Insect
{
    public Butterfly()
    {
        super();
        setNrOfLegs(6);
        setName("Butterfly");
        setCanFly(true);
        setIsDangerous(false);
    }

    public Butterfly(int nrOfLegs, String name, boolean canFly, boolean isDangerous,double maintenanceCost)
    {
        super(nrOfLegs,name,canFly,isDangerous,maintenanceCost,0.0);
    }

    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException
    {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Insect.Butterfly);
    }


}
