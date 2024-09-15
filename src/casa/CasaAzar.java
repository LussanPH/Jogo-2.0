package casa;

import jogadores.Jogador;
import jogadores.JogadorSortudo;
import jogadores.TipoDeJogador;

public class CasaAzar extends Casa{

	public CasaAzar(int numero) {
		this.numero = numero;
	}

	@Override
	public Jogador aplicarRegra(Jogador jogador) {
		if (jogador instanceof JogadorSortudo) {
			try {
			jogador.setMoedas(jogador.getMoedas() - 3);
			}catch(IllegalArgumentException iae) {
				jogador.setMoedas(jogador.getMoedas());
			}
		}
		
		return jogador;
		
	}
	

}
