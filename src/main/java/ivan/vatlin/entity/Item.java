package ivan.vatlin.entity;

import ivan.vatlin.adapters.LocalDateAdapter;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlType(name = "item")
public class Item {
    private String company;
    private String model;
    private LocalDate productionDate;
    private String color;
    private double price;
    private int quantity;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", productionDate=" + productionDate +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!company.equals(item.company)) return false;
        if (!model.equals(item.model)) return false;
        if (!productionDate.equals(item.productionDate)) return false;
        return color.equals(item.color);
    }

    @Override
    public int hashCode() {
        int result = company.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + productionDate.hashCode();
        result = 31 * result + color.hashCode();
        return result;
    }
}
