package Model;

import javafx.collections.ObservableList;

public class Product {
    // Declare Fields
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
    private static ObservableList<Part> associatedParts;

    // Declare Methods
    public Product(int id, String name, double price, int stock, int min, int max, ObservableList<Part> parts){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
        this.associatedParts = parts;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public static void addAssociatedPart(Part part){
        associatedParts.add(part);
    }
    
    
    public static boolean deleteAssociatedPart(Part selectedAssociatedPart){
        return false;
    }
    
    public static ObservableList<Part> getAllAssociatedParts(){
        return associatedParts;
    }
}
