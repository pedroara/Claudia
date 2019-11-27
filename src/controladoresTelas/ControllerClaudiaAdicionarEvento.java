package controladoresTelas;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javax.swing.text.DateFormatter;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sistema.claudia.dados.Calendario;
import sistema.claudia.exceptions.DataIncoerenteException;
import sistema.claudia.exceptions.EventoJaExistenteException;
import sistema.claudia.negocio.Evento;
import sistema.claudia.negocio.FachadaClaudia;
import controladoresTelas.ControllerClaudiaApp;

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
		 if(nomeId != null && dataHoraInicioId.getValue() != null && dataHoraFimId.getValue() != null) {
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			 resultado.setText("");
			 avisoDataFim.setText("");
			 
			 if(dataHoraFimId.getValue().isAfter(dataHoraInicioId.getValue()) || dataHoraFimId.getValue() == dataHoraInicioId.getValue()) {
				 LocalDateTime dataInicio = dataHoraInicioId.getValue().atStartOfDay();
				 LocalDateTime dataFim = dataHoraFimId.getValue().atStartOfDay();
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
			
	
}
