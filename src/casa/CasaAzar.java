package casa;

import jogadores.Jogador;
import jogadores.JogadorSortudo;
import java.util.List;

public class CasaAzar extends Casa{

	public CasaAzar(int numero) {
		this.numero = numero;
		tipo = TipoDeCasa.AZAR;
	}

	@Override
	public Jogador aplicarRegra(Jogador jogador, List<Jogador> jogadores) {
		if (!(jogador instanceof JogadorSortudo)) {
			try {
				if(jogador.getMoedas() < 3){
					jogador.setMoedas(0);
				}
				else{
					jogador.setMoedas(jogador.getMoedas() - 3);
				}	
			}catch(IllegalArgumentException iae) {
				jogador.setMoedas(jogador.getMoedas());
			}
		}
		
		return jogador;
		
	}
	

}
