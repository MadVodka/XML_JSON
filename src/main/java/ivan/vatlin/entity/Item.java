package ivan.vatlin.entity;

import java.time.LocalDate;

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

    public Item setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Item setModel(String model) {
        this.model = model;
        return this;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public Item setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Item setColor(String color) {
        this.color = color;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Item setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Item setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
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
