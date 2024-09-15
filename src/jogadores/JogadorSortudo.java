package jogadores;
import exceptions.InvalidFaceException;
import jogadores.dado.Dado;

public class JogadorSortudo extends Jogador{
	
	public JogadorSortudo(String cor) {
		this.cor = cor;
		this.casa = 0;
		tipo = TipoDeJogador.SORTUDO;
	}
	
	private int soma(Dado[] dado) {
		int soma = dado[0].getFace() + dado[1].getFace();
		return soma;
	}
	public void JogarDados() {
		dado[0].JogarDado();
		dado[1].JogarDado();
		if(soma(dado) < 7 ) {
			int corrigido = (soma(dado) + 6);
			if(corrigido % 2 == 0) {
				try {
				dado[0].setFace(corrigido/2);
				dado[1].setFace(corrigido/2);
				}catch(InvalidFaceException ive) {
					ive.printStackTrace();
				}
			}else {
				try {
					dado[0].setFace((int)(corrigido/2 + 0.5));
					dado[1].setFace((int)(corrigido/2 - 0.5)); 
				}catch(InvalidFaceException ive) {
					try {
						dado[1].setFace((int)(corrigido/2 + 0.5));
						dado[0].setFace((int)(corrigido/2 - 0.5)); 
					} catch (InvalidFaceException ive1) {
						ive1.printStackTrace();
					}		
				}
			}	
		}
	}

}
