package jogadores;
import jogadores.dado.*;

public abstract class Jogador {
	public int casa;
	public Dado[] dado = new Dado[2];
	public String cor = new String();
	public int[] valorDado = new int[2];
	
	protected abstract void JogarDado();
	protected void Andar() {
		casa += valorDado[1] + valorDado[2];
	}
	
	//para o modo debug
	protected void Andar(int nmr) {
		casa += nmr;
	}

}
