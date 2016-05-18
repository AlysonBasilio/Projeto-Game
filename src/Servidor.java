import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor {
	public static void main(String args[]) throws IOException{
		ServerSocket servidor = new ServerSocket(8000);
		System.out.println("Porta 8000 aberta!");
		
		Socket cliente = servidor.accept();
		System.out.println("Nova conexão com o cliente "+cliente.getInetAddress().getHostAddress());
		
		Scanner scanner = new Scanner(cliente.getInputStream());
		System.out.println(scanner.nextLine());
		
		Scanner teclado = new Scanner(System.in);
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		saida.println(teclado.nextLine());
		
		teclado.close();
		scanner.close();
		servidor.close();
		cliente.close();
	}
}
