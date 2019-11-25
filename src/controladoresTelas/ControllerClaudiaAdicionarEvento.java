package controladoresTelas;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import sistema.claudia.negocio.FachadaClaudia;


public class ControllerClaudiaAdicionarEvento {
	
	private final FachadaClaudia fachadaClaudia = FachadaClaudia.getInstance();
	
	@FXML
	private ResourceBundle rb;
	
	@FXML
	private URL url;

    @FXML
    private Button ClaudiaAdicionar;

    @FXML
    private Button ClaudiaHome;

    @FXML
    private Button ClaudiaPesquisar;
    

	 @FXML
	 public void  initialize() {
		 ClaudiaHome.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {Main.loadScene("/gui/ClaudiaApp.fxml", "Claudia");}} );
		 
		
		 
	 }
	 
	 

	
//	 @FXML
//	  public void homeClaudia() {
//	  Main.loadScene("/gui/ClaudiaApp.fxml", "Claudia");
//	 }
	
}
