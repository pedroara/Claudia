package controladoresTelas;

import gui.Main; 
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import sistema.claudia.negocio.Evento;
import sistema.claudia.negocio.FachadaClaudia;

public class ControllerClaudiaRemoverEventos {
	
		private final FachadaClaudia fachadaClaudia = FachadaClaudia.getInstance();
	
		@FXML
	    private Button ClaudiaBtn;

	    @FXML
	    private Button PesquisarBtn;

	    @FXML
	    private Button AdicionarBtn;

	    @FXML
	    private Button EditarBtn;

	    @FXML
	    private ListView<Evento> EscolhaEvento;

	    @FXML
	    private Label evSelecionado;

	    @FXML
	    private Button removerBtn;
	    
	    @FXML
	    void selecionarEvento(MouseEvent event) {
	    	 Evento selecionado = EscolhaEvento.getSelectionModel().getSelectedItem();
	    	 
	    	 if(EscolhaEvento.getSelectionModel().getSelectedItem() != null) {
	    		 evSelecionado.setText("Você tem certeza que deseja excluir o evento selecionado?");
	    	 }
	    	 
	    	 removerBtn.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {  fachadaClaudia.remover(selecionado);  fachadaClaudia.getCalendario().salvarArquivo();  evSelecionado.setText("Evento removido!");} } );
	    	
	    }

	    
	    public void initialize() {
	    	
	    	ClaudiaBtn.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {Main.loadScene("/gui/homeClaudia.fxml", "Claudia");}} );
	    	PesquisarBtn.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {Main.loadScene("/gui/findEvento.fxml", "Pesquisar Evento");} } );
	    	AdicionarBtn.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {Main.loadScene("/gui/addEvento.fxml", "Adicionar Evento");} } );
	    	EditarBtn.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {Main.loadScene("/gui/editEvento.fxml", "Editar Evento");} } );
	    	 
	    	
	    	ObservableList<Evento> listaa = FXCollections.observableArrayList(fachadaClaudia.getCalendario().getEventos());
	    	EscolhaEvento.setItems(listaa);	    		    	
	    }       		
	
	
	
	

}
