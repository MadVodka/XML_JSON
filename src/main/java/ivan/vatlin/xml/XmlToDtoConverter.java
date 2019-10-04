package ivan.vatlin.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

import static javax.xml.stream.XMLStreamConstants.START_ELEMENT;

public class XmlToDtoConverter<T> {
    private XmlStreamReaderFactory xmlStreamReaderFactory = new XmlStreamReaderFactory();
    private XMLStreamReader xmlStreamReader;
    private String pathToXml;
    private Class<T> dtoType;
    private String element;

    public XmlToDtoConverter(String pathToXml, Class<T> dtoType, String element) {
        this.pathToXml = pathToXml;
        this.dtoType = dtoType;
        this.element = element;
    }

    public List<T> getList() throws XMLStreamException, JAXBException {
        List<T> list = null;

        try {
            xmlStreamReader = xmlStreamReaderFactory.getXmlStreamReader(pathToXml);

            while (xmlStreamReader.hasNext()) {
                int event = xmlStreamReader.next();
                if (event == START_ELEMENT && element.equals(xmlStreamReader.getLocalName())) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(getBindDto());
                }
            }

            return list;
        } finally {
            if (xmlStreamReader!=null) {
                xmlStreamReader.close();
            }
        }
    }

    public T getElementWithAttribute(String attribute, String attributeValue)
            throws XMLStreamException, JAXBException {
        try {
            xmlStreamReader = xmlStreamReaderFactory.getXmlStreamReader(pathToXml);

            while (xmlStreamReader.hasNext()) {
                int event = xmlStreamReader.next();
                if (isStartElementFound(event, element) && isAttributeFound(attribute, attributeValue)) {
                    return getBindDto();
                }
            }
            return null;
        } finally {
            xmlStreamReader.close();
        }
    }

    private boolean isStartElementFound(int event, String element) {
        return event == START_ELEMENT && element.equals(xmlStreamReader.getLocalName());
    }

    private boolean isAttributeFound(String attribute, String attributeValue) {
        return xmlStreamReader.getAttributeValue(null, attribute).equals(attributeValue);
    }

    private T getBindDto() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(dtoType);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<T> jaxbElement = unmarshaller.unmarshal(xmlStreamReader, dtoType);

        return jaxbElement.getValue();
    }
}
