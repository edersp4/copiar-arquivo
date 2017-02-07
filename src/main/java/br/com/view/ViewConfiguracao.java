package br.com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.copiar.Arquivo;
import br.com.copiar.Configuracao;

public class ViewConfiguracao {
	
	private JFrame frame;
	private JTextField nomeDaPastaProjetotxt, nomeDaPastaDestinotxt , nomeDaPastaRemototxt;
	private JLabel nomeDaPastaProjetoLb , nomeDaPastaDestinoLb, nomeDaPastaRemotoLb;
	private JButton buscarDiretorioProjeto , buscarDiretorioDestino , buscarDiretorioRemoto , gravarbtn;
	private Arquivo configuracao;
	public void montarTela() {
			configuracao = new Arquivo();
		
		 	frame = new JFrame();  
		    nomeDaPastaProjetotxt=new JTextField();  
		    nomeDaPastaProjetotxt.setBounds( 200,20,200,30); 
		    nomeDaPastaProjetotxt.setEditable(false);

		    nomeDaPastaDestinotxt=new JTextField();  
		    nomeDaPastaDestinotxt.setBounds( 200,60,200,30); 
		    nomeDaPastaDestinotxt.setEditable(false);
		   
		    nomeDaPastaRemototxt=new JTextField();  
		    nomeDaPastaRemototxt.setBounds( 200,100,200,30); 
		    nomeDaPastaRemototxt.setEditable(false);
		    
		    nomeDaPastaProjetoLb = new JLabel("Selecione a Pasta do Projeto");  
		    nomeDaPastaProjetoLb.setBounds( 10,20,200,30);

		    nomeDaPastaDestinoLb = new JLabel("Selecione a Pasta para backup");  
		    nomeDaPastaDestinoLb.setBounds( 10,60,200,30);
		    
		    nomeDaPastaRemotoLb = new JLabel("Selecione a Pasta Remoto");  
		    nomeDaPastaRemotoLb.setBounds( 10,100,200,30);
		    
		    buscarDiretorioProjeto = new JButton("...");  
		    buscarDiretorioProjeto.setBounds( 400,20,50,30);
		    buscarDiretorioProjeto.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser procurarbtn = new JFileChooser(); 
				    procurarbtn.setCurrentDirectory(new java.io.File("C://"));
				    procurarbtn.setDialogTitle(null);
				    procurarbtn.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				 
				    procurarbtn.setAcceptAllFileFilterUsed(false);
				    //    
				    if (procurarbtn.showOpenDialog(procurarbtn) == JFileChooser.APPROVE_OPTION) { 
				    	configuracao.setCaminhoDoProjeto(procurarbtn.getSelectedFile().toString());
				    	nomeDaPastaProjetotxt.setText(configuracao.getCaminhoDoProjeto());
				    	JOptionPane.showMessageDialog(null, "Gravado com sucesso");
				      }
				    else {
				      System.out.println("No Selection ");
				      }
					
				}
			});

		    buscarDiretorioDestino = new JButton("...");  
		    buscarDiretorioDestino.setBounds( 400,60,50,30);
		    buscarDiretorioDestino.addActionListener(new ActionListener() {
		    	
		    	@Override
		    	public void actionPerformed(ActionEvent e) {
		    		JFileChooser procurarbtn = new JFileChooser(); 
		    		procurarbtn.setCurrentDirectory(new java.io.File("C://"));
		    		procurarbtn.setDialogTitle(null);
		    		procurarbtn.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		    		
		    		procurarbtn.setAcceptAllFileFilterUsed(false);
		    		//    
		    		if (procurarbtn.showOpenDialog(procurarbtn) == JFileChooser.APPROVE_OPTION) { 
		    			configuracao.setNomeDoDiretorioDestino(procurarbtn.getSelectedFile().toString());
		    			nomeDaPastaDestinotxt.setText(configuracao.getNomeDoDiretorioDestino());
		    		}
		    		else {
		    			System.out.println("No Selection ");
		    		}
		    		
		    	}
		    });
		    
		    buscarDiretorioRemoto = new JButton("...");  
		    buscarDiretorioRemoto.setBounds( 400,100,50,30);
		    buscarDiretorioRemoto.addActionListener(new ActionListener() {
		    	
		    	@Override
		    	public void actionPerformed(ActionEvent e) {
		    		JFileChooser procurarbtn = new JFileChooser(); 
		    		procurarbtn.setCurrentDirectory(new java.io.File("C://"));
		    		procurarbtn.setDialogTitle(null);
		    		procurarbtn.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		    		
		    		procurarbtn.setAcceptAllFileFilterUsed(false);
		    		//    
		    		if (procurarbtn.showOpenDialog(procurarbtn) == JFileChooser.APPROVE_OPTION) { 
		    			configuracao.setNomeDiretorioRemoto(procurarbtn.getSelectedFile().toString());
		    			nomeDaPastaRemototxt.setText(configuracao.getNomeDiretorioRemoto());
		    		}
		    		else {
		    			System.out.println("No Selection ");
		    		}
		    		
		    	}
		    });
		    
		    
		    gravarbtn = new JButton("Gravar");  
		    gravarbtn.setBounds( 250,150,100,30);
		    gravarbtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Configuracao config = new Configuracao();
					config.gravarConfiguracao(configuracao);
				}
			});
		    

		    frame.add(nomeDaPastaProjetoLb);  
		    frame.add(nomeDaPastaDestinoLb);  
		    frame.add(nomeDaPastaRemotoLb);  
		    
		    frame.add(nomeDaPastaProjetotxt);
		    frame.add(nomeDaPastaDestinotxt);  
		    frame.add(nomeDaPastaRemototxt);  

		    frame.add(buscarDiretorioProjeto);
		    frame.add(buscarDiretorioDestino);
		    frame.add(buscarDiretorioRemoto);
		    frame.add(gravarbtn);
		    
		    frame.setSize(600,300);  
		    frame.setLayout(null); 
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);  
		
	}
	
	public static void main(String[] args) {
		new ViewConfiguracao().montarTela();
	}

}
