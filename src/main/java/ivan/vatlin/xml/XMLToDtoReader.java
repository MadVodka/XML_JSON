package ivan.vatlin.xml;

import ivan.vatlin.entity.Category;
import ivan.vatlin.entity.Item;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;
import java.util.List;

public class XMLToDtoReader implements XMLReader<Category> {
    private String elementName = "category";
    private XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    private StreamSource streamSource = new StreamSource("src/main/resources/xml/test_items.xml");
    private XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(streamSource);

    public XMLToDtoReader() throws XMLStreamException {
    }

    @Override
    public List<Category> getList() throws XMLStreamException, JAXBException {
        List<Category> categories = new ArrayList<>();
        while (xmlStreamReader.hasNext()) {
            int event = xmlStreamReader.next();
            if (event == XMLEvent.START_ELEMENT && elementName.equals(xmlStreamReader.getLocalName())) {
                categories.add(getItem(xmlStreamReader));
            }
        }

        return categories;
    }

    private Category getItem(XMLStreamReader xmlStreamReader) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Category.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<Category> jaxbElement = unmarshaller.unmarshal(xmlStreamReader, Category.class);

        return jaxbElement.getValue();
    }
}
