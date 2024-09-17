package casa;
import jogadores.*;
import java.util.List;

public abstract class Casa {
	public int numero;
	public TipoDeCasa tipo;
	public abstract Jogador aplicarRegra(Jogador jogador, List<Jogador> jogadores);
	
}
