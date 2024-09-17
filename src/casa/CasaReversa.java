package casa;
import jogadores.Jogador;
import java.util.List;

public class CasaReversa extends Casa{

	public CasaReversa(int numero) {
		this.numero = numero;
		tipo = TipoDeCasa.REVERSA;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Jogador aplicarRegra(Jogador jogador, List<Jogador> jogadores) {
		int menor = 40, aux = 0;
		Jogador jMenor = null;
		for(int i = 0; i<jogadores.size(); i++){
			if(jogadores.get(i).casa < menor){
				menor = jogadores.get(i).casa;
				jMenor = jogadores.get(i);
			}
		}
		if(jogador.casa != menor){
			aux = jogador.casa;
			jogador.casa = jMenor.casa;
			jMenor.casa = aux;
		}
		return jogador;
		
	}
	
}
