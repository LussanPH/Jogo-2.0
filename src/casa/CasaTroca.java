package casa;
import jogadores.Jogador;
public class CasaTroca extends Casa{

	public CasaTroca(int numero) {
		this.numero = numero;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Jogador aplicarRegra(Jogador jogador) {
		//TABULEIRO: decorator dos itens.
		return jogador;
		
	}
	
}
