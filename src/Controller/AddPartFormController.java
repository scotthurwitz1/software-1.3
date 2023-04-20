package Controller;

import Model.InHouse;
import Model.Inventory;
import static Model.Inventory.getAllParts;
import Model.Outsourced;
import Model.Part;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import static main.Methods.getAllFilteredParts;
import static main.Methods.partId;
import main.Switcher;

/**
 *
 * @author scott
 */
public class AddPartFormController implements Initializable {
    
    Switcher switcher = new Switcher();
    boolean outsourced = false;

    @FXML
    private Button cancelBtn;

    @FXML
    private RadioButton inHouseBtn;

    @FXML
    private TextField invTxt;

    @FXML
    private TextField machineIdTxt;

    @FXML
    private TextField maxTxt;

    @FXML
    private TextField minTxt;

    @FXML
    private TextField nameTxt;

    @FXML
    private RadioButton outsourcedBtn;
    
    @FXML
    private TextField idTxt;

    @FXML
    private TextField priceTxt;

    @FXML
    private Button saveBtn;
    
    @FXML
    private Label machineIdLbl;
    
    // Handle In house / outsourced button menue changes
    @FXML
    void onActionOutsourcedButton(ActionEvent event){
        
        machineIdLbl.setText("Company Name");
        outsourced = true;
        
    }
    
    @FXML
    void onActionInHouseBtn (ActionEvent event){
        
        machineIdLbl.setText("Machine ID");
        outsourced = false;
        
    }

    @FXML
    void onActionCancelPart(ActionEvent event) throws IOException {
        
        switcher.screen("/View/mainForm.fxml", event);
        
        
    }

    @FXML
    void onActionSavePart(ActionEvent event) throws IOException {
        
        try
        {
            // Parse fields on form
            partId += 1;
            int id = partId;
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
                if (outsourced = false){
                    int machineId = Integer.parseInt(machineIdTxt.getText());
                    Inventory.addPart(new InHouse(id, name, price, inv, min, max, machineId));
                }
                else {
                    String companyName = machineIdTxt.getText();
                    Inventory.addPart(new Outsourced(id, name, price, inv, min, max, companyName));
                }

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
    
    /**
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idTxt.setDisable(true);
    }

}
