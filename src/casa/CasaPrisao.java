package casa;
import jogadores.*;
import java.util.List;

public class CasaPrisao extends Casa{
	
	private String resposta;
	
	

	public CasaPrisao(int numero) {
		this.numero = numero;
        tipo = TipoDeCasa.PRISAO;
		// TODO Auto-generated constructor stub
	}
	
	//tenho que pensar uma forma de tirar o scan daí.
	public void setResposta(String resposta) {
		this.resposta = resposta.toLowerCase();
	}

	@Override
	public Jogador aplicarRegra(Jogador jogador, List<Jogador> jogadores) {
        if (!jogador.isPreso()) {
            jogador.setPreso(true);
            jogador.setSentenca(2);
            System.out.println("Impossível pagar primeira rodada, Sentença: 2 turnos.");
        } 
        // Se o jogador já está preso e ainda tem sentença a cumprir
        else if (jogador.getSentenca() > 0) {
            // Se o jogador opta por pagar a fiança
            if (resposta.equals("sim") && jogador.getMoedas() >= 2) {
                jogador.setMoedas(jogador.getMoedas() - 2);
                jogador.setPreso(false);
                jogador.setSentenca(0);
                System.out.println("Fiança paga! Jogador está livre.");
            } 
            // Se o jogador não paga a fiança, a sentença diminui em 1
            else {
                jogador.setSentenca(jogador.getSentenca() - 1);
                System.out.println("Jogador optou por não pagar a fiança ou tinha saldo insuficiente. Turnos restantes: " + jogador.getSentenca());
            }
        } else if (jogador.getSentenca() == 0) {
            jogador.setPreso(false);
            System.out.println("Jogador cumpriu a sentença e está livre.");
        }
        
        //scan.close();
        return jogador;
    }

}
