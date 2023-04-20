/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author scott
 */
public class Methods {
    
    private static ObservableList<Part> filteredParts = FXCollections.observableArrayList();
    private static ObservableList<Product> filteredProds = FXCollections.observableArrayList();

    /**
     *
     */
    public static int partId = 0;

    /**
     *
     */
    public static int prodId = 0;
        
    /**
     *
     * @param id to search
     * @return check
     */
    public static boolean searchParts(int id) {
     
        for(Part part : Inventory.getAllParts()){
            if(part.getId() == id)
                return true;
        }
        return false;
    }
    
    /**
     *
     * @param id to update
     * @param part to update
     * @return check
     */
    public static boolean update(int id, Part part){
        int index = -1;
        for(Part part1 : Inventory.getAllParts())
        {
            index++;
            if (part1.getId() == id)
            {
                Inventory.getAllParts().set(index, part);
                return true;
            }
        }
        return false;
    }
    
    /**
     *
     * @param id to update
     * @param prod to update
     * @return check
     */
    public static boolean update(int id, Product prod){
        int index = -1;
        for(Product prod1 : Inventory.getAllProducts())
        {
            index++;
            if (prod1.getId() == id)
            {
                Inventory.getAllProducts().set(index, prod);
                return true;
            }
        }
        return false;
    }
    
    /**
     *
     * @param id to delete
     * @return check
     */
    public static boolean deletePart(int id){
        
        for(Part part : Inventory.getAllParts()){
            if(part.getId()==id)
                return Inventory.getAllParts().remove(part);
        }
        return false;
    }
    
    /**
     *
     * @param id to delete
     * @return check
     */
    public static boolean deleteProduct(int id){
        
        for(Product prod : Inventory.getAllProducts()){
            if(prod.getId()==id)
                return Inventory.getAllProducts().remove(prod);
        }
        return false;
    }
    
    /**
     *
     * @param id to select
     * @return part
     */
    public static Part selectPart(int id)
    {
        for(Part part : Inventory.getAllParts())
        {
            if(part.getId() == id)
                return part;
        }
        
        return null;
    }
    
    /**
     *
     * @param id to select
     * @return product
     */
    public static Product selectProd(int id)
    {
        for(Product prod : Inventory.getAllProducts())
        {
            if(prod.getId() == id)
                return prod;
        }
        
        return null;
    }
    
    /**
     *
     * @return filtered parts
     */
    public static ObservableList<Part> getAllFilteredParts()
    {
        return filteredParts;
    }
    
    /**
     *
     * @return filtered products
     */
    public static ObservableList<Product> getAllFilteredProducts()
    {
        return filteredProds;
    }
    
    /**
     *
     * @param name to filter
     * @return filtered parts
     */
    public static ObservableList<Part> filterParts(String name)
    {   
        //deals with repeating info if run multiple times
        if(!filteredParts.isEmpty())
            filteredParts.clear();
        
        try
        {
           int id = Integer.parseInt(name);
           for(Part part : Inventory.getAllParts())
            {
                if(part.getId() == id)
                    filteredParts.add(part);
            }
            return filteredParts;
        }
        catch(NumberFormatException e)
        {
            for(Part part : Inventory.getAllParts())
            {
                if(part.getName().contains(name))
                    filteredParts.add(part);
            }

            return filteredParts;
        }
        
    }
    
    /**
     *
     * @param name to filter
     * @return filtered products
     */
    public static ObservableList<Product> filterProducts(String name)
    {   
        //deals with repeating info if run multiple times
        if(!filteredProds.isEmpty())
            filteredProds.clear();
        
        try
        {
           int id = Integer.parseInt(name);
           for(Product prod : Inventory.getAllProducts())
            {
                if(prod.getId() == id)
                    filteredProds.add(prod);
            }
            return filteredProds;
        }
        catch(NumberFormatException e)
        {
            for(Product prod : Inventory.getAllProducts())
            {
                if(prod.getName().contains(name))
                    filteredProds.add(prod);
            }

            return filteredProds;
        }
        
    }
        
}
