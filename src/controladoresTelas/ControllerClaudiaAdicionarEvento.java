package controladoresTelas;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import javafx.scene.control.MenuItem;

import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import sistema.claudia.dados.Calendario;
import sistema.claudia.exceptions.DataIncoerenteException;
import sistema.claudia.exceptions.EventoJaExistenteException;
import sistema.claudia.negocio.Evento;
import sistema.claudia.negocio.FachadaClaudia;

public class ControllerClaudiaAdicionarEvento {
	
	private final FachadaClaudia fachadaClaudia = FachadaClaudia.getInstance();
	
	@FXML
	private ResourceBundle rb;
	
	@FXML
	private URL url;
	
	@FXML
	private TextField nomeId;

	@FXML
	private TextField descricaoId;
	
	@FXML
	private DatePicker dataHoraInicioId;

	@FXML
	private DatePicker dataHoraFimId;
	
    @FXML
    private Button ClaudiaBtn;

    @FXML
    private Button PesquisarBtn;

    @FXML
    private Button AdiconarBtn;
    
    @FXML
    private Label resultado;
    
    @FXML
    private Label avisoDataFim;
    
    @FXML
    private SplitMenuButton horaInicioId;
    
    @FXML
    private SplitMenuButton minutoInicioId;
    
    @FXML
    private SplitMenuButton horaFimId;
    
    @FXML
    private SplitMenuButton minutoFimId;
    
    @FXML
    private int horaInicio;
    
    @FXML
    private int minutoInicio;
    
    @FXML
    private int horaFim;
    
    @FXML
    private int minutoFim;
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    
    Calendario calendario = fachadaClaudia.getCalendario();

	 @FXML
	 public void  initialize() {
		 
		 //Calendario calendario = new Calendario();
		 ClaudiaBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {Main.loadScene("/gui/homeClaudia.fxml", "Claudia");}} );
		 
	 }
	 
	 
	 
	 @FXML
	 public void cadastrar() throws EventoJaExistenteException, DataIncoerenteException {
		 addHoraMinuto();
		 
		 if(nomeId != null && dataHoraInicioId.getValue() != null && dataHoraFimId.getValue() != null) {
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			 resultado.setText("");
			 avisoDataFim.setText("");
			 
			 if(dataHoraFimId.getValue().isAfter(dataHoraInicioId.getValue()) || dataHoraFimId.getValue() == dataHoraInicioId.getValue()) {
				 LocalDateTime dataInicio = dataHoraInicioId.getValue().atTime(horaInicio, minutoInicio);
				 LocalDateTime dataFim = dataHoraFimId.getValue().atTime(horaFim, minutoFim);
				 //LocalDateTime dataInicio = inicio.atTime(time);
				 
				 String inicioTxt = formatter.format(dataInicio);
				 String fimTxt = formatter.format(dataFim);
				 
				 Evento e = new Evento(nomeId.getText());
				 e.setDescricao(descricaoId.getText());
				 e.setDataHoraInicio(inicioTxt);
				 e.setDataHoraFim(fimTxt);
				 //if(calendario.existe(e) != false) {
						calendario.adicionarPorEvento(e);
						resultado.setText("Evento criado com sucesso");
					//} else {
						//throw new EventoJaExistenteException(e.getNome());
					//}
			 } else {
				 dataHoraFimId = dataHoraInicioId;
				 avisoDataFim.setText("Data de fim incoerente; insira um dia válido");
				 throw new DataIncoerenteException(dataHoraFimId.getValue());
			 }
		 } else if(nomeId == null) {
			 resultado.setText("Campo de nome vazio");
		 }
		 
		 }

	 
	 @FXML
	 public void limparCampos() {
		 //dataHoraFimId.clear();
		 nomeId.clear();
		 descricaoId.clear();
		 resultado.setText("");
	 }
	 
	 public void addHoraMinuto()
	 {
		 for(int i = 0; i <= 23; i++) {
			 if(i < 10) {
				 MenuItem j = new MenuItem("0" + i);
				 int id = i;
				 j.setOnAction(new EventHandler<ActionEvent>() {
				     @Override public void handle(ActionEvent e) {
				         horaInicio = id;
				     }
				 });
				 if(j != null) horaInicioId.getItems().add(j);
				 
			 } else {
				 MenuItem j = new MenuItem("" + i);
				 int id = i;
				 j.setOnAction(new EventHandler<ActionEvent>() {
				     @Override public void handle(ActionEvent e) {
				         horaInicio = id;
				     }
				 });
				 if(j != null) horaInicioId.getItems().add(j);
			 }
			 
		 }
		 
		 for(int i = 0; i <= 23; i++) {
			 if(i < 10) {
				 MenuItem j = new MenuItem("0" + i);
				 int id = i;
				 j.setOnAction(new EventHandler<ActionEvent>() {
				     @Override public void handle(ActionEvent e) {
				         horaFim = id;
				     }
				 });
				 if(j != null) horaFimId.getItems().add(j);
			 } else {
				 MenuItem j = new MenuItem("" + i);
				 int id = i;
				 j.setOnAction(new EventHandler<ActionEvent>() {
				     @Override public void handle(ActionEvent e) {
				         horaFim = id;
				     }
				 });
				 if(j != null) horaFimId.getItems().add(j);
			 }
			 
		 }
		 
		 for(int i = 0; i <= 59; i++) {
			 if(i < 10) {
				 MenuItem j = new MenuItem("0" + i);
				 int id = i;
				 j.setOnAction(new EventHandler<ActionEvent>() {
				     @Override public void handle(ActionEvent e) {
				         minutoInicio = id;
				     }
				 });
				 if(j != null) minutoInicioId.getItems().add(j);
			 } else {
				 MenuItem j = new MenuItem("" + i);
				 int id = i;
				 j.setOnAction(new EventHandler<ActionEvent>() {
				     @Override public void handle(ActionEvent e) {
				         minutoInicio = id;
				     }
				 });
				 if(j != null) minutoInicioId.getItems().add(j);
			 }
			 
		 }
		 
		 for(int i = 0; i <= 59; i++) {
			 if(i < 10) {
				 MenuItem j = new MenuItem("0" + i);
				 int id = i;
				 j.setOnAction(new EventHandler<ActionEvent>() {
				     @Override public void handle(ActionEvent e) {
				         minutoFim = id;
				     }
				 });
				 if(j != null) minutoFimId.getItems().add(j);
			 } else {
				 MenuItem j = new MenuItem("" + i);
				 int id = i;
				 j.setOnAction(new EventHandler<ActionEvent>() {
				     @Override public void handle(ActionEvent e) {
				         minutoFim = id;
				     }
				 });
				 if(j != null) minutoFimId.getItems().add(j);
			 }
			 
		 }
	 }
			
	
}
