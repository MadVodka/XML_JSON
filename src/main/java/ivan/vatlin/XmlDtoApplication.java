package ivan.vatlin;

import ivan.vatlin.entity.Category;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.util.List;

import static ivan.vatlin.xml.XmlDataHolder.PATH_TO_TEST_XML;

public class XmlDtoApplication {

    public static void main(String[] args) {
        String element = "category";
        try {
            XmlToDtoConverter<Category> xmlToDtoConverter = new XmlToDtoConverter<>(PATH_TO_TEST_XML,
                    Category.class, element);
            List<Category> categories = xmlToDtoConverter.getList();
            if (categories != null) {
                categories.forEach(XmlDtoApplication::printCategory);
            } else {
                System.out.println("Элементов " + element + " не найдено");
            }

            String attribute = "name";
            String attributeValue = "Games";
            Category category = xmlToDtoConverter.getElementWithAttribute(attribute, attributeValue);
            if (category != null) {
                printCategory(category);
            } else {
                System.out.println("Элемент " + category + " с атрибутом "
                        + attribute + "  и значением " + attributeValue + " не найден");
            }
        } catch (XMLStreamException e) {
            System.out.println("Ошибка при чтении файла " + PATH_TO_TEST_XML);
        } catch (JAXBException e) {
            System.out.println("Ошибка при создании объектов из XML файла");
        }
    }

    private static void printCategory(Category category) {
        System.out.println("Category: " + category.getName());

        category.getSubCategories().forEach(subCategory -> {
            System.out.println("Subcategory: " + subCategory.getName());
            System.out.println(subCategory.getItems());
        });

        System.out.println();
    }
}
