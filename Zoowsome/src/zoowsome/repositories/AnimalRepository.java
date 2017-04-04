package zoowsome.repositories;

import a.a.b.b.T;
import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import zoowsome.models.animals.*;
import zoowsome.models.interfaces.XML_Parsable;
import zoowsome.services.factories.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;

import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.XMLEventFactory;
/**
 * Created by abran on 01.12.2016.
 */
public class AnimalRepository extends EntityRepository<Animal>
{
    private static final String XML_FILENAME = "Animals.xml";

    public AnimalRepository() {
        super(XML_FILENAME, Constants.XML_TAGS.ANIMAL);

    }



    protected Animal getEntityFromXmlElement(Element element)
    {
        String discriminant = element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0) .getTextContent();
        switch (discriminant)
        {
            case Constants.Animal.Insect.Butterfly:
                Animal butterfly = new Butterfly();
                butterfly.decodeFromXml(element);
                return butterfly;

            case Constants.Animal.Insect.Cockroach:
                Animal cockroach=new Cockroach();
                cockroach.decodeFromXml(element);
                return cockroach;

            case Constants.Animal.Insect.Spider:
                Animal spider=new Spider();
                spider.decodeFromXml(element);
                return spider;

            case Constants.Animal.Aquatic.Dolphin:
                Animal dolphin =new Dolphin();
                dolphin.decodeFromXml(element);
                return dolphin;

            case Constants.Animal.Aquatic.Shark:
                Animal shark=new Shark();
                shark.decodeFromXml(element);
                return shark;

            case Constants.Animal.Aquatic.Whale:
                Animal whale = new Whale();
                whale.decodeFromXml(element);
                return whale;

            case Constants.Animal.Bird.Canary:
                Animal canary =new Canary();
                canary.decodeFromXml(element);
                return canary;

            case Constants.Animal.Bird.Eagle:
                Animal eagle = new Eagle();
                eagle.decodeFromXml(element);
                return eagle;

            case Constants.Animal.Bird.Pigeon:
                Animal pigeon = new Pigeon();
                pigeon.decodeFromXml(element);
                return pigeon;

            case Constants.Animal.Mammal.Cow:
                Animal cow = new Cow();
                cow.decodeFromXml(element);
                return cow;

            case Constants.Animal.Mammal.Dog:
                Animal dog = new Dog();
                dog.decodeFromXml(element);
                return dog;

            case Constants.Animal.Mammal.Tiger:
                Animal tiger = new Tiger();
                tiger.decodeFromXml(element);
                return tiger;

            case Constants.Animal.Reptile.Camaleon:
                Animal camaleon = new Camaleon();
                camaleon.decodeFromXml(element);
                return camaleon;

            case Constants.Animal.Reptile.Crocodile:
                Animal crocodile = new Crocodile();
                crocodile.decodeFromXml(element);
                return crocodile;

            case Constants.Animal.Reptile.Snake:
                Animal snake = new Snake();
                snake.decodeFromXml(element);
                return snake;


            default:      break;
        }
        return null;
    }



}
