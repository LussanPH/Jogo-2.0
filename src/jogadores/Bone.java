package jogadores;

public class Bone extends JogadorDecorator{

    public Bone(Jogador jogadorDecorado) {
        super(jogadorDecorado);
        setBone(true);
    }
}
