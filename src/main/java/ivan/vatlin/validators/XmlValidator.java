package ivan.vatlin.validators;

import ivan.vatlin.exceptions.XmlValidationException;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {
    public boolean isXmlValid(String pathXml, String pathXsd) throws XmlValidationException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File xmlFile = new File(pathXml);
        File xsdFile = new File(pathXsd);
        Source sourceXsd = new StreamSource(xsdFile);
        Source sourceXml = new StreamSource(xmlFile);

        try {
            Schema schema = null;
            schema = schemaFactory.newSchema(sourceXsd);

            Validator validator = schema.newValidator();
            validator.validate(sourceXml);
            return true;
        } catch (SAXException e) {
            return false;
        } catch (IOException e) {
            throw new XmlValidationException("Ошибка во время валидации xml");
        }
    }
}
