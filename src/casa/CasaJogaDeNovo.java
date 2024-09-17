package casa;
import jogadores.*;
import java.util.Scanner;
import java.util.List;
public class CasaJogaDeNovo extends Casa{

	public CasaJogaDeNovo(int numero) {
		// TODO Auto-generated constructor stub
		this.numero = numero;
		tipo = TipoDeCasa.JOGADENOVO;
	}

	@Override
	public Jogador aplicarRegra(Jogador jogador, List<Jogador> jogadores) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Jogue novamente!, pressione enter");
    	sc.nextLine();
    	if(!jogador.getDebug()) {
        jogador.JogarDados();
        jogador.Andar();
        System.out.println("Soma dos dados: " + jogador.somaDados());
		
    	}else {
    		System.out.println("Digite quantas casas quer andar");
    		int casa = sc.nextInt();
    		jogador.Andar(casa);
    		sc.nextLine();
    	}
    	return jogador;
	}

}
