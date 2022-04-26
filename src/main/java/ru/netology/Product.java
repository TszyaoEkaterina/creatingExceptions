package ru.netology;

public class Product {
    private int id;
    private String productName;
    private int price;
    private String name;
    
    public Product(int id, String productName, int price, String name) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
}
