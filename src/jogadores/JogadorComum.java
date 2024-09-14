package jogadores;

public class JogadorComum extends Jogador{
	
	public JogadorComum(String cor) {
		this.cor = cor;
		this.casa = 0;
	}
	
	public JogadorComum(String cor, int casa, int pontuacao) {
		this.cor = cor;
		this.casa = casa;
		this.pontuacao = pontuacao;
	}

	public void JogarDados() {
		dado[0].JogarDado();
		dado[1].JogarDado();
	}
	
	
	

}
