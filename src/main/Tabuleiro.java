package main;
import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    private static Tabuleiro tabuleiro;
    @SuppressWarnings("unchecked")
    private List<String>[] casas = new ArrayList[40];   
    private Tabuleiro(){
        for(int i = 0; i<40; i++){
            casas[i] = new ArrayList<>();
        }
    }
    
    public List<String>[] getCasas() {
        return casas;
    }

    public static Tabuleiro getInstance(){
        if(tabuleiro == null){
            tabuleiro = new Tabuleiro();
        }
        return tabuleiro;
    }
}
