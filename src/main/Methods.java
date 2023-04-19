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
 * @author scottsmac
 */
public class Methods {
    
    private static ObservableList<Part> filteredParts = FXCollections.observableArrayList();
    private static ObservableList<Product> filteredProds = FXCollections.observableArrayList();
    public static int partId = 0;
    public static int prodId = 0;
        
    public static boolean searchParts(int id) {
     
        for(Part part : Inventory.getAllParts()){
            if(part.getId() == id)
                return true;
        }
        return false;
    }
    
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
    
    public static boolean delete(int id){
        
        for(Part part : Inventory.getAllParts()){
            if(part.getId()==id)
                return Inventory.getAllParts().remove(part);
        }
        return false;
    }
    
    public static Part selectPart(int id)
    {
        for(Part part : Inventory.getAllParts())
        {
            if(part.getId() == id)
                return part;
        }
        
        return null;
    }
    
    public static Product selectProd(int id)
    {
        for(Product prod : Inventory.getAllProducts())
        {
            if(prod.getId() == id)
                return prod;
        }
        
        return null;
    }
    
    
    public static ObservableList<Part> getAllFilteredParts()
    {
        return filteredParts;
    }
    
    public static ObservableList<Product> getAllFilteredProducts()
    {
        return filteredProds;
    }
    
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
