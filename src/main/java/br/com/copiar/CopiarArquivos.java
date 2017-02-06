package br.com.copiar;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

public class CopiarArquivos {

	
	
	public void processar(String nomeDaPasta , boolean mandarParaPastaHomologacao) {
		Charset cp = Charset.forName("cp1252");
		Arquivo configuracao = new Arquivo();
		
		
		
		List<String> readLines = null;
		configuracao.setCaminhoDoProjeto("C:/Users/Eder/Desenvolvimento/workspace/spprev/");
		configuracao.setNomeDiretorioRemoto("X:/FontesParaHomologacao"); 
		configuracao.setNomeDoDiretorioDestino("C:/Users/Eder/backup/Ederson/Ederson/Tasks/");
		

		File diretorioDestino = new File(configuracao.getNomeDoDiretorioDestino() + nomeDaPasta + File.separator);
	
		if(!diretorioDestino.exists()) {
			diretorioDestino.mkdir();
		}
		
		try {
			readLines = FileUtils.readLines(new File("arquivo.txt"), cp);

			for (String nomeDoArquivo : readLines) {
				FileUtils.copyFileToDirectory(new File(configuracao.getCaminhoDoProjeto() + nomeDoArquivo.trim()), diretorioDestino);
				System.out.println(nomeDoArquivo);
			}

			if(mandarParaPastaHomologacao) {
				File diretorioRemoto = new File(configuracao.getNomeDiretorioRemoto());
				FileUtils.copyDirectoryToDirectory(diretorioDestino, diretorioRemoto);
			}
			
			JOptionPane.showMessageDialog(null, "Foi copiado com sucesso!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
