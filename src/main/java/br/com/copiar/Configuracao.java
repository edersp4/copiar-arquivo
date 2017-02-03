package br.com.copiar;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class Configuracao {
	
	Configurations configs = new Configurations();
	
	public void gravarConfiguracao(String nomeDaPastaLocal , String nomeDaPastaHomologacao) {
		FileBasedConfigurationBuilder<PropertiesConfiguration>builder = configs.propertiesBuilder("configuracao.properties");
		PropertiesConfiguration configuration;
		try {
			configuration = builder.getConfiguration();
			configuration.addProperty("ederson", "teste");
			builder.save();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	
	public void lerArquivoConfiguracao() {
		
	}
	
	public static void main(String[] args) {
		new Configuracao().gravarConfiguracao("ederson" , "ederson");
	}
}
