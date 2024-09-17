package casa;
import jogadores.*;
import java.util.List;

import exceptions.IllegalMoneyException;

public class CasaTroca extends Casa{

	protected String resposta;

	public CasaTroca(int numero) {
		this.numero = numero;
		tipo = TipoDeCasa.TROCA;
	}

	public void setResposta(String resposta){
		this.resposta = resposta;
	}

	@Override
	public Jogador aplicarRegra(Jogador jogador, List<Jogador> jogadores) {
		Jogador JOGADOR = jogador;
		if(resposta.equalsIgnoreCase("sim")){
			if(!jogador.isBone() && !jogador.isMoletom() && !jogador.isOculosEscuros()){
				// boné vale 4 moedas
				try {
					jogador.setMoedas(jogador.getMoedas() - 4);
					int moedasOriginais2 = jogador.getMoedas();
					JOGADOR = new Bone(jogador);
					JOGADOR.setMoedas(moedasOriginais2);
					System.out.println("compra feita com sucesso! Jogador está de boné");
				} catch (IllegalMoneyException ime) {
					System.out.println("saldo insuficiente");
				}
			}
			else if(jogador.isBone() && !jogador.isMoletom() && !jogador.isOculosEscuros()){
				// moletom vale 6 moedas
					try {
						JOGADOR.setMoedas(jogador.getMoedas() - 6);
						int moedasOriginais2 = jogador.getMoedas();
						JOGADOR = new Moletom(jogador);
						JOGADOR.setMoedas(moedasOriginais2);
						System.out.println("compra feita com sucesso! Jogador está de boné e moletom");
					}catch(IllegalMoneyException ime) {
						System.out.println("saldo insuficiente");
					}
			}
			else{
				// oculos escuros vale 8 moedas
				try {
					JOGADOR.setMoedas(jogador.getMoedas() - 8);
					int moedasOriginais2 = jogador.getMoedas();
					JOGADOR = new OculosEscuros(jogador);
					JOGADOR.setMoedas(moedasOriginais2);
					System.out.println("compra feita com sucesso! Jogador está de boné, moletom e óculos escuros");
				}
				catch(IllegalMoneyException ime){
					System.out.println("saldo insuficiente");
				}
			}
		}
		else{
			System.out.println("jogador não quis comprar nada");
		}
		return JOGADOR;
	}
}
