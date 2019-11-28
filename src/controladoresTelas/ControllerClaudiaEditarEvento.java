package controladoresTelas;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class ControllerClaudiaEditarEvento {

	@FXML
    private Button ClaudiaBtn;

    @FXML
    private Button PesquisarBtn;

    @FXML
    private Button AdicionarBtn;

    @FXML
    private Button EditarBtn;

    @FXML
    private TextField nomeId;

    @FXML
    private TextField descricaoId;

    @FXML
    private DatePicker dataHoraInicioId;

    @FXML
    private DatePicker dataHoraFimId;

    @FXML
    private Label avisoDataFim;

    @FXML
    private DatePicker EscolhaDia;

    @FXML
    private MenuButton EscolhaEvento;

    
    public void initialize() {
    	AdicionarBtn.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {Main.loadScene("/gui/addEvento.fxml", "Adicionar Evento");} } );
    	EditarBtn.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {Main.loadScene("/gui/editEvento.fxml", "Editar Evento");} } );
    	ClaudiaBtn.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {Main.loadScene("/gui/homeClaudia.fxml", "Claudia");}} ); 
    	
    
    	
    	
    	
    	
    	
    }       		
}
