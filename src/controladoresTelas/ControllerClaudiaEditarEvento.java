package controladoresTelas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import gui.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sistema.claudia.exceptions.DataIncoerenteException;
import sistema.claudia.negocio.Evento;
import sistema.claudia.negocio.FachadaClaudia;

public class ControllerClaudiaEditarEvento {
	
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
    private TextField nomeId;

    @FXML
    private TextField descricaoId;

    @FXML
    private DatePicker dataHoraInicioId;

    @FXML
    private DatePicker dataHoraFimId;
    
    @FXML
    private int horaInicio;
    
    @FXML
    private int minutoInicio;
    
    @FXML
    private int horaFim;
    
    @FXML
    private int minutoFim;

    @FXML
    private Label avisoDataFim;

    @FXML
    private DatePicker EscolhaDia;

    @FXML
    private ListView<Evento> EscolhaEvento;
    
    @FXML
    private Button editarEvento;
    
    @FXML
    private Button buscarId;
    
    @FXML
    private Label evSelecionado;
    
    @FXML
    public void selecionarEvento(MouseEvent arg0) throws DataIncoerenteException {
    	//Evento selecionado
        Evento selecionado = EscolhaEvento.getSelectionModel().getSelectedItem();
        //Texto pra avisar o usuário
        if (selecionado != null) {
        	evSelecionado.setText("Evento selecionado, edite-o!");
        }
        //Preenchendo os campos com o texto antigo
        nomeId.setText(selecionado.getNome());
        descricaoId.setText(selecionado.getDescricao());
        //Lógica para alteras as datas
        
        if(nomeId != null && dataHoraInicioId.getValue() != null && dataHoraFimId.getValue() != null) {
        	
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			 
			 if(dataHoraFimId.getValue().isAfter(dataHoraInicioId.getValue()) || dataHoraFimId.getValue() == dataHoraInicioId.getValue()) {
				 
				 LocalDateTime dataInicio = dataHoraInicioId.getValue().atTime(horaInicio, minutoInicio);
				 LocalDateTime dataFim = dataHoraFimId.getValue().atTime(horaFim, minutoFim);
				 
				 String inicioTxt = formatter.format(dataInicio);
				 String fimTxt = formatter.format(dataFim);
				 //Pra editar o evento e depois voltar automaticamente pra tela de inicio:
				 editarEvento.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) { fachadaClaudia.editarEvento(selecionado, nomeId.getText(), descricaoId.getText(), inicioTxt, fimTxt); Main.loadScene("/gui/homeClaudia.fxml", "Claudia");}} );
				 

			 } else {
				 dataHoraFimId = dataHoraInicioId;
				 avisoDataFim.setText("Data de fim incoerente; insira um dia válido");
				 throw new DataIncoerenteException(dataHoraFimId.getValue());
			 }
		 } else if(nomeId == null) {
			 evSelecionado.setText("Campo de nome vazio");
		 }                      
    }
    
    public void initialize() {
    	
    	AdicionarBtn.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {Main.loadScene("/gui/addEvento.fxml", "Adicionar Evento");} } );
    	EditarBtn.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {Main.loadScene("/gui/editEvento.fxml", "Editar Evento");} } );
    	ClaudiaBtn.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {Main.loadScene("/gui/homeClaudia.fxml", "Claudia");}} ); 
    	
    	//Aqui Mari
    	
    		
    		ObservableList<Evento> listaa = FXCollections.observableArrayList(fachadaClaudia.getCalendario().getEventos());
    		EscolhaEvento.setItems(listaa);
    	
    	
    }       		
}
