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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static main.Methods.selectProd;
import static main.Methods.update;
import main.Switcher;

public class ModifyProductFormController implements Initializable {
    
    Switcher switcher = new Switcher();
    private ObservableList<Part> associatedParts3 = FXCollections.observableArrayList();

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
    private TextField idTxt;

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
    void onActionSearchTxt (ActionEvent event)
    {
        
    }

    @FXML
    void onActionAddPart(ActionEvent event) {
        
        Part part = partListTbl.getSelectionModel().getSelectedItem();
        boolean outsourced;
        int machineId = 0;
        String companyName = null;
        
        if(part instanceof InHouse)
        {
            machineId = ((InHouse) part).getMachineId();
            outsourced = false;
            
        }
        else
        {
            companyName = ((Outsourced) part).getCompanyName();
            outsourced = true;
            
        }

        int id = part.getId();
        String name = part.getName();
        int inv = part.getStock();
        double price = part.getPrice();
        int max = part.getMax();
        int min = part.getMin(); 
            
        if (outsourced = false){
            associatedParts3.add(new InHouse(id, name, price, inv, min, max, machineId));
            System.out.println("added");
            System.out.println(associatedParts3);
        }
        else {
            associatedParts3.add(new Outsourced(id, name, price, inv, min, max, companyName));
            System.out.println("added");
            System.out.println(associatedParts3);
        }
        

    }

    @FXML
    void onActionCancelMod(ActionEvent event) {

    }

    @FXML
    void onActionCancelToMain(ActionEvent event) throws IOException {
        
        switcher.screen("/View/mainForm.fxml", event);
        
    }

    @FXML
    void onActionRemovePart(ActionEvent event) {

    }

    @FXML
    void onActionSaveProduct(ActionEvent event) throws IOException {
        
        int id = Integer.parseInt(idTxt.getText());
        String name = nameTxt.getText();
        int inv = Integer.parseInt(invTxt.getText());
        float price = Float.parseFloat(priceTxt.getText());
        int max = Integer.parseInt(maxTxt.getText());
        int min = Integer.parseInt(minTxt.getText());
        
        Product prod1 = new Product(id, name, price, inv, min, max);
        
        for(Part part : associatedParts3)
            {
                prod1.addAssociatedPart(part);
            }
        
        update(id, prod1);
        
        System.out.println(selectProd(id).getAllAssociatedParts());
        
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
        
        for(Part part : prod.getAllAssociatedParts())
            {
                associatedParts3.add(part);
            }
        
        System.out.println(associatedParts3);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        if(!associatedParts3.isEmpty())
            associatedParts3.clear();
        
          //        Parts Table Methods
        partListTbl.setItems(Inventory.getAllParts());

//        partsTbl.setItems(Methods.filter("p"));
                 
        partListIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partListPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        partListInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partListNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        relPartTbl.setItems(associatedParts3);

//        partsTbl.setItems(Methods.filter("p"));
                 
        relPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        relPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        relPartInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        relPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

     
    }

}
