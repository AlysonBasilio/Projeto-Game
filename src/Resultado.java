import javax.swing.JOptionPane;


public class Resultado {
	private int resultado;
	private int p1;
	private int p2;
	
	Resultado(){
		resultado=0;
		p1=0;
		p2=0;
	}
	
	public synchronized int getResultado(){
		if(p1 == 1){
    		if(p2==1)
    			resultado=3;
    		else if(p2==2)
    			resultado=2;
    		else if(p2==3)
    			resultado=1;
    	}
    	else if(p1 == 2){
    		if(p2==2)
    			resultado=3;
    		else if(p2==3)
    			resultado=2;
    		else if(p2==1)
    			resultado=1;
    	}
    	else if(p1 == 3){
    		if(p2==3)
    			resultado=3;
    		else if(p2==1)
    			resultado=2;
    		else if(p2==2)
    			resultado=1;
    	}
		return resultado;
	}
	
	public void setP(int p, int ID) {
		if(ID == 1)
			this.p1 = p;
		else
			this.p2 = p;
	}
}
