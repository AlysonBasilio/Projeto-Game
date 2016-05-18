import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Window extends JFrame {
	private JButton novoJogo;
    private JButton sair;
    private JButton pedra;
    private JButton papel;
    private JButton tesoura;
    private int jogador1, jogador2;
    
	public Window()
    {
        super("JoKenPô");
        setLayout(null);
        
        jog1 j1 = new jog1();
        pedra = new JButton("Pedra");
		pedra.setLocation(10,10);
		pedra.setSize(100,40);
		pedra.addActionListener(j1);
        add(pedra);
        
        papel = new JButton("Papel");
		papel.setLocation(10,80);
		papel.setSize(100,40);
        papel.addActionListener(j1);
		add(papel);
        
        tesoura = new JButton("Tesoura");
		tesoura.setLocation(10,150);
		tesoura.setSize(100,40);
        tesoura.addActionListener(j1);
		add(tesoura);
        
    }

	public void Vencedor(){
		if(jogador1 == 1){
    		if(jogador2==1)
    			JOptionPane.showMessageDialog(Window.this,"Empate");
    		else if(jogador2==2)
    			JOptionPane.showMessageDialog(Window.this,"O jogador 2 venceu");
    		else
    			JOptionPane.showMessageDialog(Window.this,"O jogador 1 venceu");
    	}
    	else if(jogador1 == 2){
    		if(jogador2==2)
    			JOptionPane.showMessageDialog(Window.this,"Empate");
    		else if(jogador2==3)
    			JOptionPane.showMessageDialog(Window.this,"O jogador 2 venceu");
    		else
    			JOptionPane.showMessageDialog(Window.this,"O jogador 1 venceu");
    	}
    	else{
    		if(jogador2==3)
    			JOptionPane.showMessageDialog(Window.this,"Empate");
    		else if(jogador2==1)
    			JOptionPane.showMessageDialog(Window.this,"O jogador 2 venceu");
    		else
    			JOptionPane.showMessageDialog(Window.this,"O jogador 1 venceu");
    	}
	}
	
	private class jog1 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
           if(event.getSource() == pedra)
        	   jogador1 = 1;
           else if(event.getSource() == papel)
        	   jogador1 = 2;
           else if(event.getSource() == tesoura)
        	   jogador1 = 3;
        }
    }
}
