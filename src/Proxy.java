import java.io.*;
import java.net.*;
import java.util.*;

public class Proxy {
	public static void main(String args[]) throws IOException{
		ServerSocket servidor = new ServerSocket(12345);
		System.out.println("Porta 12345 aberta!");
		
		//Aqui começa a conexão com o servidor	
		Socket proxy = new Socket("127.0.0.2", 8000);
		System.out.println("O proxy se conectou ao Servidor!");
		
		Socket cliente = servidor.accept();
		System.out.println("Nova conexão com o cliente "+cliente.getInetAddress().getHostAddress());
		
		Scanner scanner = new Scanner(cliente.getInputStream());
				
		//Envia mensagem do cliente para o servidor
		PrintStream saida = new PrintStream(proxy.getOutputStream());
		saida.println(scanner.nextLine());
		
		//Recebe mensagem do servidor
		Scanner scanner2 = new Scanner(proxy.getInputStream());
		
		//Aqui encerra a conexão proxy-servidor
		
		PrintStream saida2 = new PrintStream(cliente.getOutputStream());
		saida2.println(scanner2.nextLine());
		
		scanner.close();
		servidor.close();
		cliente.close();
		scanner2.close();
		saida.close();
		proxy.close();
	}
}
