package casa;
import jogadores.*;
import java.util.Random;

public class CasaSurpresa extends Casa{

	public CasaSurpresa(int numero) {
		this.numero = numero;
		// TODO Auto-generated constructor stub
	}

	public void aplicarRegra(Jogador jogador){
		Random rdm = new Random();
		TipoDeJogador[] tipoDeJogador = TipoDeJogador.values();
		int selected = rdm.nextInt(tipoDeJogador.length);
		TipoDeJogador TdJ = tipoDeJogador[selected];
		jogador = JogadorFactory.newJogador(TdJ, jogador.getCor(), jogador.casa, jogador.getPontuacao());
		
	}
}

