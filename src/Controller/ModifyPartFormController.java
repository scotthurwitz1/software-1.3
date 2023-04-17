package Controller;

import Model.InHouse;
import Model.Outsourced;
import Model.Part;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import main.Switcher;

public class ModifyPartFormController implements Initializable {
    
    Switcher switcher = new Switcher();
    Stage stage;
    Parent scene;

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
    void onActionCancelPart(ActionEvent event) throws IOException {

        switcher.screen("/View/mainForm.fxml", event);

    }

    @FXML
    void onActionSavePart(ActionEvent event) {
        
    }
    
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

}
