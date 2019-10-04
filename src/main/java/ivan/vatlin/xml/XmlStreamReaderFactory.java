package ivan.vatlin.xml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

public class XmlStreamReaderFactory {
    private XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    private StreamSource streamSource;

    public XMLStreamReader getXmlStreamReader(String pathToXml) throws XMLStreamException {
        streamSource = new StreamSource(pathToXml);
        return xmlInputFactory.createXMLStreamReader(streamSource);
    }
}
