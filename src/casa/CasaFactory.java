package casa;

public class CasaFactory {
	public static Casa newCasa(String type, int numero) {
		switch(type) {
		case "SIMPLES": return new CasaSimples(numero);
		case "AZAR" : return new CasaAzar(numero);
		case "JOGADENOVO" : return new CasaJogaDeNovo(numero);
		case "REVERSA" : return new CasaReversa(numero);
		case "PRISAO" : return new CasaPrisao(numero);
		case "SORTE" : return new CasaSorte(numero);
		case "SURPRESA": return new CasaSurpresa(numero);
		case "TROCA" : return new CasaTroca(numero);
		default : throw new IllegalArgumentException("Tipo de Casa inexistente.");
		}
	}
}
