package application.service;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class ConfiguracaoService {
	
	Configurations configs = new Configurations();
	
	public void gravarConfiguracao(ArquivoService arquivo) {
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
	
	
	public ArquivoService popularArquivoConfiguracao() throws Exception {
		FileBasedConfigurationBuilder<PropertiesConfiguration>builder = configs.propertiesBuilder("configuracao.properties");
		PropertiesConfiguration configuration = builder.getConfiguration();
		ArquivoService arquivo = new ArquivoService();
		
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
