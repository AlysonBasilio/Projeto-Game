import java.io.*;
import java.net.*;
import java.util.*;


public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException{
		Socket cliente = new Socket("127.0.0.1", 12345);
		System.out.println("O cliente se conectou ao proxy!");
		
		Scanner teclado = new Scanner(System.in);
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		//while(teclado.hasNextLine()){
			saida.println(teclado.nextLine());
		//}
		
		Scanner scanner = new Scanner(cliente.getInputStream());
		//while (scanner.hasNextLine()){
			System.out.println(scanner.nextLine());
		//}
		
		scanner.close();
		saida.close();
		teclado.close();
		cliente.close();
	}

}
