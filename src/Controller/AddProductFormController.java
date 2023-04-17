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
        boolean outsourced;
        String machineId1 = null;
        String companyName1 = null;
        
        if(part instanceof InHouse)
        {
            machineId1 = String.valueOf(((InHouse) part).getMachineId());
            outsourced = false;
            
        }
        else
        {
            companyName1 = String.valueOf(((Outsourced) part).getCompanyName());
            outsourced = true;
            
        }

        int id = Integer.parseInt((String.valueOf(part.getId())));
        String name = part.getName();
        int inv = Integer.parseInt(String.valueOf(part.getStock()));
        float price = Float.parseFloat(String.valueOf(part.getPrice()));
        int max = Integer.parseInt(String.valueOf(part.getMax()));
        int min = Integer.parseInt(String.valueOf(part.getMin())); 
            
        if (outsourced = false){
            int machineId = Integer.parseInt(machineId1);
            associatedParts1.add(new InHouse(id, name, price, inv, min, max, machineId));
        }
        else {
            String companyName = companyName1;
            associatedParts1.add(new Outsourced(id, name, price, inv, min, max, companyName));
        }
        
    }

    @FXML
    void onActionCancel(ActionEvent event) {

    }

    @FXML
    void onActionCancelToMain(ActionEvent event) throws IOException {
        
        switcher.screen("/View/mainForm.fxml", event);

    }

    @FXML
    void onActionRemovePart(ActionEvent event) {

    }

    @FXML
    void onActionSave(ActionEvent event) throws IOException {
        // Parse fields on form
        prodId += 1;
        int id = prodId;
        String name = nameTxt.getText();
        int inv = Integer.parseInt(invTxt.getText());
        float price = Float.parseFloat(priceTxt.getText());
        int max = Integer.parseInt(maxTxt.getText());
        int min = Integer.parseInt(minTxt.getText());
        ObservableList<Part> parts = associatedParts1;

        Inventory.addProduct(new Product(id, name, price, inv, min, max, parts));

        switcher.screen("/View/mainForm.fxml", event);
  
    }

    @FXML
    void onActionSaveToMain(ActionEvent event) {

    }
    
    public void sendProd(Product prod)
    {
        idTxt.setText(String.valueOf(prod.getId()));
        nameTxt.setText(prod.getName());
        invTxt.setText(String.valueOf(prod.getStock()));
        priceTxt.setText(String.valueOf(prod.getPrice()));
        maxTxt.setText(String.valueOf(prod.getMax()));
        minTxt.setText(String.valueOf(prod.getMin()));     
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
