package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author scott
 */
public class Product {
    // Declare Fields
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    // Declare Methods

    /**
     *
     * @param id
     * @param name
     * @param price
     * @param stock
     * @param min
     * @param max
     */
    public Product(int id, String name, double price, int stock, int min, int max){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /**
     *
     * @param id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @param stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     *
     * @param min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     *
     * @param max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @returnm the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     *
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     *
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     *
     * @param part the part
     */
    public void addAssociatedPart(Part part){
        associatedParts.add(part);
    }
    
    /**
     *
     * @param selectedAssociatedPart to delete
     * @return operation check
     */
    public boolean deleteAssociatedPart(Part selectedAssociatedPart){
        associatedParts.remove(selectedAssociatedPart);
        if (!associatedParts.contains(selectedAssociatedPart))
            return true;
        else 
            return false;
    }
    
    /**
     *
     * @return the parts
     */
    public ObservableList<Part> getAllAssociatedParts(){
        return associatedParts;
    }
}
