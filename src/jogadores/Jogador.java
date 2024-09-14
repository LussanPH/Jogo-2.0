package jogadores;
import jogadores.dado.*;

public abstract class Jogador {
	public int casa;
	public Dado[] dado = new Dado[2];
	public String cor = new String();
	
	protected abstract void JogarDados();
	protected void Andar() {
		casa += dado[0].getFace() + dado[1].getFace();
	}
	
	//para o modo debug
	protected void Andar(int nmr) {
		casa += nmr;
	}

}
