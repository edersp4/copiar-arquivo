package br.com.copiar;

public class Arquivo {
	
	private String comecoDoNomeParaCaminhoAbsoluto;
	private String nomeDiretorioRemoto ;

	public String getComecoDoNomeParaCaminhoAbsoluto() {
		return comecoDoNomeParaCaminhoAbsoluto;
	}
	public void setCaminhoDoProjeto(String comecoDoNomeParaCaminhoAbsoluto) {
		this.comecoDoNomeParaCaminhoAbsoluto = comecoDoNomeParaCaminhoAbsoluto;
	}
	public String getNomeDiretorioRemoto() {
		return nomeDiretorioRemoto;
	}
	public void setCaminhoDoDiretorioRemoto(String nomeDiretorioRemoto) {
		this.nomeDiretorioRemoto = nomeDiretorioRemoto;
	}
}
