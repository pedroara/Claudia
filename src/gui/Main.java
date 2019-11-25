package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	

	public static Stage  primaryStage;
	public static Class thisClass;

	 public Main() {
		  thisClass = getClass();
		 }
	
	 @Override
	public void start(Stage primaryStage) {
		
		Main.primaryStage = primaryStage;

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/gui/ClaudiaApp.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Claudia");
			
			primaryStage.getIcons().add(new Image("file:details/calendar.png"));
			
			primaryStage.show();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public static void loadScene(String nameFile, String titlePage) {

		  Parent root;
		  try {
		   root = FXMLLoader.load(thisClass.getClass().getResource(nameFile));
		   Scene scene = new Scene(root);
			   primaryStage.setTitle(titlePage);
			   primaryStage.setScene(scene);
			   primaryStage.show();		   
		  } catch (IOException e) {
		   e.printStackTrace();
		  }

		 }
}
