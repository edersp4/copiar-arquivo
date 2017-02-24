package application.controller;

import application.service.CopiarArquivosService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ArquivoController {

	private Stage dialogStage;
	
	@FXML
	private TextField nomeDaPasta;
	
	@FXML
	private Button copiarbtn;

	@FXML
	private Button abrirArquivobtn;

	
	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	
	CopiarArquivosService copiarArquivosService = new CopiarArquivosService();
	
	@FXML
	public void copiarArquivo() {
		copiarArquivosService.processar(nomeDaPasta.getText(), false);
	}
	
	@FXML
	public void abrirArquivo() throws Exception {
		copiarArquivosService.abrirArquivoDeCopia();
	}
	

}
