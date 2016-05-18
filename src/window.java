import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class window extends JFrame {
	private JButton novoJogo;
    private JButton sair;
    private JButton pedra1;
    private JButton pedra2;
    private JButton papel1;
    private JButton papel2;
    private JButton tesoura1;
    private JButton tesoura2;
	private int jogador1;
    private int jogador2;
    private JButton resultado;
    
	public window()
    {
        super("JoKenPô");
        setLayout(null);
        
       /* NovoJogo novo = new NovoJogo();
        novoJogo = new JButton("Novo Jogo");
        novoJogo.setLocation(150,10);
		novoJogo.setSize(100,40);
        novoJogo.addActionListener(novo);
        add(novoJogo);
        */
        
        jog1 j1 = new jog1();
        pedra1 = new JButton("Pedra");
		pedra1.setLocation(10,10);
		pedra1.setSize(100,40);
		pedra1.addActionListener(j1);
        add(pedra1);
        
        papel1 = new JButton("Papel");
		papel1.setLocation(10,80);
		papel1.setSize(100,40);
        papel1.addActionListener(j1);
		add(papel1);
        
        tesoura1 = new JButton("Tesoura");
		tesoura1.setLocation(10,150);
		tesoura1.setSize(100,40);
        tesoura1.addActionListener(j1);
		add(tesoura1);
        
		jog2 j2 = new jog2();
		pedra2 = new JButton("Pedra");
		pedra2.setLocation(250,10);
		pedra2.setSize(100,40);
		pedra2.addActionListener(j2);
		add(pedra2);
        
        papel2 = new JButton("Papel");
		papel2.setLocation(250,80);
		papel2.setSize(100,40);
		papel2.addActionListener(j2);
		add(papel2);
        
        tesoura2 = new JButton("Tesoura");
		tesoura2.setLocation(250,150);
		tesoura2.setSize(100,40);
		tesoura2.addActionListener(j2);
		add(tesoura2);
		
		result r = new result();
        resultado = new JButton("Resultado");
        resultado.setLocation(100, 200);
        resultado.setSize(150,40);
        resultado.addActionListener(r);
        add(resultado);
    }
	
	public void Vencedor(){
		if(jogador1 == 1){
    		if(jogador2==1)
    			JOptionPane.showMessageDialog(window.this,"Empate");
    		else if(jogador2==2)
    			JOptionPane.showMessageDialog(window.this,"O jogador 2 venceu");
    		else
    			JOptionPane.showMessageDialog(window.this,"O jogador 1 venceu");
    	}
    	else if(jogador1 == 2){
    		if(jogador2==2)
    			JOptionPane.showMessageDialog(window.this,"Empate");
    		else if(jogador2==3)
    			JOptionPane.showMessageDialog(window.this,"O jogador 2 venceu");
    		else
    			JOptionPane.showMessageDialog(window.this,"O jogador 1 venceu");
    	}
    	else{
    		if(jogador2==3)
    			JOptionPane.showMessageDialog(window.this,"Empate");
    		else if(jogador2==1)
    			JOptionPane.showMessageDialog(window.this,"O jogador 2 venceu");
    		else
    			JOptionPane.showMessageDialog(window.this,"O jogador 1 venceu");
    	}
	}
	
	private class jog1 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
           if(event.getSource() == pedra1)
        	   jogador1 = 1;
           else if(event.getSource() == papel1)
        	   jogador1 = 2;
           else if(event.getSource() == tesoura1)
        	   jogador1 = 3;
        }
    }
	
	private class jog2 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
           if(event.getSource() == pedra2)
        	   jogador2 = 1;
           else if(event.getSource() == papel2)
        	   jogador2 = 2;
           else if(event.getSource() == tesoura2)
        	   jogador2 = 3;
        }
    }
	
	private class result implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
           if(event.getSource() == resultado)
        	   Vencedor();
        }
    }

}
