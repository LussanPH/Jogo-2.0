package main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import exceptions.InvalidNumberException;
import jogadores.*;
public class Jogo {
    public Jogo(){
    }
    private Tabuleiro criarTabuleiro(){
        Tabuleiro t = Tabuleiro.getInstance();
        return t;
    }

    private void printTabuleiro(Tabuleiro t, List<Jogador> jogadores){
        for(Jogador j : jogadores){
            System.out.println("Cor: " + j.getCor() + ", Moedas: " + j.getMoedas() + ", Casa: " + j.casa);
        }
    }

    private void inicializarTabuleiro(List<String> cores, Tabuleiro t){
        for(String cor : cores){
            t.setCores(cor, 0);
        }
    }

    private List<Jogador> instanciarJogadores(List<String> cores){
        Scanner sc = new Scanner(System.in);
        int j = 0;
        List<Jogador> jogadores = new ArrayList<>();
        for(String cor : cores){
            boolean teste1 = true, teste2 = true;
            while(teste1 == true){
                try{
                    if(j == cores.size() - 1){
                        int diff = 0;
                        for(int i = 0; i<j; i++){
                            if(jogadores.size() == 1){
                                continue;
                            }
                            else{
                                if(jogadores.get(i).getTipo().equals(jogadores.get(j-1).getTipo())){
                                    continue;
                                }
                                else{
                                    diff++;
                                }
                            }
                        }
                        if(diff == 0){
                            TipoDeJogador tipo = jogadores.get(0).getTipo();
                            while(teste2 == true){
                                try{
                                    if(tipo == TipoDeJogador.AZARADO){
                                        System.out.println("Selecione o tipo de jogador da peça " + cor + ":(2=Comum/3=Sortudo)");
                                        int z = sc.nextInt();
                                        if(z == 2){
                                            jogadores.add(JogadorFactory.newJogador(TipoDeJogador.COMUM, cor));
                                            teste2 = false;
                                            teste1 = false;
                                        }
                                        else if(z == 3){
                                            jogadores.add(JogadorFactory.newJogador(TipoDeJogador.SORTUDO, cor));
                                            teste2 = false;
                                            teste1 = false;
                                        }
                                        else{
                                            throw new InvalidNumberException("Digite um numero entre 2 e 3");
                                        }
                                    }
                                }
                                finally{}
                                try{
                                    if(tipo == TipoDeJogador.COMUM){
                                        System.out.println("Selecione o tipo de jogador da peça " + cor + ":(1=Azarado/3=Sortudo)");
                                        int z = sc.nextInt();
                                        if(z == 1){
                                            jogadores.add(JogadorFactory.newJogador(TipoDeJogador.AZARADO, cor));
                                            teste2 = false;
                                            teste1 = false;
                                        }
                                        else if(z == 3){
                                            jogadores.add(JogadorFactory.newJogador(TipoDeJogador.SORTUDO, cor));
                                            teste2 = false;
                                            teste1 = false;
                                        }
                                        else{
                                            throw new InvalidNumberException("Digite um numero entre 1 e 3");
                                        }
                                    }
                                }
                                finally{}
                                try{
                                    if(tipo == TipoDeJogador.SORTUDO){
                                        System.out.println("Selecione o tipo de jogador da peça " + cor + ":(1=Azarado/2=Comum)");
                                        int z = sc.nextInt();
                                        if(z == 1){
                                            jogadores.add(JogadorFactory.newJogador(TipoDeJogador.AZARADO, cor));
                                            teste2 = false;
                                            teste1 = false;
                                        }
                                        else if(z == 2){
                                            jogadores.add(JogadorFactory.newJogador(TipoDeJogador.COMUM, cor));
                                            teste2 = false;
                                            teste1 = false;
                                        }
                                        else{
                                            throw new InvalidNumberException("Digite um numero entre 1 e 2");
                                        }
                                    }
                                }
                                finally{}
                            }
                        }
                        else{
                            System.out.println("Selecione o tipo de jogador da peça " + cor + ":(1=Azarado/2=Comum/3=Sortudo)");
                            int i = sc.nextInt();
                            if(i == 1){
                                jogadores.add(JogadorFactory.newJogador(TipoDeJogador.AZARADO, cor));
                                teste1 = false;
                            }
                            else if(i == 2){
                                jogadores.add(JogadorFactory.newJogador(TipoDeJogador.COMUM, cor));
                                teste1 = false;
                            }
                            else if(i == 3){
                                jogadores.add(JogadorFactory.newJogador(TipoDeJogador.SORTUDO, cor));
                                teste1 = false;
                            }
                            else{
                                throw new InvalidNumberException("Digite um número entre 1 e 3 para selecionar o tipo!");
                            }
                        }
                    }
                    else{
                        System.out.println("Selecione o tipo de jogador da peça " + cor + ":(1=Azarado/2=Comum/3=Sortudo)");
                        int i = sc.nextInt();
                        if(i == 1){
                            jogadores.add(JogadorFactory.newJogador(TipoDeJogador.AZARADO, cor));
                            teste1 = false;
                        }
                        else if(i == 2){
                            jogadores.add(JogadorFactory.newJogador(TipoDeJogador.COMUM, cor));
                            teste1 = false;
                        }
                        else if(i == 3){
                            jogadores.add(JogadorFactory.newJogador(TipoDeJogador.SORTUDO, cor));
                            teste1 = false;
                        }
                        else{
                            throw new InvalidNumberException("Digite um número entre 1 e 3 para selecionar o tipo!");
                        }
                        j++;
                    }
                }   
                catch(InputMismatchException e){
                    System.out.println("Digite um número!");
                    sc.nextLine();
                } 
                catch(InvalidNumberException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        return jogadores;

    }

    private List<String> selecionarJogadores(){
        List<String> cores = new ArrayList<>();
        List<String> coresSelecionadas = new ArrayList<>();
        boolean teste = false, teste2 = false;
        int i = 0,  n = 0;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        cores.add("Vermelho");
        cores.add("Branco");
        cores.add("Preto");
        cores.add("Azul");
        cores.add("Verde");
        cores.add("Amarelo");
        while(teste == false){
            try{
                System.out.println("Quantos jogadores irão jogar?");
                n = sc.nextInt();
                if(n > 6 || n < 2){
                    throw new InvalidNumberException("O número de jogadores deve ser entre 2 e seis jogadores");
                }
                teste = true;
            }
            catch(InputMismatchException e){
                System.out.println("Digite um número!");
                sc.nextLine();
            }
            catch(InvalidNumberException e){
                System.out.println(e.getMessage());
            }
        }    
        while(teste2 == false){
            try{
                while(n != i){
                    System.out.println("Selecione o número de uma das cores disponíveis:");
                    System.out.println(cores);
                    for(String cor : cores){
                        System.out.print(cores.indexOf(cor) + 1 + " ");
                    }
                    System.out.println(" ");
                    int c = sc.nextInt();
                    coresSelecionadas.add(cores.get(c-1));
                    cores.remove(c-1);
                    i++;
                }
            teste2 = true;
            }
            catch(InputMismatchException e){
                System.out.println("Digite um número!");
                sc.nextLine();
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Digite um valor válido");
            }
        }    
        return coresSelecionadas;
    }

    public void rodarJogo(){
        Tabuleiro t = criarTabuleiro();
        List<String> cores = new ArrayList<>();
        List<Jogador> jogadores = new ArrayList<>();
        boolean encerrar = false;
        Scanner sc = new Scanner(System.in);
        try{
            cores = selecionarJogadores();
            inicializarTabuleiro(cores, t);
            jogadores = instanciarJogadores(cores);
            for(Jogador j : jogadores){
                j.casa = 0;
            }
            while(encerrar == false){
                for(Jogador j : jogadores){
                    printTabuleiro(t, jogadores);
                    System.out.println("Vez do jogador de peça " + j.getCor());
                    sc.nextLine();
                    j.JogarDados();
                    j.Andar();
                    System.out.println(j.somaDados());
                }
            }
        }
        finally{}
    }
    
    
}
