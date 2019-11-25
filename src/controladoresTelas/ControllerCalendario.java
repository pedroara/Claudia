package controladoresTelas;



import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sistema.claudia.exceptions.EventoJaExistenteException;
import sistema.claudia.negocio.Evento;
import sistema.claudia.negocio.FachadaClaudia;
import java.util.ArrayList;


public class ControllerCalendario {

	
	private final FachadaClaudia fachadaClaudia = FachadaClaudia.getInstance();
	
	@FXML
	private ResourceBundle rb;
	
	@FXML
	private URL url;
	
	
	@FXML
	private ListView<String> listViewDomingo; 
    
	public void eventoClicado() {
		
	}
	
	public void initialize() {
		//EXEMPLO
//		ArrayList <Evento> eventoss = new ArrayList <Evento>(); 
//		
//		Evento evento = new Evento("Evento de teste lalala", "Descricao de teste", "29-11-2012 00:00", "30-11-2012 00:00");
//		
//		eventoss.add(evento);
//		
//		ArrayList<String> eventosString = new ArrayList<String>();
//		eventosString.add(evento.getNome());
		fachadaClaudia.CadastrarEvento("Teste porfavor pega", "porfavor plis pega", "24-11-2019 00:30", "24-11-2019 23:58");
		ObservableList<String> data = FXCollections.observableArrayList(fachadaClaudia.getListNomeEventoDoDia(LocalDateTime.of(2019, 12, 25, 00, 00)));
		
		listViewDomingo.setItems(data);
	}
}



//public class ControllerCalendario {
//
//    //FachadaClaudia fachada = FachadaClaudia.getInstance();
//	
//	@FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private MenuBar DomingoID;
//
//    @FXML
//    private TableColumn<Evento, String> DomingoId;
//    
//
//    @FXML
//    private TableView<Evento> tabela;
//
//    @FXML
//    private ListView<?> quiId;
//
//    @FXML
//    private ListView<?> sabId;
//
//    @FXML
//    private ListView<?> segID;
//
//    @FXML
//    private ListView<?> sexId;
//
//    @FXML
//    private ListView<?> terId;
//    
//    @FXML
//	public void inicializarTabela() {
//		
//    	
//    	ArrayList<Evento> lista = new ArrayList<Evento>();
//    	
//    	Evento ev1 = new Evento("Evento de teste lalala", "Descricao de teste", "29-11-2012 00:00", "30-11-2012 00:00");
//    	
//    	lista.add(ev1);
//    	
//		DomingoId.setCellValueFactory(new PropertyValueFactory<>("nome"));
//		tabela.setItems(FXCollections.observableArrayList(lista));
//		tabela.refresh();
//	}
//
//
//    @FXML
//    void initialize() {
//    	
//
//        assert DomingoID != null : "fx:id=\"DomingoID\" was not injected: check your FXML file 'janela.fxml'.";
//        assert DomingoId != null : "fx:id=\"domingoId\" was not injected: check your FXML file 'janela.fxml'.";
//        assert tabela != null : "fx:id=\"quaId\" was not injected: check your FXML file 'janela.fxml'.";
//        assert quiId != null : "fx:id=\"quiId\" was not injected: check your FXML file 'janela.fxml'.";
//        assert sabId != null : "fx:id=\"sabId\" was not injected: check your FXML file 'janela.fxml'.";
//        assert segID != null : "fx:id=\"segID\" was not injected: check your FXML file 'janela.fxml'.";
//        assert sexId != null : "fx:id=\"sexId\" was not injected: check your FXML file 'janela.fxml'.";
//        assert terId != null : "fx:id=\"terId\" was not injected: check your FXML file 'janela.fxml'.";
//       // inicializarTabela();
//
//    }


//@FXML
//private ResourceBundle resources;
//
//@FXML
//private URL location;
//
//@FXML
//private MenuBar DomingoID;
//
//@FXML
//private TableColumn<Evento, String> DomingoId;
//
//@FXML
//private TableColumn<?, ?> QuartaId;
//
//@FXML
//private TableColumn<?, ?> QuintaId;
//
//@FXML
//private TableColumn<?, ?> SabadoId;
//
//@FXML
//private TableColumn<?, ?> SegundaId;
//
//@FXML
//private TableColumn<?, ?> SextaId;
//
//@FXML
//private TableColumn<?, ?> TerçaId;
//
//@FXML
//private TableView<Evento> tabela;
//
////FachadaClaudia fachada = FachadaClaudia.getInstance();
//
//
//@FXML
//void initialize() {
//    assert DomingoId != null : "fx:id=\"DomingoId\" was not injected: check your FXML file 'ClaudiaApp.fxml'.";
//    assert QuartaId != null : "fx:id=\"QuartaId\" was not injected: check your FXML file 'ClaudiaApp.fxml'.";
//    assert QuintaId != null : "fx:id=\"QuintaId\" was not injected: check your FXML file 'ClaudiaApp.fxml'.";
//    assert SabadoId != null : "fx:id=\"SabadoId\" was not injected: check your FXML file 'ClaudiaApp.fxml'.";
//    assert SegundaId != null : "fx:id=\"SegundaId\" was not injected: check your FXML file 'ClaudiaApp.fxml'.";
//    assert SextaId != null : "fx:id=\"SextaId\" was not injected: check your FXML file 'ClaudiaApp.fxml'.";
//    assert TerçaId != null : "fx:id=\"TerçaId\" was not injected: check your FXML file 'ClaudiaApp.fxml'.";
//    assert tabela != null : "fx:id=\"tabela\" was not injected: check your FXML file 'ClaudiaApp.fxml'.";
//    //inicializarTabela();
//
//}
//
//@FXML
//	public void inicializarTabela() {
//		
// 	
// 	ArrayList<Evento> lista = new ArrayList<Evento>();
//	
// 	Evento ev1 = new Evento("Evento de teste lalala", "Descricao de teste", "29-11-2012 00:00", "30-11-2012 00:00");
// 	
// 	lista.add(ev1);
// 	
//		DomingoId.setCellValueFactory(new PropertyValueFactory<>("nome"));
//		tabela.getItems().setAll(lista);
//		//tabela.setItems((ObservableList<Evento>)FXCollections.observableArrayList(lista));
//		tabela.refresh();
//	}


