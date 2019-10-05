package ivan.vatlin;

import ivan.vatlin.converter.JsonXmlConverter;
import ivan.vatlin.entity.Shop;
import ivan.vatlin.exceptions.XmlValidationException;
import ivan.vatlin.validators.XmlValidator;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

import static ivan.vatlin.xml.XmlDataHolder.PATH_TO_TEST_XML;
import static ivan.vatlin.xml.XmlDataHolder.PATH_TO_XSD;

public class JsonXmlApplication {
    public static void main(String[] args) {
        JsonXmlConverter jsonXmlConverter = new JsonXmlConverter();

        String element = "shop";
        Class<?> classOfElement = Shop.class;

        String jsonResult = null;

        try {
            jsonResult = jsonXmlConverter.convertXmlToJson(PATH_TO_TEST_XML, classOfElement, element);

            System.out.println("Conversion XML to JSON result:");
            System.out.println(jsonResult);
        } catch (JAXBException e) {
            System.out.println("Ошибка при создании объектов из XML файла");
        } catch (XMLStreamException e) {
            System.out.println("Ошибка при чтении файла " + PATH_TO_TEST_XML);
        }

        System.out.println();

        try {
            String xmlResult = jsonXmlConverter.convertJsonToXmlAsString(jsonResult, classOfElement);
            System.out.println("Conversion JSON to XML result:");
            System.out.println(xmlResult);

            if (xmlResult != null) {
                XmlValidator xmlValidator = new XmlValidator();
                if (xmlValidator.isXmlValid(PATH_TO_TEST_XML, PATH_TO_XSD)) {
                    System.out.println("Полученный xml соответствует xsd: " + PATH_TO_XSD);
                } else {
                    System.out.println("Полученный xml не соответствует xsd: " + PATH_TO_XSD);
                }
            }
        } catch (JAXBException e) {
            System.out.println("Ошибка при конвертации объектов в XML файл");
        } catch (IOException e) {
            System.out.println("Ошибка при выводе XML файла в консоль");
        } catch (XmlValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}
