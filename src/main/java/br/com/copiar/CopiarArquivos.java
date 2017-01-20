package br.com.copiar;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

public class CopiarArquivos {

	public static void main(String[] args) {
		Charset cp = Charset.forName("cp1252");
		Arquivo configuracao = new Arquivo();
		
		List<String> readLines = null;
		configuracao.setComecoDoNomeParaCaminhoAbsoluto("C:/Users/Eder/Desenvolvimento/workspace");
		configuracao.setNomeDiretorioRemoto("X:/FontesParaHomologacao"); 
		configuracao.setNomeDaTarefa(JOptionPane.showInputDialog("Nome da Task"));
		

		File diretorioDestino = new File("C:/Users/Eder/backup/Ederson/Ederson/Tasks/" + configuracao.getNomeDaTarefa() + File.separator);
	
		if(!diretorioDestino.exists()) {
			diretorioDestino.mkdir();
		}
		
		try {
			readLines = FileUtils.readLines(new File("arquivo.txt"), cp);

			for (String nomeDoArquivo : readLines) {
				FileUtils.copyFileToDirectory(new File(configuracao.getComecoDoNomeParaCaminhoAbsoluto() + nomeDoArquivo), diretorioDestino);
				System.out.println(nomeDoArquivo);
			}

			File diretorioRemoto = new File(configuracao.getNomeDiretorioRemoto());
			FileUtils.copyDirectoryToDirectory(diretorioDestino, diretorioRemoto);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
