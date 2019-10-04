package ivan.vatlin.xml;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.util.List;

public interface XMLReader<T> {
    List<T> getList() throws XMLStreamException, JAXBException;
}
