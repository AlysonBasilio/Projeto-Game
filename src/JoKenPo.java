import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JoKenPo extends JFrame{
	private JButton pedra;
    private JButton papel;
    private JButton tesoura;
    Socket player;
    DataInputStream in;
    DataOutputStream out;
    int resposta;
    
    public JoKenPo() throws UnknownHostException, IOException{
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

	private class jog1 implements ActionListener
    {
        public void actionPerformed(ActionEvent event){
       	   try {
       		   player = new Socket("127.0.0.1", 12345);
       		   System.out.println("O player se conectou ao ServerGame!");    
       		   in = new DataInputStream(player.getInputStream());
       		   out = new DataOutputStream(player.getOutputStream());
       		   if(event.getSource() == pedra) {
       			   out.writeInt(1);
       			   resposta=in.readInt();
       			   if(resposta==3)
               		   JOptionPane.showMessageDialog(null, "Empate");
               	   else if(resposta==2)
               		   JOptionPane.showMessageDialog(null,"Player 2 wins");
               	   else if(resposta==1)
               		   JOptionPane.showMessageDialog(null,"Player 1 wins");
       		   }
               else if(event.getSource() == papel) {
               	   out.writeInt(2);
               	   resposta = in.readInt();
               	   if(resposta==3)
               		   JOptionPane.showMessageDialog(null, "Empate");
               	   else if(resposta==2)
               		   JOptionPane.showMessageDialog(null,"Player 2 wins");
               	   else if(resposta==1)
               		   JOptionPane.showMessageDialog(null,"Player 1 wins");
               }
               else if(event.getSource() == tesoura) {
               	   out.writeInt(3);
               	   resposta = in.readInt();
               	   if(resposta==3)
               		   JOptionPane.showMessageDialog(null, "Empate");
               	   else if(resposta==2)
               		   JOptionPane.showMessageDialog(null,"Player 2 wins");
               	   else if(resposta==1)
               		   JOptionPane.showMessageDialog(null,"Player 1 wins");
               }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JoKenPo jokenpo = new JoKenPo();
        jokenpo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jokenpo.getContentPane().setBackground(Color.BLACK);
        jokenpo.setSize(400,300);
        jokenpo.setVisible(true);
		
	}
}
