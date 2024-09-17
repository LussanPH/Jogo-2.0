package jogadores;

import exceptions.InvalidFaceException;
import jogadores.dado.Dado;

public class JogadorAzarado extends Jogador{
	
	public JogadorAzarado(String cor) {
		this.cor = cor;
		this.casa = 0;
		tipo = TipoDeJogador.AZARADO;
	}
	
	private int soma(Dado[] dado) {
		int soma = dado[0].getFace() + dado[1].getFace();
		return soma;
	}
	
	public void JogarDados() {
		intanciadoDados();
		dado[0].JogarDado();
		dado[1].JogarDado();
		if(soma(dado) > 6  && soma(dado) != 12) {
			int corrigido = (soma(dado) - 5);
			if(corrigido % 2 == 0) {
				try {
				dado[0].setFace((int)(corrigido/2));
				dado[1].setFace((int)(corrigido/2));
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
		}else if(soma(dado)==12){
			try {
				dado[0].setFace(3);
				dado[1].setFace(3);
			} catch (InvalidFaceException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
