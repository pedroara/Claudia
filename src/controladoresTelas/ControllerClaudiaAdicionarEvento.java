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
    private TextField horaInicio;
    
    @FXML
    private TextField minutoInicio;
    
    @FXML
    private TextField horaFim;
    
    @FXML
    private TextField minutoFim;
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    
    Calendario calendario = fachadaClaudia.getCalendario();

	 @FXML
	 public void  initialize() {
		 
	ClaudiaBtn.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent event) {Main.loadScene("/gui/homeClaudia.fxml", "Claudia");}} );}
	 
	 @FXML
	 public void cadastrar() throws EventoJaExistenteException, DataIncoerenteException {
		 
		 if(nomeId != null && dataHoraInicioId.getValue() != null && dataHoraFimId.getValue() != null) {
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			 resultado.setText("");
			 avisoDataFim.setText("");
			 
			 if(dataHoraFimId.getValue().isAfter(dataHoraInicioId.getValue()) || dataHoraFimId.getValue() == dataHoraInicioId.getValue()) {
				 LocalDateTime dataInicio = dataHoraInicioId.getValue().atTime(getHora(horaInicio), getMinuto(minutoInicio));
				 LocalDateTime dataFim = dataHoraFimId.getValue().atTime(getHora(horaFim), getMinuto(minutoFim));
				 
				 String inicioTxt = formatter.format(dataInicio);
				 String fimTxt = formatter.format(dataFim);
				 
				 Evento e = new Evento(nomeId.getText());
				 e.setDescricao(descricaoId.getText());
				 e.setDataHoraInicio(inicioTxt);
				 e.setDataHoraFim(fimTxt);
				 //if(calendario.existe(e) != false) {
				 if(dataFim.isAfter(dataInicio)) {
					 calendario.adicionarPorEvento(e);
						resultado.setText("Evento criado com sucesso");
				 }
					//} else {
						//throw new EventoJaExistenteException(e.getNome());
					//}
			 } else {
				 dataHoraFimId = dataHoraInicioId;
				 avisoDataFim.setText("Datas incoerentes; insira um dia válido");
				 throw new DataIncoerenteException(dataHoraFimId.getValue());
			 }
		 } else if(nomeId == null) {
			 resultado.setText("Campo de nome vazio");
		 }
		 
		 }
	 
	 @FXML
	 public int getHora(TextField hora) throws DataIncoerenteException {
		 if(0 < Integer.parseInt(hora.getText()) && Integer.parseInt(hora.getText()) < 23) {
			 return Integer.parseInt(hora.getText());
		 } else {
			 avisoDataFim.setText("Insira um horário válido.");
			 hora.clear();
			 throw new DataIncoerenteException(dataHoraFimId.getValue());
		 }
	 }
	 
	 @FXML
	 public int getMinuto(TextField minuto) throws DataIncoerenteException {
		 if(0 < Integer.parseInt(minuto.getText()) && Integer.parseInt(minuto.getText()) < 59) {
			 return Integer.parseInt(minuto.getText());
		 } else {
			 avisoDataFim.setText("Insira um horário válido.");
			 minuto.clear();
			 throw new DataIncoerenteException(dataHoraFimId.getValue());
		 }
	 }
	 
	 @FXML
	 public void limparCampos() {
		 //dataHoraFimId.clear();
		 nomeId.clear();
		 descricaoId.clear();
		 resultado.setText("");
	 }
	 /*
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
				 if(j != null)
					 horaInicioId.getItems().add(j);
				 
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
		*/	
	
}
