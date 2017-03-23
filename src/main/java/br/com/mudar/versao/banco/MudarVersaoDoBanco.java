package br.com.mudar.versao.banco;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import br.com.view.ViewPrincipalMudarBanco;

public class MudarVersaoDoBanco extends Task{
	@Override
	public void execute() throws BuildException {
		ViewPrincipalMudarBanco viewPrincipalMudarBanco  = new ViewPrincipalMudarBanco();
	}
	

}
