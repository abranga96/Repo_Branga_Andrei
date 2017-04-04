package zoowsome.models.animals;

import zoowsome.services.factories.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static zoowsome.repositories.AnimalRepository.createNode;

/**
 * Created by abran on 12.11.2016.
 */

public abstract class Bird extends Animal
{
    private Boolean migrates;
    private int averageFlightAltitude;

    public Bird()
    {
        super();
        migrates=false;
        averageFlightAltitude=0;
    }

    public Bird(int nrOfLegs,String name,boolean migrates,int averageFlightAltitude,double maintenanceCost, double dangerPerc)
    {
        super(nrOfLegs,name, maintenanceCost, dangerPerc);
        this.averageFlightAltitude=averageFlightAltitude;
        this.migrates=migrates;
    }

    public boolean getMigrates()
    {
        return migrates;
    }

    public void setMigrates(boolean migrates)
    {
        this.migrates=migrates;
    }

    public int getAverageFlightAltitude()
    {
        return  averageFlightAltitude;
    }

    public void setAverageFlightAltitude(int averageFlightAltitude)
    {
        this.averageFlightAltitude=averageFlightAltitude;
    }

    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException
    {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, "migrates", String.valueOf(getMigrates()));
        createNode(eventWriter, "averageFlightAltitude", String.valueOf(getAverageFlightAltitude()));
    }

    public void decodeFromXml(org.w3c.dom.Element element)
    {
        setMigrates(Boolean.valueOf(element.getElementsByTagName("migrates").item(0).getTextContent()));
        setAverageFlightAltitude(Integer.valueOf(element.getElementsByTagName("averageFlightAltitude").item(0).getTextContent()));
    }

}
