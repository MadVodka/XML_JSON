package ivan.vatlin.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "category")
public class Category {
    private String name;
    private List<SubCategory> subCategories;

    public String getName() {
        return name;
    }

    @XmlAttribute()
    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    @XmlElement(name = "subcategory")
    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", subCategories=" + subCategories +
                '}';
    }
}
