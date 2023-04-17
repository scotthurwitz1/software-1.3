/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Part;
import Model.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author scottsmac
 */
public class Main extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        
        
        // sample data
        // InHouse(int id, String name, double price, int stock, int min, int max, int machineID)
        InHouse part1 = new InHouse(0, "plastic", 10.5, 0, 10, 100, 13);
        InHouse part2 = new InHouse(1, "nail", 115.5, 0, 11, 110, 13);
        InHouse part3 = new InHouse(2, "metal", 20.5, 1, 109, 200, 14);
        Outsourced part4 = new Outsourced(2, "metal", 20.5, 1, 109, 200, "sacks");
        //outsourced 
        
        // sample product data
        Product prod1 = new Product(0, "toy", 10.5, 0, 10, 100);
        Product prod2 = new Product(1, "food", 10.5, 0, 10, 100);
        Product prod3 = new Product(2, "straw", 10.5, 0, 10, 100);
        
        Inventory.addPart(part1);
        Inventory.addPart(part2);
        Inventory.addPart(part4);
        
        Inventory.addProduct(prod1);
        Inventory.addProduct(prod2);
        Inventory.addProduct(prod3);
        
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/mainForm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("My Java FX Menu");
        stage.show();
    }
    
}
