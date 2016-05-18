import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ServerGame implements Runnable{
	private int ID;
	private Resultado resultado;
	PrintStream saida;
	Scanner scanner;
	
	public ServerGame(Socket accept, Resultado r, int id) throws IOException {
		resultado = r;
		ID=id;		
		saida = new PrintStream(accept.getOutputStream());
		scanner = new Scanner(accept.getInputStream());
	}

	public void run(){
		int valor = Integer.parseInt(scanner.nextLine());
		while(valor==0)
			valor = Integer.parseInt(scanner.nextLine());
		System.out.println("O Player "+ID+" jogou "+valor);
		resultado.setP(valor, ID);
		while (resultado.getResultado()==0){}
		saida.println(resultado.getResultado());
		saida.close();
		scanner.close();
	}
	
	public static void main(String args[]) throws IOException{
		ServerSocket servidor = new ServerSocket(12345);
		System.out.println("Porta 12345 aberta!");
		Resultado r = new Resultado();
		ServerGame s1 = new ServerGame(servidor.accept(), r, 1);
		System.out.println("Nova conexão com o cliente 1");
		Thread thr1 = new Thread(s1);
		thr1.start();
		ServerGame s2 = new ServerGame(servidor.accept(), r, 2);
		System.out.println("Nova conexão com o cliente 2");
		Thread thr2 = new Thread(s2);
		thr2.start();
	}
}
