package zoowsome.models.animals;

import zoowsome.services.factories.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static zoowsome.repositories.AnimalRepository.createNode;

/**
 * Created by abran on 12.11.2016.
 */
public class Tiger extends Mammal
{
    public Tiger()
    {
        super();
        setName("Tiger");
        setNrOfLegs(4);
        setNormalBodyTemp((double) 33.2);
        setPercBodyHair((double) 0.98);
    }

    public Tiger(int nrOfLegs,String name,float normalBodyTemp,float percBodyHair,double maintenanceCost)
    {
        super(nrOfLegs,name,normalBodyTemp,percBodyHair,maintenanceCost,1.0);
    }

    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException
    {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Mammal.Tiger);
    }
}
