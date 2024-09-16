package jogadores;

public class OculosEscuros extends JogadorDecorator{

    public OculosEscuros(Jogador jogadorDecorado) {
        super(jogadorDecorado);
        setOculosEscuros(true);
    }
}
