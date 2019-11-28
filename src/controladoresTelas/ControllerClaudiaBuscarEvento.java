package controladoresTelas;

import java.util.ArrayList;

import gui.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sistema.claudia.negocio.Evento;
import sistema.claudia.negocio.FachadaClaudia;

public class ControllerClaudiaBuscarEvento {
	
	private final FachadaClaudia fachadaClaudia = FachadaClaudia.getInstance();
	
    @FXML
    private Button ClaudiaBtn;

    @FXML
    private Button PesquisarBtn;

    @FXML
    private Button AdiconarBtn;

    @FXML
    private TextField textBuscar;

    @FXML
    private Button BuscarBut;

    @FXML
    private ListView<Evento> listaDoBuscar;

    @FXML
    public void clicado()
    {
    	ArrayList<Evento> lista = fachadaClaudia.buscarPorNome(textBuscar.getText()) ;
    	ObservableList<Evento> list = FXCollections.observableArrayList(lista);
    	listaDoBuscar.setItems(list);
    	listaDoBuscar.refresh();
    }
    	
    	
    public void initialize() {
    	
    	
//    	BuscarBut.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {
//    	ArrayList<Evento> lista = new ArrayList<Evento>();
//    	Evento even = fachadaClaudia.buscarPorNome(textBuscar.getText()) ;
//    	lista.add(even);
//    	ObservableList<Evento> list = FXCollections.observableArrayList(lista);
//    	listaDoBuscar.refresh();listaDoBuscar.refresh();} } );
    	
    	ClaudiaBtn.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent event) {Main.loadScene("/gui/homeClaudia.fxml", "Claudia");}} );
    	AdiconarBtn.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {Main.loadScene("/gui/addEvento.fxml", "Adicionar Evento");} } );
    	
    }
    
    
    
    
    
}
