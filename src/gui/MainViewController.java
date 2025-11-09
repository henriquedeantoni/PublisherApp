package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem menuItemFileNew;
	
	@FXML
	private MenuItem menuItemFileOpen;
	
	@FXML
	private MenuItem menuItemFileSave;
	
	@FXML
	private MenuItem menuItemAnalysisChart;

	@FXML
	private MenuItem menuItemAnalysisStatistics;

	@FXML
	private MenuItem menuGenerateFiles;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
	
	/*
	@FXML
	public void onMenuItemAnalysisChartAction() {
		loadViewChart("/gui/AnalysisChart.fxml", (AnalysisChartController controller) -> {
			
		});
	}
	
	@FXML
	public void onMenuItemGenerateFiles() {
		loadView("/gui/GenerateFiles.fxml", (GenerateFilesController controller) -> {
			
		});
	}*/
	
	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
	        Parent newRoot = loader.load();

	        Scene mainScene = Main.getMainScene();
	        
	        AnchorPane mainRoot = (AnchorPane) mainScene.getRoot();

	        mainRoot.getChildren().clear();
	        mainRoot.getChildren().add(newRoot);

	        AnchorPane.setTopAnchor(newRoot, 0.0);
	        AnchorPane.setRightAnchor(newRoot, 0.0);
	        AnchorPane.setBottomAnchor(newRoot, 0.0);
	        AnchorPane.setLeftAnchor(newRoot, 0.0);

	        T controller = loader.getController();
	        if (initializingAction != null) {
	            initializingAction.accept(controller);
	        }

	    } catch (IOException e) {
	        Alerts.showAlert("IO Exception", "Erro ao carregar view", e.getMessage(), AlertType.ERROR);
	    }
	}
	
	private synchronized <T> void loadViewChart(String absoluteName, Consumer<T> initializingAction) {
	    try {

	        FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
	        Parent chartRoot = loader.load();

	        Scene mainScene = Main.getMainScene();
	        AnchorPane mainRoot = (AnchorPane) mainScene.getRoot();

	        ScrollPane scrollPane = null;
	        for (Node node : mainRoot.getChildren()) {
	            if (node instanceof ScrollPane) {
	                scrollPane = (ScrollPane) node;
	                break;
	            }
	        }

	        if (scrollPane == null) {
	            Alerts.showAlert("Erro", "ScrollPane não encontrado", "O ScrollPane principal não foi localizado no MainView.", AlertType.ERROR);
	            return;
	        }

	        scrollPane.setContent(chartRoot);

	        T controller = loader.getController();
	        initializingAction.accept(controller);

	    } catch (IOException e) {
	        Alerts.showAlert("IO Exception", "Erro ao carregar a View" + e.getMessage(), e.getMessage(), AlertType.ERROR);
	    }
	}
}
