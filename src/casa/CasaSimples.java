package casa;
import jogadores.*;

public class CasaSimples extends Casa{
	
	public CasaSimples(int numero) {
		this.numero = numero;
	}
	
	public Jogador aplicarRegra(Jogador jogador) {
		if(!jogador.isBone() && !jogador.isMoletom() && !jogador.isOculosEscuros()) {
			jogador.setMoedas(jogador.getMoedas() + 1);
		}
		else if(jogador.isBone() && !jogador.isMoletom() && !jogador.isOculosEscuros()){
			jogador.setMoedas(jogador.getMoedas() + 2);
		}
		else if(jogador.isBone() && jogador.isMoletom() && !jogador.isOculosEscuros()){
			jogador.setMoedas(jogador.getMoedas() + 4);
		}
		else{
			jogador.setMoedas(jogador.getMoedas() + 7);
		}
		return jogador;
	}
}
