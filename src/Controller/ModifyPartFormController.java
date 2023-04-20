package Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Part;
import Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import static main.Methods.update;
import main.Switcher;

/**
 *
 * @author scott
 */
public class ModifyPartFormController implements Initializable {
    
    Switcher switcher = new Switcher();
    Stage stage;
    Parent scene;
    boolean outsourced = false;

    @FXML
    private Button cancelBtn;

    @FXML
    private RadioButton inHouseBtn;

    @FXML
    private TextField invTxt;
    
    @FXML
    private TextField idTxt;

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
    private TextField priceTxt;
    
    @FXML
    private Label machineIdLbl;

    @FXML
    private Button saveBtn;

    @FXML
    private ToggleGroup sourceTG;
    
    @FXML
    void onActionOutsourcedButton(ActionEvent event){
        
        machineIdLbl.setText("Company Name");
        outsourced = true;
        
    }
    
    @FXML
    void onActionInHouseButton (ActionEvent event){
        
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
            int id = Integer.parseInt(idTxt.getText());
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
                    InHouse part1 = new InHouse(id, name, price, inv, min, max, machineId);
                    update(id, part1);
                }
                else {
                    String companyName = machineIdTxt.getText();
                    Outsourced part1 = new Outsourced(id, name, price, inv, min, max, companyName);
                    update(id, part1);
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
     * @param part
     */
    public void sendPart(Part part)
    {
        if(part instanceof InHouse)
        {
            machineIdTxt.setText(String.valueOf(((InHouse) part).getMachineId()));
            inHouseBtn.setSelected(true);
        }
        else
        {
            machineIdLbl.setText("Company Name");
            machineIdTxt.setText(((Outsourced) part).getCompanyName());
            outsourcedBtn.setSelected(true);
        }

            idTxt.setText(String.valueOf(part.getId()));
            nameTxt.setText(part.getName());
            invTxt.setText(String.valueOf(part.getStock()));
            priceTxt.setText(String.valueOf(part.getPrice()));
            maxTxt.setText(String.valueOf(part.getMax()));
            minTxt.setText(String.valueOf(part.getMin()));     
    }
    
    /**
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

}
