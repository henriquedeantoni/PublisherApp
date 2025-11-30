package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Client;
import services.ClientService;
import javafx.event.ActionEvent;

public class RegisterClientController implements Initializable {
	
	private ClientService clientService = new ClientService();
	
    @FXML 
    private Button registerClientButton;
    
    @FXML 
    private TextField firstNameTextField;
    
    @FXML 
    private TextField lastNameTextField;
    
    @FXML 
    private TextField clientTelTextField;
    
    @FXML 
    private TextField addressStreetTextField;
    
    @FXML 
    private TextField cityTextField;

    @FXML 
    private TextField numberAddressTextField;
    
    @FXML 
    private TextField cpfTextField;
    
    @FXML
    private Button backButton;
        
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

    @FXML
    private void onRegisterClientButton(ActionEvent event) {
    	String firstName = firstNameTextField.getText();
    	String lastName = lastNameTextField.getText();
    	String clientTel = clientTelTextField.getText();
    	String addressStreet = addressStreetTextField.getText();
    	String cityText = cityTextField.getText();
    	String numberAddress = numberAddressTextField.getText();
    	String cpfNumber = cpfTextField.getText();
    	    	
    	Client client = new Client(firstName, lastName, addressStreet, clientTel, cpfNumber,
    			"");
    	
    	boolean success = clientService.sendClientData(client);
    	
    	if(success) showAlert("Sucesso!", "Client enviado com sucesso", Alert.AlertType.INFORMATION);
    	else showAlert("Erro", "Falha no envio das informações, contate o administrador", Alert.AlertType.INFORMATION);
    }
    
    private void showAlert(String title, String message, Alert.AlertType type) {
    	Alert alert = new Alert(type);
    	alert.setTitle(message);
    	alert.setContentText(message);
    	alert.show();
    }
    
    @FXML
    private void onBackButton(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	
    	stage.setScene(new Scene(root));
    	stage.show();
    }
}
