package casa;
import jogadores.*;

public class CasaSorte extends Casa{

	public CasaSorte(int numero) {
		this.numero = numero;
		tipo = TipoDeCasa.SORTE;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Jogador aplicarRegra(Jogador jogador) {
		if(jogador instanceof JogadorAzarado) {
			jogador.casa += 3;
		}
		return jogador;
		
	}

}
