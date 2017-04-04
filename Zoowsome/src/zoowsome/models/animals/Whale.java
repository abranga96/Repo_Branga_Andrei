package zoowsome.models.animals;

import zoowsome.services.factories.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static zoowsome.repositories.AnimalRepository.createNode;

/**
 * Created by abran on 12.11.2016.
 */
public class Whale extends Aquatic
{
    public Whale()
    {
        super();
        setNrOfLegs(0);
        setName("Whale");
        setAvgSwimDepth(400);
        setWaterType(WaterType.SaltWater);
    }

    public Whale(int nrOfLegs,String name,int avgSwimDepth,WaterType waterType,double maintenanceCost)
    {
        super(nrOfLegs,name,avgSwimDepth,waterType,maintenanceCost,0.4);
    }

    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException
    {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Aquatic.Whale);
    }
}
