package casa;
import jogadores.*;
import java.util.List;

import exceptions.IllegalMoneyException;

public class CasaSimples extends Casa{
	
	public CasaSimples(int numero) {
		this.numero = numero;
		tipo = TipoDeCasa.SIMPLES;
	}
	
	public Jogador aplicarRegra(Jogador jogador, List<Jogador> jogadores) {
		if(!jogador.isBone() && !jogador.isMoletom() && !jogador.isOculosEscuros()) {
			try {
				jogador.setMoedas(jogador.getMoedas() + 1);
			} catch (IllegalMoneyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(jogador.isBone() && !jogador.isMoletom() && !jogador.isOculosEscuros()){
			try {
				jogador.setMoedas(jogador.getMoedas() + 2);
			} catch (IllegalMoneyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(jogador.isBone() && jogador.isMoletom() && !jogador.isOculosEscuros()){
			try {
				jogador.setMoedas(jogador.getMoedas() + 4);
			} catch (IllegalMoneyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				jogador.setMoedas(jogador.getMoedas() + 7);
			} catch (IllegalMoneyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jogador;
	}
}
