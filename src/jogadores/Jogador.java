package jogadores;
import jogadores.dado.*;

public abstract class Jogador {
	public int casa;
	protected Dado[] dado = new Dado[2];
	protected String cor = new String();
	protected int pontuacao;
	
	public String getCor() {
		return cor;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		if(pontuacao > 0) {
		this.pontuacao = pontuacao;
		}else{
			throw new IllegalArgumentException("Pontuacao não pode ser menor que 0");
		}
	}
	
	public abstract void JogarDados();
	public void Andar() {
		casa += dado[0].getFace() + dado[1].getFace();
	}
	
	//para o modo debug
	public void Andar(int nmr) {
		casa += nmr;
	}

}
