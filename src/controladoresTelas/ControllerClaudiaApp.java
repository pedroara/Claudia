package controladoresTelas;

import java.net.URL; 
import java.util.Calendar;
import java.util.ResourceBundle;
//import br.com.banco.model.domain.Cliente;
import gui.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import sistema.claudia.negocio.Evento;
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
    private Button RemoverBtn;
    
    @FXML
    private Button EditarBtn;
	
	@FXML
	private ListView<Evento> listViewDomingo; 
    
	@FXML
	private ListView<Evento> listViewQuarta;

	@FXML
	private ListView<Evento> listViewQuinta;

	@FXML
	private ListView<Evento> listViewSabado;

	@FXML
	private ListView<Evento> listViewSegunda;

	@FXML
	private ListView<Evento> listViewSexta;

	@FXML
	private ListView<Evento> listViewTerca;

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

    @FXML
    private Label sabadoDia;
    
//    @FXML
//    private Label avisoRemover;
    
    
	public void initialize() {
			
		AdiconarBtn.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {Main.loadScene("/gui/addEvento.fxml", "Adicionar Evento");} } );
		EditarBtn.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {Main.loadScene("/gui/editEvento.fxml", "Editar Evento");} } );
		
		Calendar c = Calendar.getInstance();
		
		c.setWeekDate(c.get(Calendar.YEAR), c.get(Calendar.WEEK_OF_YEAR), 1);
		domingoDia.setText("" + c.get(Calendar.DAY_OF_MONTH));
		c.add(Calendar.DAY_OF_MONTH, 1);
		segundaDia.setText("" + c.get(Calendar.DAY_OF_MONTH));
		c.add(Calendar.DAY_OF_MONTH, 1);
		tercaDia.setText(""+ c.get(Calendar.DAY_OF_MONTH));
		c.add(Calendar.DAY_OF_MONTH, 1);
		quartaDia.setText("" + c.get(Calendar.DAY_OF_MONTH));
		c.add(Calendar.DAY_OF_MONTH, 1);
		quintaDia.setText("" + c.get(Calendar.DAY_OF_MONTH));
		c.add(Calendar.DAY_OF_MONTH, 1);
		sextaDia.setText("" + c.get(Calendar.DAY_OF_MONTH));
		c.add(Calendar.DAY_OF_MONTH, 1);
		sabadoDia.setText("" + c.get(Calendar.DAY_OF_MONTH));
		
		
		ObservableList<Evento> dataDom = FXCollections.observableArrayList(fachadaClaudia.getListDomingo());
		ObservableList<Evento> dataSeg = FXCollections.observableArrayList(fachadaClaudia.getListSegunda());
		ObservableList<Evento> dataTer = FXCollections.observableArrayList(fachadaClaudia.getListTerca());
		ObservableList<Evento> dataQua = FXCollections.observableArrayList(fachadaClaudia.getListQuarta());
		ObservableList<Evento> dataQui = FXCollections.observableArrayList(fachadaClaudia.getListQuinta());
		ObservableList<Evento> dataSex = FXCollections.observableArrayList(fachadaClaudia.getListSexta());
		ObservableList<Evento> dataSab = FXCollections.observableArrayList(fachadaClaudia.getListSabado());
		
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
	
//	@FXML
//	public void remover() {
//		Evento e;
//		e.setNome(listViewDomingo.getSelectionModel().getSelectedItem());
//		
//        if (e != null) {
//            fachadaClaudia.remover(e);
//            //limpar campor do removido
//            //atualizar listView
//        } else {
//            avisoRemover.setText("Selecione um evento para remover!");
//        }
//    }	
	
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


