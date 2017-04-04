package zoowsome.models.animals;

import zoowsome.services.factories.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static zoowsome.repositories.AnimalRepository.createNode;

/**
 * Created by abran on 12.11.2016.
 */
public class Camaleon extends Reptile
{
    public Camaleon()
    {
        super();
        setNrOfLegs(4);
        setName("Camaleon");
        setLaysEggs(true);
    }

    public Camaleon(int nrOfLegs,String name,boolean laysEggs,double maintenanceCost)
    {
        super(nrOfLegs,name,laysEggs,maintenanceCost,0.05);
    }

    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException
    {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Reptile.Camaleon);
    }
}
