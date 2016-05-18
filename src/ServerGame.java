import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ServerGame implements Runnable{
	private int ID;
	private Resultado resultado;
	DataInputStream in;
	DataOutputStream out;
	
	public ServerGame(Socket accept, Resultado r, int id) throws IOException {
		resultado = r;
		ID=id;		
		in = new DataInputStream(accept.getInputStream());
		out = new DataOutputStream(accept.getOutputStream());
	}

	public void run(){
		try {
			int valor = in.readInt();
			System.out.println("O Player "+ID+" jogou "+valor);
			resultado.setP(valor, ID);
			while (resultado.getResultado()==0){}
			out.writeInt(resultado.getResultado());
			out.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
