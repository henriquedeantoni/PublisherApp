package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import services.ClientService;
import javafx.event.ActionEvent;

public class FindClientController implements Initializable {
	
    @FXML 
    private Button searchButton;
    
    @FXML 
    private Button editClientRedirectionButton;
    
    @FXML
    private TextField termSearchTextField;
    
    @FXML 
    private TextField firstNameTextField;
    
    @FXML 
    private TextField lastNameTextField;
    
    @FXML 
    private TextField telTextField;
    
    @FXML 
    private TextField addressTextField;
    
    @FXML 
    private TextField streetNameTextField;
    
    @FXML 
    private TextField cityTextField;
    
    @FXML 
    private TextField genderTextField;
    
    @FXML 
    private TextField cpfNumberTextField;

    @FXML
    private TableView clientListTableView;
    
    @FXML
    private RadioButton firstNameRadioButton;
    
    @FXML
    private RadioButton lastNameRadioButton;
    
    @FXML
    private RadioButton telRadioButton;
    
    @FXML
    private RadioButton cityRadioButton;
    
        
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

    @FXML
    private void onSearchButton(ActionEvent event) {
    	final ClientService clientService = new ClientService();
    	
    	try {
    		
    		if(termSearchTextField.getText() == "" || termSearchTextField.getText() == null)
    		{
    			clientService.findAllClients();
    		} else {
    			
    		}
    		
    	} catch(Exception ex) {
    		
    	}
    }
    
    @FXML
    private void onEditClientRedirectionButton(ActionEvent event) {
    	
    	
    }
    
    private void showAlert(String title, String message, Alert.AlertType type) {
    	Alert alert = new Alert(type);
    	alert.setTitle(message);
    	alert.setContentText(message);
    	alert.show();
    }
    
    /*
    @FXML
    private void onBackButton(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	
    	stage.setScene(new Scene(root));
    	stage.show();
    }*/
}
