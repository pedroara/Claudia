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
    private TextField horaInicio;
    
    @FXML
    private TextField minutoInicio;
    
    @FXML
    private TextField horaFim;
    
    @FXML
    private TextField minutoFim;

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
    public int getHora(TextField hora) throws DataIncoerenteException {
    	if(hora.getText().isEmpty()) { 
    		return 0;
    	}
    	if(0 <= Integer.parseInt(hora.getText()) && Integer.parseInt(hora.getText()) <= 23) {
    		 return Integer.parseInt(hora.getText());
    	 } else {
    		 avisoDataFim.setText("Insira um horário válido.");
    		 hora.clear();
    		 throw new DataIncoerenteException(dataHoraFimId.getValue());
    	 }
    }

    @FXML
    public int getMinuto(TextField minuto) throws DataIncoerenteException {
    	if(minuto.getText().isEmpty()) { 
    		return 0;
    	}
    	if(0 <= Integer.parseInt(minuto.getText()) && Integer.parseInt(minuto.getText()) <= 59) {
    		 return Integer.parseInt(minuto.getText());
    	 } else {
    		 avisoDataFim.setText("Insira um horário válido.");
    		 minuto.clear();
    		 throw new DataIncoerenteException(dataHoraFimId.getValue());
    	 }
    }
    
    @FXML
    public void selecionarEvento(MouseEvent arg0) throws DataIncoerenteException {
    	
    	//Evento selecionado
        Evento selecionado = EscolhaEvento.getSelectionModel().getSelectedItem();
        //Preenchendo os campos com o texto antigo
        nomeId.setText(selecionado.getNome());
        descricaoId.setText(selecionado.getDescricao());
        /*dataHoraInicioId.setValue(selecionado.getDataHoraInicio().toLocalDate());
        dataHoraFimId.setValue(selecionado.getDataHoraFim().toLocalDate());
        horaInicio.setText(Integer.toString(selecionado.getDataHoraInicio().getHour()));
        horaFim.setText(Integer.toString(selecionado.getDataHoraFim().getHour()));
        minutoInicio.setText(Integer.toString(selecionado.getDataHoraInicio().getMinute()));
        minutoFim.setText(Integer.toString(selecionado.getDataHoraFim().getMinute()));*/
        
        //Lógica para alteras as datas
        
        //Texto pra avisar o usuário
        if (selecionado != null) {
        	evSelecionado.setText("Evento selecionado, edite-o!");
        }      
        
        
    if(nomeId != null && dataHoraInicioId.getValue() != null && dataHoraFimId.getValue() != null) {
    	 avisoDataFim.setText(" ");
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");		 		 
		 LocalDateTime dataInicio = dataHoraInicioId.getValue().atTime(getHora(horaInicio), getMinuto(minutoInicio));
		 LocalDateTime dataFim = dataHoraFimId.getValue().atTime(getHora(horaFim), getMinuto(minutoFim));
		 if(dataFim.isAfter(dataInicio) || dataFim.equals(dataInicio)) {			 			 
			 String inicioTxt = formatter.format(dataInicio);
			 String fimTxt = formatter.format(dataFim);
			 
			 editarEvento.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) { fachadaClaudia.editarEvento(selecionado, nomeId.getText(), descricaoId.getText(), inicioTxt, fimTxt); evSelecionado.setText("Evento editado com sucesso!");}} );			 
		 } else {
			 avisoDataFim.setText("Datas incoerentes; insira um dia válido");
			 throw new DataIncoerenteException(dataHoraFimId.getValue());
		 }
	 }else if(nomeId == null) {
		 evSelecionado.setText("Campo de nome vazio");
	 }
    EscolhaEvento.refresh();
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
