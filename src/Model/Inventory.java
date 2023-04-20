package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author scott
 */
public class Inventory {
    // Declare Fields
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    // Declare Methods

    /**
     *
     * @param newPart the part to add
     */
    public static void addPart(Part newPart) {
    
        allParts.add(newPart);
    
    }

    /**
     *
     * @param newProduct the product to add
     */
    public static void addProduct(Product newProduct){
    
        allProducts.add(newProduct);
        
    }

    /**
     *
     * @param partId the id to get
     * @return that part
     */
    public static Part lookupPart(int partId){
        for(Part part : Inventory.getAllParts()){
            if(part.getId() == partId)
                return part;
        }
        return null;
    }

    /**
     *
     * @param productId the id to get
     * @return that product
     */
    public static Product lookupProduct(int productId){
        for(Product prod : Inventory.getAllProducts())
        {
            if(prod.getId() == productId)
                return prod;
        }  
        return null;
    }

    /**
     *
     * @param partName the name to get
     * @return that part
     */
    public static Part lookupPart(String partName){
        for(Part part : Inventory.getAllParts()){
            if(part.getName().equals(partName))
                return part;
        }
        return null;
    }

    /**
     *
     * @param productName the name to get
     * @return that product
     */
    public static Product lookupProduct(String productName){
        for(Product prod : Inventory.getAllProducts())
        {
            if(prod.getName() == productName)
                return prod;
        }
        return null;
    }

    /**
     *
     * @param index index of the part
     * @param selectedPart the new part
     */
    public static void updatePart(int index, Part selectedPart){
        int index1 = -1;
        for(Part part1 : Inventory.getAllParts())
        {
            index1++;
            if (part1.getId() == selectedPart.getId())
            {
                Inventory.getAllParts().set(index, selectedPart); 
            }
        }
    }

    /**
     *
     * @param index of the part
     * @param newProduct the new product
     */
    public static void updateProduct(int index, Product newProduct){
        int index2 = -1;
        for(Product prod1 : Inventory.getAllProducts())
        {
            index2++;
            if (prod1.getId() == newProduct.getId())
            {
                Inventory.getAllProducts().set(index, newProduct); 
            }
        }}
    
    /**
     *
     * @param selectedPart to delete
     * @return operation check
     */
    public static boolean deletePart(Part selectedPart){
        allParts.remove(selectedPart);
        return allParts.contains(selectedPart);
    }
    
    /**
     *
     * @param selectedProduct to delete
     * @return operation check
     */
    public static  boolean deleteProduct(Product selectedProduct){
        allProducts.remove(selectedProduct);
        return allProducts.contains(selectedProduct);
    }

    /**
     *
     * @return all parts
     */
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    /**
     *
     * @return all products
     */
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
}
