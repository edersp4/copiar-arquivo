package application.service;

public class ArquivoService {

	private String caminhoDoProjeto;
	private String nomeDiretorioRemoto;
	private String nomeDoDiretorioDestino;
	private String nomeDoDiretorioDestinoZipado;

	public String getNomeDiretorioRemoto() {
		return nomeDiretorioRemoto;
	}

	public void setNomeDiretorioRemoto(String nomeDiretorioRemoto) {
		this.nomeDiretorioRemoto = nomeDiretorioRemoto;
	}

	public String getNomeDoDiretorioDestino() {
		return nomeDoDiretorioDestino;
	}

	public void setNomeDoDiretorioDestino(String nomeDoDiretorioDestino) {
		this.nomeDoDiretorioDestino = nomeDoDiretorioDestino;
	}

	public String getCaminhoDoProjeto() {
		return caminhoDoProjeto;
	}

	public void setCaminhoDoProjeto(String caminhoDoProjeto) {
		this.caminhoDoProjeto = caminhoDoProjeto;
	}

	public String getNomeDoDiretorioDestinoZipado() {
		return nomeDoDiretorioDestinoZipado;
	}

	public void setNomeDoDiretorioDestinoZipado(String nomeDoDiretorioDestinoZipado) {
		this.nomeDoDiretorioDestinoZipado = nomeDoDiretorioDestinoZipado;
	}

}
