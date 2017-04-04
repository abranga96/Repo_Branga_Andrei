package zoowsome.repositories;

import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import zoowsome.models.animals.*;
import zoowsome.models.employee.Caretaker;
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

import zoowsome.repositories.EntityRepository.*;
/**
 * Created by abran on 01.12.2016.
 */
public class CaretakerRepository extends EntityRepository<Caretaker>
{
    private static final String XML_FILENAME = "Caretakers.xml";

    public CaretakerRepository() {
        super(XML_FILENAME,Constants.XML_TAGS.CARETAKER);

    }



    protected Caretaker getEntityFromXmlElement(Element element)
    {
        Caretaker caretaker = new Caretaker();
        caretaker.decodeFromXml(element);
        return caretaker;
    }



}
