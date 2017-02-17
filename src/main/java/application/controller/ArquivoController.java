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
	private Button copiarbtn;
	
	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	
	
//	@FXML
//    private void initialize(){
//    }
//	
	@FXML
	public void buscarOla() {
		System.out.println("teste");
	}
	

}
