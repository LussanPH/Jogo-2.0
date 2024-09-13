package main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Jogo {
    public Jogo(){
    }
    private Tabuleiro criarTabuleiro(){
        Tabuleiro t = Tabuleiro.getInstance();
        return t;
    }

    private void printTabuleiro(Tabuleiro t){
        for(int i = 1; i<=40; i++){
            System.out.print(i);
            System.out.println(t.getCasas()[i-1]);
        }
    }

    @SuppressWarnings("finally")
    private List<String> selecionarJogadores(){
        List<String> cores = new ArrayList<>();
        List<String> coresSelecionadas = new ArrayList<>();
        int i = 0;
        Scanner sc = new Scanner(System.in);
        cores.add("Vermelho");
        cores.add("Branco");
        cores.add("Preto");
        cores.add("Azul");
        cores.add("Verde");
        cores.add("Amarelo");
        try{
            System.out.println("Quantos jogadores no total?");
            int n = sc.nextInt();
            if(n > 6 || n < 1){
                System.out.println("Digite um número válido!");
                selecionarJogadores();
            }
            while(i != n){
                System.out.println("Selecione uma das cores disponíveis(Digite o número da cor): " + cores);
                for(String cor : cores){
                    System.out.print(cores.indexOf(cor) + 1 + " ");
                }
                System.out.println(" ");
                int c = sc.nextInt();
                coresSelecionadas.add(cores.get(c-1));
                cores.remove(c-1);
                i++;
            }
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Digite um número válido!");
            selecionarJogadores();
        }
        catch(InputMismatchException e){
            System.out.println("Digite um número!");
            selecionarJogadores();
        }
        finally{
            sc.close();
            return coresSelecionadas;
        }
    }

    public void rodarJogo(){
        Tabuleiro t = Tabuleiro.getInstance();
        boolean encerrar = false;
        while(encerrar == false){
            System.out.print(selecionarJogadores());
            encerrar = true;
        }
    }
    
    
}
