package Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Part;
import Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import static main.Methods.prodId;
import main.Switcher;

public class AddProductFormController implements Initializable {
    
    Switcher switcher = new Switcher();

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

        Inventory.addProduct(new Product(id, name, price, inv, min, max));

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
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
           idTxt.setDisable(true);
    }

}
