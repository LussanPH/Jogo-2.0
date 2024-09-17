package casa;
import jogadores.*;
import java.util.List;

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
				if(jogador.getMoedas() >= 4){
					JOGADOR = new Bone(jogador);
					JOGADOR.setMoedas(jogador.getMoedas() - 4);
					System.out.println("compra feita com sucesso! Jogador está de boné");
				}
				else{
					System.out.println("saldo insuficiente");
				}
			}
			else if(jogador.isBone() && !jogador.isMoletom() && !jogador.isOculosEscuros()){
				// moletom vale 6 moedas
				if(jogador.getMoedas() >= 6){
					JOGADOR = new Moletom(jogador);
					JOGADOR.setMoedas(jogador.getMoedas() - 6);
					System.out.println("compra feita com sucesso! Jogador está de boné e moletom");
				}
				else{
					System.out.println("saldo insuficiente");
				}
			}
			else{
				// oculos escuros vale 8 moedas
				if(jogador.getMoedas() >= 8){
					JOGADOR = new OculosEscuros(jogador);
					JOGADOR.setMoedas(jogador.getMoedas() - 8);
					System.out.println("compra feita com sucesso! Jogador está de boné, moletom e óculos escuros");
				}
				else{
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
