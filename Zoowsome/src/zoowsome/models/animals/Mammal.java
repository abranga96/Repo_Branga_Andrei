/**
 * Created by abran on 12.11.2016.
 */
package zoowsome.models.animals;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static zoowsome.repositories.AnimalRepository.createNode;

public abstract class  Mammal extends Animal
{
    private double normalBodyTemp,percBodyHair;

    public Mammal()
    {
        super();
        normalBodyTemp=0;
        percBodyHair=0;
    }

    public Mammal(int nrOfLegs,String name,float normalBodyTemp,float percBodyHair,double maintenanceCost, double dangerPerc)
    {
        super(nrOfLegs,name, maintenanceCost, dangerPerc);
        this.normalBodyTemp=normalBodyTemp;
        this.percBodyHair=percBodyHair;
    }

    public double getNormalBodyTemp()
    {
        return normalBodyTemp;
    }

    public double getPercBodyHair()
    {
        return percBodyHair;
    }

    public void setNormalBodyTemp(Double normalBodyTemp)
    {
        this.normalBodyTemp=normalBodyTemp;
    }

    public void setPercBodyHair(Double percBodyHair)
    {
        this.percBodyHair=percBodyHair;
    }

    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException
    {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, "normalBodyTemp", String.valueOf(getNormalBodyTemp()));
        createNode(eventWriter, "percBodyHair", String.valueOf(getPercBodyHair()));
    }

    public void decodeFromXml(org.w3c.dom.Element element)
    {
        setNormalBodyTemp(Double.valueOf(element.getElementsByTagName("normalBodyTemp").item(0).getTextContent()));
        setPercBodyHair(Double.valueOf(element.getElementsByTagName("percBodyHair").item(0).getTextContent()));
    }

}
