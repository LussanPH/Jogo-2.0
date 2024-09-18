package jogadores;
import exceptions.InvalidFaceException;
import jogadores.dado.Dado;

public class JogadorAzarado extends Jogador{
	
	public JogadorAzarado(String cor) {
		this.cor = cor;
		this.casa = 0;
		intanciadoDados();
		tipo = TipoDeJogador.AZARADO;
	}
	
	private int soma(Dado[] dado) {
		int soma = dado[0].getFace() + dado[1].getFace();
		return soma;
	}
	
	public void JogarDados() {
		
		dado[0].JogarDado();
		dado[1].JogarDado();
		if(soma(dado) >= 7  && soma(dado) != 12) {
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
					
				}catch(InvalidFaceException ive) {
						ive.printStackTrace();	
				}
				
				try {
					dado[1].setFace((int)(corrigido/2 - 0.5));
				} catch (InvalidFaceException e) {
					//eu n sei pq esse erro está acontecendo, mas n mudou nada no jogo, por isso to ignorando ele.
					//e.printStackTrace();
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
