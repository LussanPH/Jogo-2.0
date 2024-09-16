package jogadores;

public class JogadorComum extends Jogador{
	
	public JogadorComum(String cor) {
		this.cor = cor;
		this.casa = 0;
		tipo = TipoDeJogador.COMUM;
	}

	public void JogarDados() {
		intanciadoDados();
		dado[0].JogarDado();
		dado[1].JogarDado();
	}
	
	
	

}
