package zoowsome.models.animals;

import zoowsome.services.factories.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static zoowsome.repositories.AnimalRepository.createNode;

/**
 * Created by abran on 12.11.2016.
 */
public class Canary extends Bird
{
    public Canary()
    {
        super();
        setNrOfLegs(2);
        setName("Canary");
        setAverageFlightAltitude(100);
        setMigrates(false);
    }

    public Canary(int nrOfLegs,String name,int averageFlightAltitude,boolean migrates,double maintenanceCost)
    {
        super(nrOfLegs,name,migrates,averageFlightAltitude,maintenanceCost,0.1);
    }

    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException
    {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Bird.Canary);
    }
}
