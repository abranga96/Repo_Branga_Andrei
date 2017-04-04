package zoowsome.models.animals;

import zoowsome.services.factories.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import java.util.Date;

import static zoowsome.repositories.AnimalRepository.createNode;

/**
 * Created by abran on 12.11.2016.
 */
public class Spider extends Insect
{
    public Spider()
    {
        super();
        setNrOfLegs(8);
        setName("Spider");
        setCanFly(true);
        setIsDangerous(true);
    }

    public Spider(int nrOfLegs, String name, boolean canFly, boolean isDangerous,double maintenanceCost)
    {
        super(nrOfLegs,name,canFly,isDangerous,maintenanceCost,0.5);
    }

    public double getPredisposition() {
        Date d1=new Date("23:00:00");
        Date d2=new Date("06:00:00");
        Date d3=new Date();
        if (d3.after(d1) && d3.before(d2))
        {
            return 0.25;
        }
        else
        {
            return 0;
        }
    }

    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException
    {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Insect.Spider);
    }

}
