package control;

import view.*;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application{
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage arg0) throws Exception {
		this.primaryStage = arg0;
		this.primaryStage.setTitle("Sistema de Retardos del ITC");
		
		initRootLayout();
		showTablasDocente();
	}
	
	public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            //System.out.println(this.getClass().getR);
            System.out.println(this.getClass().getResource("../view/VentanaRaiz.fxml"));
            
            loader.setLocation(this.getClass().getResource("../view/VentanaRaiz.fxml"));
            System.out.println(loader.getLocation().toString());
            
            
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void showTablasDocente() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/TablasDocente.fxml"));
            AnchorPane tablaDocente = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(tablaDocente);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
