package jogadores;

public class JogadorFactory {
	public static Jogador newJogador(TipoDeJogador type, String cor) {
		switch (type){
		case AZARADO : return new JogadorAzarado(cor);
		case SORTUDO : return new JogadorComum(cor);
		case COMUM : return new JogadorSortudo(cor);
		default : throw new IllegalArgumentException("Tipo de Jogador invalido");
		}
	}
	
	public static Jogador newJogador(TipoDeJogador type, String cor, int casa, int pontuacao) {
		switch (type){
		case AZARADO : return new JogadorAzarado(cor, casa, pontuacao);
		case SORTUDO : return new JogadorComum(cor, casa, pontuacao);
		case COMUM : return new JogadorSortudo(cor, casa, pontuacao);
		default : throw new IllegalArgumentException("Tipo de Jogador invalido");
		}
	}
	
}
