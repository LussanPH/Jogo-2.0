package casa;
import jogadores.*;
import java.util.Random;

import exceptions.IllegalMoneyException;

import java.util.List;

public class CasaSurpresa extends Casa{

	public CasaSurpresa(int numero) {
		this.numero = numero;
		tipo = TipoDeCasa.SURPRESA;
		// TODO Auto-generated constructor stub
	}

	public Jogador aplicarRegra(Jogador jogador, List<Jogador> jogadores){
		Random rdm = new Random();
		TipoDeJogador[] tipoDeJogador = TipoDeJogador.values();
		int selected = rdm.nextInt(tipoDeJogador.length);
		TipoDeJogador TdJ = tipoDeJogador[selected];
		Jogador newClassjogador = JogadorFactory.newJogador(TdJ, jogador.getCor());
		try {
			newClassjogador.setMoedas(jogador.getMoedas());
		} catch (IllegalMoneyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newClassjogador.casa = jogador.casa;
		newClassjogador.setRodadasJogadas(jogador.getRodadasJogadas());
		newClassjogador.setDebug(jogador.getDebug());
		jogador = newClassjogador;
		
		return jogador;
		
		
		
	}
}

