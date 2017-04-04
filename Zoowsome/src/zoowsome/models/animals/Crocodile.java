package zoowsome.models.animals;

import zoowsome.services.factories.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static zoowsome.repositories.AnimalRepository.createNode;

/**
 * Created by abran on 12.11.2016.
 */
public class Crocodile extends Reptile
{
    public Crocodile()
    {
        super();
        setNrOfLegs(4);
        setName("Crocodile");
        setLaysEggs(true);
    }

    public Crocodile(int nrOfLegs,String name,boolean laysEggs,double maintenanceCost)
    {
        super(nrOfLegs,name,laysEggs,maintenanceCost,0.9);
    }

    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException
    {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Reptile.Crocodile);
    }
}
