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
	private MenuItem findClientsMenu;

	@FXML
	private MenuItem registerClientMenu;

	@FXML
	private MenuItem editClientMenu;

	@FXML
	private MenuItem findProductsMenu;

	@FXML
	private MenuItem registerProductMenu;

	@FXML
	private MenuItem editProductMenu;

	@FXML
	private MenuItem findSuppliersMenu;

	@FXML
	private MenuItem registerSupplierMenu;

	@FXML
	private MenuItem editSupplierMenu;

	@FXML
	private MenuItem findPosts;

	@FXML
	private MenuItem registerPost;

	@FXML
	private MenuItem findSells;

	@FXML
	private MenuItem registerSell;
	
    @FXML
    private AnchorPane contentArea;
		
	@FXML
	public void onMenuItemRegisterClient() {
		loadViewMenuItem("/gui/RegisterClient.fxml", RegisterClientController.class);
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
	
	private void loadViewMenuItem(String fxmlPath, Class<?> controllerClass) {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));

	        loader.setControllerFactory(param -> {
	            if (param == controllerClass) {
	                try {
	                    return controllerClass.getDeclaredConstructor().newInstance();
	                } catch (Exception e) {
	                    throw new RuntimeException(e);
	                }
	            }
	            throw new IllegalArgumentException("Controller não esperado: " + param);
	        });

	        Parent newView = loader.load();

	        Object controller = loader.getController();
	        System.out.println("Controller carregado: " + controller.getClass().getSimpleName());

	        contentArea.getChildren().clear();
	        contentArea.getChildren().add(newView);

	        AnchorPane.setTopAnchor(newView, 0.0);
	        AnchorPane.setRightAnchor(newView, 0.0);
	        AnchorPane.setBottomAnchor(newView, 0.0);
	        AnchorPane.setLeftAnchor(newView, 0.0);

	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}

	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
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
	    	e.printStackTrace();
	        Alerts.showAlert("IO Exception", "Erro ao carregar a View" + e.getMessage(), e.getMessage(), AlertType.ERROR);
	    }
	
	}
}
