package br.com.copiar;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class Configuracao {
	
	Configurations configs = new Configurations();
	
	public void gravarConfiguracao(Arquivo arquivo) {
		FileBasedConfigurationBuilder<PropertiesConfiguration>builder = configs.propertiesBuilder("configuracao.properties");
		PropertiesConfiguration configuration;
		try {
			configuration = builder.getConfiguration();
			configuration.setProperty("pasta.projeto", arquivo.getCaminhoDoProjeto());
			configuration.setProperty("pasta.destino", arquivo.getNomeDoDiretorioDestino());
			configuration.setProperty("pasta.remoto", arquivo.getNomeDiretorioRemoto());
			builder.save();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	
	public Arquivo popularArquivoConfiguracao() throws Exception {
		FileBasedConfigurationBuilder<PropertiesConfiguration>builder = configs.propertiesBuilder("configuracao.properties");
		PropertiesConfiguration configuration = builder.getConfiguration();
		Arquivo arquivo = new Arquivo();
		
		if(!configuration.isEmpty()) {
			arquivo.setCaminhoDoProjeto(configuration.getString("pasta.projeto"));
			arquivo.setNomeDoDiretorioDestino(configuration.getString("pasta.destino"));
			arquivo.setNomeDiretorioRemoto(configuration.getString("pasta.remoto"));
		}else {
			throw new Exception("Favor configurar o sistema");
		}
		return arquivo;
	}
}
