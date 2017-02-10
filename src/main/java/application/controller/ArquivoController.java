package application.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ArquivoController {

	private Stage dialogStage;
	
	
	@FXML
	private TextField nomeDaPasta;
	
	@FXML
	private TextField copiarParaHomologacao;
	
	@FXML
	private Button abrirArquivo;
	
	@FXML
	private Button copiar;
	
	
	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	
	
	

}
