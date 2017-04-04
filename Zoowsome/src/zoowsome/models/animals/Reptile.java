package zoowsome.models.animals;

import zoowsome.services.factories.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static zoowsome.repositories.AnimalRepository.createNode;

/**
 * Created by abran on 12.11.2016.
 */


public abstract class Reptile extends Animal
{
    private Boolean laysEggs;

    public Reptile()
    {
        super();
        laysEggs=false;
    }

    public  Reptile(int nrOfLegs,String name,boolean laysEggs,double maintenanceCost, double dangerPerc)
    {
        super(nrOfLegs,name, maintenanceCost, dangerPerc);
        this.laysEggs=laysEggs;
    }

    public boolean getLaysEggs()
    {
        return laysEggs;
    }

    public void setLaysEggs(boolean laysEggs)
    {
        this.laysEggs=laysEggs;
    }

    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException
    {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, "laysEggs", String.valueOf(getLaysEggs()));
    }


    public void decodeFromXml(org.w3c.dom.Element element)
    {
        setLaysEggs(Boolean.valueOf(element.getElementsByTagName("laysEggs").item(0).getTextContent()));

    }
}

