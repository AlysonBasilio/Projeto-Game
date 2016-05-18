import java.awt.Color;

import javax.swing.JFrame;

public class JoKenPo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		window mainWindow = new window();
		
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.getContentPane().setBackground(Color.BLACK);
        mainWindow.setSize(400,300);
        mainWindow.setVisible(true);
	}

}
