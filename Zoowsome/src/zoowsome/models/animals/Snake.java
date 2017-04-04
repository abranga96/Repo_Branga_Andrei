package zoowsome.models.animals;

import zoowsome.services.factories.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static zoowsome.repositories.AnimalRepository.createNode;

/**
 * Created by abran on 12.11.2016.
 */
public class Snake extends Reptile
{
    public Snake()
    {
        super();
        setNrOfLegs(0);
        setName("Snake");
        setLaysEggs(true);
    }

    public Snake(int nrOfLegs,String name,boolean laysEggs,double maintenanceCost)
    {
        super(nrOfLegs,name,laysEggs,maintenanceCost,0.6);
    }

    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException
    {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Reptile.Snake);
    }
}
