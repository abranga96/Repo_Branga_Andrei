package zoowsome.models.animals;

import zoowsome.services.factories.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static zoowsome.repositories.AnimalRepository.createNode;

/**
 * Created by abran on 12.11.2016.
 */
public abstract class Insect extends Animal
{
    private Boolean canFly,isDangerous;

    public Insect()
    {
        super();
        canFly=false;
        isDangerous=false;
    }

    public Insect(int nrOfLegs,String name,boolean canFly,boolean isDangerous,double maintenanceCost, double dangerPerc)
    {
        super(nrOfLegs,name, maintenanceCost, dangerPerc);
        this.canFly=canFly;
        this.isDangerous=isDangerous;
    }

    public boolean getIsDangerous()
    {
        return  isDangerous;
    }

    public void setIsDangerous(boolean isDangerous)
    {
        this.isDangerous=isDangerous;
    }

    public boolean getCanFly()
    {
        return canFly;
    }

    public void setCanFly(boolean canFly)
    {
        this.canFly=canFly;
    }

    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException
    {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, "canFly", String.valueOf(getCanFly()));
        createNode(eventWriter, "isDangerous", String.valueOf(getIsDangerous()));
    }
    public void decodeFromXml(org.w3c.dom.Element element)
    {
        setCanFly(Boolean.valueOf(element.getElementsByTagName("canFly").item(0).getTextContent()));
        setIsDangerous(Boolean.valueOf(element.getElementsByTagName("isDangerous").item(0).getTextContent()));
    }

}
