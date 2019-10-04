package ivan.vatlin.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    @XmlElement(name = "category")
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
