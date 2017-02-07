package br.com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.copiar.CopiarArquivos;

public class ViewPrincipal {
	
	private JFrame frame;
	private JTextField nomeDaPastatxt;
	private JLabel nomeDaPastaLb , pastaHomologacaolb;
	private JButton processarBtn , abrirArquivobtn;
	private JCheckBox pastaHomologacaocheck;
	
	
	public void montarTela() throws Exception {
		CopiarArquivos copiar = new CopiarArquivos();
		
		
		 	frame = new JFrame();  
		    nomeDaPastatxt=new JTextField();  
		    nomeDaPastatxt.setBounds( 110,20,200,30);  
		   
		    nomeDaPastaLb = new JLabel("Nome da Pasta");  
		    nomeDaPastaLb.setBounds( 10,20,200,30);
		    
		    pastaHomologacaocheck = new JCheckBox();
		    pastaHomologacaocheck.setBounds(10, 80, 30, 30);
		    
		    pastaHomologacaolb = new JLabel("Copiar Para Homologação"); 
		    pastaHomologacaolb.setBounds(40, 80, 220, 30);
		    
		    processarBtn = new JButton("Copiar");  
		    processarBtn.setBounds( 10,150,180,30);
		    processarBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					copiar.processar(nomeDaPastatxt.getText(), pastaHomologacaocheck.isSelected());
				}
			});
		    
		    abrirArquivobtn = new JButton("Abrir arquivo para copiar");
		    abrirArquivobtn.setBounds( 200,150,180,30);
		    abrirArquivobtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						copiar.abrirArquivoDeCopia();
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			});
		    
		    
		    frame.add(nomeDaPastaLb);  
		    frame.add(nomeDaPastatxt); 
		    frame.add(processarBtn);
		    frame.add(pastaHomologacaolb);
		    frame.add(pastaHomologacaocheck);
		    frame.add(abrirArquivobtn);
		    
		    frame.setSize(400,250);  
		    frame.setLayout(null); 
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);  
		
	}
	
	public static void main(String[] args) throws Exception {
		try {
			new ViewPrincipal().montarTela();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
