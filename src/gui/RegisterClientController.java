package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Client;
import javafx.event.ActionEvent;

public class RegisterClientController implements Initializable {
	
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
    	
    	Client client = new Client(firstName, lastName, addressStreet, clientTel, clientTel,
    			cpfNumber);
    }
    
    @FXML
    private void onSelectMostThreeNum(ActionEvent event) {

    }

}
