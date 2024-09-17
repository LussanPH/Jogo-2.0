package casa;

import jogadores.Jogador;
import jogadores.JogadorSortudo;
import java.util.List;

import exceptions.IllegalMoneyException;

public class CasaAzar extends Casa{

	public CasaAzar(int numero) {
		this.numero = numero;
		tipo = TipoDeCasa.AZAR;
	}

	@Override
	public Jogador aplicarRegra(Jogador jogador, List<Jogador> jogadores) {
		if (!(jogador instanceof JogadorSortudo)) {
			try {
				jogador.setMoedas(jogador.getMoedas() - 3);	
			}catch(IllegalMoneyException ime) {
				try {
					jogador.setMoedas(jogador.getMoedas());
				} catch (IllegalMoneyException e) {
					e.printStackTrace();
				}
			}
		}
		
		return jogador;
		
	}
	

}
