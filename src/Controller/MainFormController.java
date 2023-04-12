package Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Part;
import Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.Methods;
import static main.Methods.selectPart;
import main.Switcher;

public class MainFormController implements Initializable {
    
    Switcher switcher = new Switcher();
    
    @FXML
    private Button exitBtn;

    @FXML
    private Button partAddBtn;

    @FXML
    private TableColumn<Part, Float> partCostCol;

    @FXML
    private Button partDelBtn;

    @FXML
    private TableColumn<Part, Integer> partIdCol;

    @FXML
    private TableColumn<Part, Integer> partInvCol;

    @FXML
    private Button partModBtn;

    @FXML
    private TableColumn<Part, String> partNameCol;

    @FXML
    private TextField partSearchTxt;

    @FXML
    private TableView<Part> partsTbl;

    @FXML
    private Button prodAddBtn;

    @FXML
    private Button prodDelBtn;

    @FXML
    private TableColumn<Product, Integer> prodIdCol;

    @FXML
    private TableColumn<Product, Integer> prodInvCol;

    @FXML
    private Button prodModBtn;

    @FXML
    private TableColumn<Product, String> prodNameCol;

    @FXML
    private TableColumn<Product, Float> prodPriceCol;

    @FXML
    private TableView<Product> prodTbl;

    @FXML
    private TextField searchProdTxt;

    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {
        
        switcher.screen("/View/addPartForm.fxml", event);
        
    }

    @FXML
    void onActionAddProduct(ActionEvent event) throws IOException {
        
        switcher.screen("/View/addProductForm.fxml", event);
        
    }

    @FXML
    void onActionDeletePart(ActionEvent event) {

    }

    @FXML
    void onActionDeleteProduct(ActionEvent event) {

    }

    @FXML
    void onActionExit(ActionEvent event) {
        
        System.exit(0);

    }

    @FXML
    void onActionModifyPart(ActionEvent event) throws IOException {
        
        switcher.screen("/View/modifyPartForm.fxml", event);
        
    }

    @FXML
    void onActionModifyProduct(ActionEvent event) throws IOException {
        
        switcher.screen("/View/modifyProductForm.fxml", event);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        // Parts Table Methods
//        partsTbl.setItems(Inventory.getAllParts());

        partsTbl.setItems(Methods.filter("p"));
                 
        partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partCostCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        partInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        // Products Table Methods
        prodTbl.setItems(Inventory.getAllProducts());
        prodIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        prodPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        prodInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        prodNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
//        if (search(6))
//            System.out.println("Match");
//        else
//            System.out.println("No Match");
        
//        if(update(1, new InHouse(2, "twigs", 20.5, 1, 109, 200, 14)))
//            System.out.println("Update Successful");
//        else
//            System.out.println("update failed");
//
//    if(Methods.delete(0))
//        System.out.println("deleted");
//    else
//        System.out.println("no match");
//    
//    partsTbl.getSelectionModel().select(Methods.selectPart(0));
  

    }
}

    
