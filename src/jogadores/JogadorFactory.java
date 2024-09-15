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
}
