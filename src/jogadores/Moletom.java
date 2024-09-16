package jogadores;

public class Moletom extends JogadorDecorator{

    public Moletom(Jogador jogadorDecorado) {
        super(jogadorDecorado);
        setMoletom(true);
    }
}
