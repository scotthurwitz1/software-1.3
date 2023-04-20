package Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Part;
import Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Methods;
import static main.Methods.getAllFilteredParts;
import static main.Methods.prodId;
import main.Switcher;

public class AddProductFormController implements Initializable {
    
    Switcher switcher = new Switcher();
    private static ObservableList<Part> associatedParts1 = FXCollections.observableArrayList();

    @FXML
    private Button addBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button cancelSceneBtn;

    @FXML
    private TextField invTxt;

    @FXML
    private TextField maxTxt;

    @FXML
    private TextField minTxt;

    @FXML
    private TextField nameTxt;
    
     @FXML
    private TextField idTxt;

    @FXML
    private TableColumn<Part, Integer> partListIdCol;

    @FXML
    private TableColumn<Part, Integer> partListInvCol;

    @FXML
    private TableColumn<Part, String> partListNameCol;

    @FXML
    private TableColumn<Part, Float> partListPriceCol;

    @FXML
    private TableView<Part> partListTbl;

    @FXML
    private TextField priceTxt;

    @FXML
    private TableColumn<Part, Integer> relPartIdCol;

    @FXML
    private TableColumn<Part, Integer> relPartInvCol;

    @FXML
    private TableColumn<Part, String> relPartNameCol;

    @FXML
    private TableColumn<Part, Float> relPartPriceCol;

    @FXML
    private TableView<Part> relPartTbl;

    @FXML
    private Button removeBtn;

    @FXML
    private Button saveBtn;

    @FXML
    private Button saveSceneBtn;

    @FXML
    private TextField searchTxt;

    @FXML
    void onActionAddPart(ActionEvent event) {
        
        Part part = partListTbl.getSelectionModel().getSelectedItem();
        associatedParts1.add(part);
        
    }

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        
        switcher.screen("/View/mainForm.fxml", event);

    }

    @FXML
    void onActionCancelToMain(ActionEvent event) throws IOException {
        
        switcher.screen("/View/mainForm.fxml", event);

    }

    @FXML
    void onActionRemovePart(ActionEvent event) {
        
        Part part = relPartTbl.getSelectionModel().getSelectedItem();
        associatedParts1.remove(part);

    }

    @FXML
    void onActionSave(ActionEvent event) throws IOException {
            
        try
        {
            prodId += 1;
            int id = prodId;
            String name = nameTxt.getText();
            int inv = Integer.parseInt(invTxt.getText());
            float price = Float.parseFloat(priceTxt.getText());
            int max = Integer.parseInt(maxTxt.getText());
            int min = Integer.parseInt(minTxt.getText());

            if (max <= min)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setContentText("Min value should be less than max.");
                alert.showAndWait();
            } 

            else if (inv < min || inv > max)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setContentText("Inv should be between min and max");
                alert.showAndWait();
            } 

            else {
                Product prod1 = new Product(id, name, price, inv, min, max);

                for(Part part : associatedParts1)
                    {
                        prod1.addAssociatedPart(part);
                    }

                Inventory.addProduct(prod1);

                switcher.screen("/View/mainForm.fxml", event);

            }
        }
        catch (NumberFormatException e)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setContentText("Number value expected");
            alert.showAndWait();
        }
    }

    @FXML
    void onActionSaveToMain(ActionEvent event) throws IOException {
        
        try
        {
            prodId += 1;
            int id = prodId;
            String name = nameTxt.getText();
            int inv = Integer.parseInt(invTxt.getText());
            float price = Float.parseFloat(priceTxt.getText());
            int max = Integer.parseInt(maxTxt.getText());
            int min = Integer.parseInt(minTxt.getText());


            if (max <= min)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setContentText("Min value should be less than max.");
                alert.showAndWait();
            } 

            else if (inv < min || inv > max)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setContentText("Inv should be between min and max");
                alert.showAndWait();
            } 

            else {
                Product prod1 = new Product(id, name, price, inv, min, max);

                for(Part part : associatedParts1)
                    {
                        prod1.addAssociatedPart(part);
                    }

                Inventory.addProduct(prod1);

                switcher.screen("/View/mainForm.fxml", event);

            }
        }
        catch (NumberFormatException e)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setContentText("Number value expected");
            alert.showAndWait();
        }

    }
    
    
    @FXML
    void onActionPartSearch(ActionEvent event) {
        partListTbl.setItems(Methods.filterParts(searchTxt.getText()));
        if (getAllFilteredParts().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setContentText("Part not found.");
            alert.showAndWait();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
           idTxt.setDisable(true);
           
           
           //        Parts Table Methods
        partListTbl.setItems(Inventory.getAllParts());

//        partsTbl.setItems(Methods.filter("p"));
                 
        partListIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partListPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        partListInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partListNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
           //        Associated Parts Table Methods
        relPartTbl.setItems(associatedParts1);

//        partsTbl.setItems(Methods.filter("p"));
                 
        relPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        relPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        relPartInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        relPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        
    }

}
