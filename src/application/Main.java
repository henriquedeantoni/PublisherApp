package application;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import gui.util.CombAndConsts;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Scene mainScene;
			
	@Override
	public void start(Stage primaryStage) {
		try {		
	    	//URL fxmlUrl = getClass().getResource("/gui/AnalysisChart.fxml");
	    	//System.out.println("FXML URL = " + fxmlUrl);
	    	
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			AnchorPane anchorPane = loader.load();
			
			mainScene = new Scene(anchorPane);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Sample JavaFX application");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Scene getMainScene() {
		return mainScene;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
