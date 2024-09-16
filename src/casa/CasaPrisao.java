package casa;
import jogadores.*;
import java.util.Scanner;

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
	public Jogador aplicarRegra(Jogador jogador) {
        //Scanner scan = new Scanner(System.in);
        
        // Se o jogador não está preso, ele é preso e recebe uma sentença de 2 turnos
        if (!jogador.isPreso()) {
            jogador.setPreso(true);
            jogador.setSentenca(2);
            System.out.println("Jogador foi preso! Sentença: 2 turnos.");
        } 
        // Se o jogador já está preso e ainda tem sentença a cumprir
        else if (jogador.getSentenca() > 0) {
            //System.out.println("Jogador está preso! Sentença restante: " + jogador.getSentenca() + " turno(s).");
            //System.out.println("Pagar fiança? (2 moedas) (sim/nao): ");
            // Se o jogador opta por pagar a fiança
            if (resposta.equals("sim") && jogador.getMoedas() >= 2) {
                jogador.setMoedas(jogador.getMoedas() - 2);
                jogador.setPreso(false);
                jogador.setSentenca(0);
                //System.out.println("Fiança paga! Jogador está livre.");
            } 
            // Se o jogador não paga a fiança, a sentença diminui em 1
            else {
                jogador.setSentenca(jogador.getSentenca() - 1);
                //System.out.println("Jogador optou por não pagar a fiança. Turnos restantes: " + jogador.getSentenca());
            }
        } else if (jogador.getSentenca() == 0) {
            jogador.setPreso(false);
            //System.out.println("Jogador cumpriu a sentença e está livre.");
        }
        
        //scan.close();
        return jogador;
    }

}
