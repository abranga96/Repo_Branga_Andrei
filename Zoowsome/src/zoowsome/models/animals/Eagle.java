package zoowsome.models.animals;

import zoowsome.services.factories.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static zoowsome.repositories.AnimalRepository.createNode;

/**
 * Created by abran on 12.11.2016.
 */
public class Eagle extends Bird
{
    public Eagle()
    {
        super();
        setNrOfLegs(2);
        setName("Eagle");
        setAverageFlightAltitude(600);
        setMigrates(true);
    }

    public Eagle(int nrOfLegs,String name,int averageFlightAltitude,boolean migrates,double maintenanceCost)
    {
        super(nrOfLegs,name,migrates,averageFlightAltitude,maintenanceCost,0.3);
    }

    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException
    {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Bird.Eagle);
    }
}
