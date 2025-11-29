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
import javafx.event.ActionEvent;

public class RegisterClientController implements Initializable {
	
    @FXML 
    private Button registerClientButton;
    
    @FXML 
    private TextField completeNameTextField;
    
    @FXML 
    private TextField clientTelTextField;
    
    @FXML 
    private TextField addressStreetTelTextField;
    
    @FXML 
    private TextField cityTextField;

    @FXML 
    private TextField numberAddressTextField;
    
    @FXML 
    private TextField cpfTextField;
    
    
    public int[][] matrizOccurrenceThreeNumbers;
    
    public void setMatrizOccurrenceThreeNumbers(int[][] matrizOccurrenceThreeNumbers) {
    	this.matrizOccurrenceThreeNumbers = matrizOccurrenceThreeNumbers;
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
        
	}
    
    private void drawGrid(Set<Integer> sortedNumbers) {

    }
    
    private void readCSV(File file) {

    }
    
    private void selectFileCSV() {

    }
    
    private void redrawActualGrid() {
	
    }
    
    private void showLastGame() {

    }
    
    private void showNextGame() {

    }

    @FXML
    private void onSelectMostFourNum(ActionEvent event) {

    }
    
    @FXML
    private void onSelectMostThreeNum(ActionEvent event) {

    }

}
