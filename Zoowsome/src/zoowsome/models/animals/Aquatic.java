package zoowsome.models.animals;

import zoowsome.services.factories.Constants;

import javax.xml.bind.Element;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static zoowsome.repositories.AnimalRepository.createNode;

/**
 * Created by abran on 12.11.2016.
 */
public abstract class Aquatic extends Animal
{
    private int avgSwimDepth;
    private WaterType waterType;

    public Aquatic()
    {
        super();
        avgSwimDepth=0;
        waterType=WaterType.FreshWater;
    }

    public Aquatic(int nrOfLegs, String name,int avgSwimDepth,WaterType waterType,double maintenanceCost, double dangerPerc)
    {
        super(nrOfLegs,name, maintenanceCost, dangerPerc);
        this.avgSwimDepth=avgSwimDepth;
        this.waterType=waterType;
    }

    public int getAvgSwimDepth()
    {
        return avgSwimDepth;
    }

    public void setAvgSwimDepth(int avgSwimDepth)
    {
        this.avgSwimDepth=avgSwimDepth;
    }

    public WaterType getWaterType()
    {
        return waterType;
    }

    public void setWaterType(WaterType waterType)
    {
        this.waterType=waterType;
    }

    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException
    {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, "avgSwimDepth", String.valueOf(getAvgSwimDepth()));
        createNode(eventWriter, "waterType", String.valueOf(getWaterType()));
    }

    public void decodeFromXml(org.w3c.dom.Element element)
    {
        setAvgSwimDepth(Integer.valueOf(element.getElementsByTagName("avgSwimDepth").item(0).getTextContent()));
        setWaterType(WaterType.valueOf(element.getElementsByTagName("waterType").item(0).getTextContent()));
    }
}
