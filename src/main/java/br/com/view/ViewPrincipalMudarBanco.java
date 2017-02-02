package br.com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.copiar.CopiarArquivos;

public class ViewPrincipalMudarBanco {
	
	private JFrame frame;
	private JLabel nomeDaVersao;
	private JButton processarBtn;
	private JComboBox ambienteCb;

	public void montarTela() {
		 	frame = new JFrame();  
		   
		 	String[]listaAmbiente = {"Selecione" , "FGV2" , "Homologacao"};
		 	ambienteCb = new JComboBox(listaAmbiente);
		 	ambienteCb.setBounds(70, 20, 200, 30);
		 	
		 	nomeDaVersao = new JLabel("Ambiente");  
		    nomeDaVersao.setBounds( 10,20,200,30);
		    
		    processarBtn = new JButton("mudar");
		    processarBtn.setBounds( 110,150,200,30);
		    processarBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					CopiarArquivos copiar = new CopiarArquivos();
//					copiar.processar(nomeDaPastatxt.getText(), pastaHomologacaocheck.isSelected());
				}
			});
		    
		    frame.add(nomeDaVersao);  
		    frame.add(ambienteCb);
		    frame.add(processarBtn);
		    
		    frame.setSize(400,250);  
		    frame.setLayout(null); 
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);  
		
	}
	
	public static void main(String[] args) {
		new ViewPrincipalMudarBanco().montarTela();
	}

}
