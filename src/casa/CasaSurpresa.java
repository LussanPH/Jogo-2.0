package casa;
import jogadores.*;
import java.util.Random;
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
		newClassjogador.setMoedas(jogador.getMoedas());
		newClassjogador.casa = jogador.casa;
		newClassjogador.setRodadasJogadas(jogador.getRodadasJogadas());
		newClassjogador.setDebug(jogador.getDebug());
		jogador = newClassjogador;
		
		return jogador;
		
		
		
	}
}

