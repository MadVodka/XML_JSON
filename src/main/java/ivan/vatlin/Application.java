package ivan.vatlin;

import ivan.vatlin.entity.Category;
import ivan.vatlin.xml.XMLReader;
import ivan.vatlin.xml.XMLToDtoReader;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        XMLReader<Category> itemXMLReader;
        try {
            itemXMLReader = new XMLToDtoReader();
            List<Category> list = itemXMLReader.getList();
            System.out.println(list);
        } catch (XMLStreamException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
