package casa;
import jogadores.Jogador;

public class CasaReversa extends Casa{

	public CasaReversa(int numero) {
		this.numero = numero;
		tipo = TipoDeCasa.REVERSA;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Jogador aplicarRegra(Jogador jogador) {
		//TABULEIRO: criem algo que verifique se o jogador ta nessa casa, e troque ele com o ultimo jogador do tabuleiro
		return jogador;
		
	}
	
}
