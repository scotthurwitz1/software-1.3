package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import main.Switcher;

public class AddPartFormController implements Initializable {
    
    Switcher switcher = new Switcher();

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
    private TextField priceTxt;

    @FXML
    private Button saveBtn;

    @FXML
    void onActionCancelPart(ActionEvent event) throws IOException {
        
        switcher.screen("/View/mainForm.fxml", event);
        
    }

    @FXML
    void onActionSavePart(ActionEvent event) {
        System.out.println("Part Saved");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

 
    }

}
