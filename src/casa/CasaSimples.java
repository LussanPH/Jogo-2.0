package casa;
import jogadores.*;

public class CasaSimples extends Casa{
	
	public CasaSimples(int numero) {
		this.numero = numero;
	}
	
	public Jogador aplicarRegra(Jogador jogador) {
		jogador.setMoedas(jogador.getMoedas() + 1);
		return jogador;
	}
	
}
