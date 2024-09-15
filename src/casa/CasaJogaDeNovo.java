package casa;
import jogadores.*;
public class CasaJogaDeNovo extends Casa{

	public CasaJogaDeNovo(int numero) {
		// TODO Auto-generated constructor stub
		this.numero = numero;
	}

	@Override
	public Jogador aplicarRegra(Jogador jogador) {
		//TABULEIRO: no tabuleiro, peça pra ele verificar se a casa é JOGADENOVO, se sim, ele joga os dados e joga novamente.
		return jogador;
	}

}
