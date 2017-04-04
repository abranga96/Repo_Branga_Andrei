/**
 * Created by abran on 12.11.2016.
 */

package zoowsome.models.animals;

import org.w3c.dom.Element;
import zoowsome.models.interfaces.XML_Parsable;

import javax.xml.stream.XMLEventWriter;
import static zoowsome.repositories.AnimalRepository.createNode;


import javax.xml.stream.XMLStreamException;

public abstract class Animal implements Killer,XML_Parsable
{
    private int nrOfLegs;
    private String name;
    private  double maintenanceCost;
    private final double MIN_MAINTENANCE_COST=0.1;
    private final double MAX_MAINTENANCE_COST=8.0;
    private  double dangerPerc;

    private boolean takenCareOf = false;

    public int getNrOfLegs()
    {
        return nrOfLegs;
    }

    public void setNrOfLegs(int nrOfLegs)
    {
        this.nrOfLegs=nrOfLegs;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public Animal()
    {
        this.maintenanceCost=0.1;
        nrOfLegs=0;
        name=null;
        this.dangerPerc=0.1;
    }

    public Animal(int nrOfLegs, String name, double maintenanceCost, double dangerPerc)
    {
        this.nrOfLegs=nrOfLegs;
        this.name=name;
        if (dangerPerc>=0 && dangerPerc<=1)
        {
            this.dangerPerc = dangerPerc;
        }
        else
        {
            this.dangerPerc=0.5;
        }
        if (maintenanceCost<=MAX_MAINTENANCE_COST && maintenanceCost >=MIN_MAINTENANCE_COST)
        {
            this.maintenanceCost = maintenanceCost;
        }
        else
        {
            this.maintenanceCost = 4.0;
        }
    }

    @Override
    public double getPredisposition() {
        return 0;
    }

    public boolean kill()
    {
        if (Math.random() + getPredisposition()<dangerPerc)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean getTakenCareOf()
    {
        return  takenCareOf;
    }

    public void setTakenCareOf(boolean b)
    {
        this.takenCareOf=b;
    }

    public double getMaintenanceCost()
    {
        return maintenanceCost;
    }


    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException
    {
        createNode(eventWriter, "nrOfLegs", String.valueOf(this.nrOfLegs));
        createNode(eventWriter, "name", String.valueOf(this.name));
        createNode(eventWriter, "maintenanceCost", String.valueOf(this.maintenanceCost));
        createNode(eventWriter, "dangerPerc", String.valueOf(this.dangerPerc));
        createNode(eventWriter, "takenCareOf", String.valueOf(this.takenCareOf));
    }

    public void setMaintenanceCost(double maintenanceCost)
    {
        this.maintenanceCost=maintenanceCost;
    }

    public void  setDangerPerc(double dangerPerc)
    {
        this.dangerPerc=dangerPerc;
    }
    public void decodeFromXml(Element element)
    {
        setNrOfLegs(Integer.valueOf(element.getElementsByTagName("nrOfLegs").item(0).getTextContent()));
        setName(element.getElementsByTagName("name").item(0).getTextContent());
        setMaintenanceCost(Double.valueOf(element.getElementsByTagName("maintenanceCost").item(0).getTextContent()));
        setDangerPerc(Double.valueOf(element.getElementsByTagName("dangerPerc").item(0).getTextContent()));
        setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("takenCareOf").item(0).getTextContent()));
    }

}
