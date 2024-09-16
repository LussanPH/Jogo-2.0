package casa;
import jogadores.*;

public abstract class Casa {
	public int numero;
	public TipoDeCasa tipo;
	public abstract Jogador aplicarRegra(Jogador jogador);
	
}
