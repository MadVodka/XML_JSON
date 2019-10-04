package ivan.vatlin.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "subcategory")
public class SubCategory {
    private String name;
    private List<Item> items;

    public String getName() {
        return name;
    }

    @XmlAttribute()
    public SubCategory setName(String name) {
        this.name = name;
        return this;
    }

    public List<Item> getItems() {
        return items;
    }

    @XmlElement(name = "item")
    public SubCategory setItems(List<Item> items) {
        this.items = items;
        return this;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
