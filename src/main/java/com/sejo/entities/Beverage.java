package com.sejo.entities;


import javax.persistence.*;

@Entity
@Table(name = "beverages")
public class Beverage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "buyingPrice")
    private double buyingPrice;

    @Column(name = "sellingPrice")
    private double sellingPrice;

    @Column(name = "quantity")
    private int quantity;

    public Beverage() {
    }

    public Beverage(String name, double buyingPrice, double sellingPrice, int quantity) {
        this.name = name;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Buying Price=" + buyingPrice +
                ", Selling Price=" + sellingPrice +
                ", Quantity=" + quantity +
                '}';
    }
}
