package controladoresTelas;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import gui.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import sistema.claudia.negocio.FachadaClaudia;




public class ControllerClaudiaApp {
	
	
	private final FachadaClaudia fachadaClaudia = FachadaClaudia.getInstance();
	
	@FXML
	private ResourceBundle rb;
	
	@FXML
	private URL url;
	
	@FXML
	private Button ClaudiaBtn;

    @FXML
    private Button PesquisarBtn;

    @FXML
    private Button AdiconarBtn;
	
	@FXML
	private ListView<String> listViewDomingo; 
    
	@FXML
	private ListView<String> listViewQuarta;

	@FXML
	private ListView<String> listViewQuinta;

	@FXML
	private ListView<String> listViewSabado;

	@FXML
	private ListView<String> listViewSegunda;

	@FXML
	private ListView<String> listViewSexta;

	@FXML
	private ListView<String> listViewTerca;

	@FXML
    private Button ClaudiaAdicionar;

    @FXML
    private Button ClaudiaHome;

    @FXML
    private Button ClaudiaPesquisar;

    @FXML
    private Label textoNaTela;

    @FXML
    private Label segundaDia;

    @FXML
    private Label domingoDia;

    @FXML
    private Label tercaDia;

    @FXML
    private Label quartaDia;

    @FXML
    private Label quintaDia;

    @FXML
    private Label sextaDia;
    
    
    
	public void initialize() {
			
//		ClaudiaAdicionar.setOnAction(new EventHandler<ActionEvent>() {
//				@Override
//				public void handle(ActionEvent event) 
//				{
//					Main.loadScene("/gui/ClaudiaAdicionarEvento.fxml", "Adicionar Evento");
//				}
//			} );
		
		segundaDia.setText(LocalDateTime.now().toString());
		
		ObservableList<String> dataDom = FXCollections.observableArrayList(fachadaClaudia.getListDomingo());
		ObservableList<String> dataSeg = FXCollections.observableArrayList(fachadaClaudia.getListSegunda());
		ObservableList<String> dataTer = FXCollections.observableArrayList(fachadaClaudia.getListTerca());
		ObservableList<String> dataQua = FXCollections.observableArrayList(fachadaClaudia.getListQuarta());
		ObservableList<String> dataQui = FXCollections.observableArrayList(fachadaClaudia.getListQuinta());
		ObservableList<String> dataSex = FXCollections.observableArrayList(fachadaClaudia.getListSexta());
		ObservableList<String> dataSab = FXCollections.observableArrayList(fachadaClaudia.getListSabado());
		
		if(listViewDomingo != null && listViewSegunda != null && listViewTerca != null && listViewQuarta != null && listViewQuinta != null && listViewSexta != null && listViewSabado != null) {
		listViewDomingo.setItems(dataDom);
		listViewSegunda.setItems(dataSeg);
		listViewTerca.setItems(dataTer);
		listViewQuarta.setItems(dataQua);
		listViewQuinta.setItems(dataQui);
		listViewSexta.setItems(dataSex);
		listViewSabado.setItems(dataSab);
		}
	}
	
//	 @FXML
//	 public void irAdicionarEvento() {
//	  Main.loadScene("/gui/ClaudiaAdicionarEvento.fxml", "Adicionar Evento");
//	 }
	
	
}

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


