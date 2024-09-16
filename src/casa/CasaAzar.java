package casa;

import jogadores.Jogador;
import jogadores.JogadorSortudo;

public class CasaAzar extends Casa{

	public CasaAzar(int numero) {
		this.numero = numero;
		tipo = TipoDeCasa.AZAR;
	}

	@Override
	public Jogador aplicarRegra(Jogador jogador) {
		if (!(jogador instanceof JogadorSortudo)) {
			try {
			jogador.setMoedas(jogador.getMoedas() - 3);
			}catch(IllegalArgumentException iae) {
				jogador.setMoedas(jogador.getMoedas());
			}
		}
		
		return jogador;
		
	}
	

}
