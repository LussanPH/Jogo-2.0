package casa;
import jogadores.*;
import java.util.List;

public class CasaSorte extends Casa{

	public CasaSorte(int numero) {
		this.numero = numero;
		tipo = TipoDeCasa.SORTE;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Jogador aplicarRegra(Jogador jogador, List<Jogador> jogadores) {
		if(!(jogador.getTipo() == TipoDeJogador.AZARADO)) {
			jogador.casa += 3;
		}
		return jogador;
		
	}

}
