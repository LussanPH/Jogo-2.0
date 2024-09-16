package casa;
import jogadores.*;

public class CasaTroca extends Casa{

	protected String resposta;

	public CasaTroca(int numero) {
		this.numero = numero;
	}

	public void getResposta(String resposta){
		this.resposta = resposta;
	}

	@Override
	public Jogador aplicarRegra(Jogador jogador) {
		if(resposta.equalsIgnoreCase("sim")){
			if(!jogador.isBone() && !jogador.isMoletom() && !jogador.isOculosEscuros()){
				// boné vale 4 moedas
				if(jogador.getMoedas() >= 4){
					jogador = new Bone(jogador);
					jogador.setMoedas(jogador.getMoedas() - 4);
					System.out.println("compra feita com sucesso! Jogador está de boné");
				}
				else{
					System.out.println("saldo insuficiente");
				}
			}
			else if(jogador.isBone() && !jogador.isMoletom() && !jogador.isOculosEscuros()){
				// moletom vale 6 moedas
				if(jogador.getMoedas() >= 6){
					jogador = new Moletom(jogador);
					jogador.setMoedas(jogador.getMoedas() - 6);
					System.out.println("compra feita com sucesso! Jogador está de boné e moletom");
				}
				else{
					System.out.println("saldo insuficiente");
				}
			}
			else{
				// oculos escuros vale 8 moedas
				if(jogador.getMoedas() >= 8){
					jogador = new OculosEscuros(jogador);
					jogador.setMoedas(jogador.getMoedas() - 8);
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
		return jogador;
	}
}
