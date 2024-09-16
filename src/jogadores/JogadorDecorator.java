package jogadores;

public class JogadorDecorator extends Jogador{

    protected Jogador jogadorDecorado;

    public JogadorDecorator(Jogador jogadorDecorado){
        this.jogadorDecorado = jogadorDecorado;
    }

    @Override
    public void JogarDados() {
        jogadorDecorado.JogarDados();
    }
}
