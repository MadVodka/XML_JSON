package ivan.vatlin;

import ivan.vatlin.entity.Category;
import ivan.vatlin.xml.XmlToDtoConverter;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.util.List;

import static ivan.vatlin.xml.XmlDataHolder.CATEGORY;
import static ivan.vatlin.xml.XmlDataHolder.PATH_TO_TEST_XML;

public class Application {

    public static void main(String[] args) {
        try {
            XmlToDtoConverter<Category> xmlToDtoConverter = new XmlToDtoConverter<>(PATH_TO_TEST_XML,
                    Category.class, CATEGORY);
            List<Category> categories = xmlToDtoConverter.getList();
            if (categories != null) {
                categories.forEach(Application::printCategory);
            } else {
                System.out.println("Элементов " + CATEGORY + " не найдено");
            }

            String attribute = "name";
            String attributeValue = "Games";
            Category category = xmlToDtoConverter.getElementWithAttribute(attribute, attributeValue);
            if (category != null) {

                printCategory(category);
            } else {
                System.out.println("Элемент " + CATEGORY + " с атрибутом "
                        + attribute + "  и значением " + attributeValue + " не найден");
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
            System.out.println("Ошибка при чтении файла " + PATH_TO_TEST_XML);
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("Ошибка при создании объектов из XML файла");
        }
    }

    public static void printCategory(Category category) {
        System.out.println("Category: " + category.getName());

        category.getSubCategories().forEach(subCategory -> {
            System.out.println("Subcategory: " + subCategory.getName());
            System.out.println(subCategory.getItems());
        });

        System.out.println();
    }
}
