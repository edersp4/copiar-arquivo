package application.service;

import java.awt.Desktop;
import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

public class CopiarArquivosService {

	
	
	public void processar(String nomeDaPasta , boolean mandarParaPastaHomologacao , boolean zip) {
		Charset cp = Charset.forName("cp1252");
		ArquivoService arquivoConfiguracao = new ArquivoService();
		ConfiguracaoService configuracao = new ConfiguracaoService();
		
		try {
			arquivoConfiguracao = configuracao.popularArquivoConfiguracao();
		
			List<String> readLines = null;

			File diretorioDestino = new File(arquivoConfiguracao.getNomeDoDiretorioDestino() + File.separator + nomeDaPasta + File.separator);
	
			if (!diretorioDestino.exists()) {
				diretorioDestino.mkdir();
			}

			readLines = FileUtils.readLines(new File("arquivo.txt"), cp);

			for (String nomeDoArquivo : readLines) {
				FileUtils.copyFileToDirectory(new File(arquivoConfiguracao.getCaminhoDoProjeto() + File.separator + nomeDoArquivo.trim()), diretorioDestino);
				System.out.println(nomeDoArquivo);
			}

			if(mandarParaPastaHomologacao) {
				File diretorioRemoto = new File(arquivoConfiguracao.getNomeDiretorioRemoto());
				FileUtils.copyDirectoryToDirectory(diretorioDestino, diretorioRemoto);
			}
			
			if(zip) {
				ZipUtil.zipFolder(diretorioDestino.getAbsolutePath() + ".zip", diretorioDestino);
			}
			
			JOptionPane.showMessageDialog(null, "Foi copiado com sucesso!");
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}
		
	}
	
	public void abrirArquivoDeCopia() throws Exception {
		try {
	    	Runtime runtime = Runtime.getRuntime();
	    	runtime.exec("C:\\Program Files\\Notepad++\\notepad++.exe arquivo.txt");
	    }catch (Exception e) {
	    	if (Desktop.isDesktopSupported()) {
	    	    Desktop.getDesktop().edit(new File("arquivo.txt"));
	    	} else {
	    		throw new Exception("N�o � poss�vel abrir o arquivo");
	    	}
		}
	}
}
