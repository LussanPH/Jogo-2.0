package casa;
import jogadores.*;
import java.util.Random;

public class CasaSurpresa extends Casa{

	public CasaSurpresa(int numero) {
		this.numero = numero;
		// TODO Auto-generated constructor stub
	}

	public Jogador aplicarRegra(Jogador jogador){
		Random rdm = new Random();
		TipoDeJogador[] tipoDeJogador = TipoDeJogador.values();
		int selected = rdm.nextInt(tipoDeJogador.length);
		TipoDeJogador TdJ = tipoDeJogador[selected];
		Jogador newClassjogador = JogadorFactory.newJogador(TdJ, jogador.getCor());
		newClassjogador.setMoedas(jogador.getMoedas());
		newClassjogador.casa = jogador.casa;
		jogador = newClassjogador;
		
		return jogador;
		
		
		
	}
}

