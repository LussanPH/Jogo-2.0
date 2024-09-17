package main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import casa.Casa;
import casa.CasaAzar;
import casa.CasaJogaDeNovo;
import casa.CasaPrisao;
import casa.CasaReversa;
import casa.CasaSimples;
import casa.CasaSorte;
import casa.CasaSurpresa;
import casa.CasaTroca;
import casa.TipoDeCasa;
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
            System.out.println("Cor: " + j.getCor() + ", Tipo: " + j.getTipo() + ", Moedas: " + j.getMoedas() + ", Casa: " + (j.casa + 1) + ", Rodada: " + j.getRodadasJogadas());
        }
    }

    private void inicializarTabuleiro(List<String> cores, Tabuleiro t){
        for(String cor : cores){
            t.setCores(cor, 0);
        }
    }

    private List<Jogador> instanciarJogadores(List<String> cores){
        @SuppressWarnings("resource")
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
                            System.out.println(tipo);
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

    private List<Casa> instanciarCasas(Tabuleiro t){
        List<Integer> casas = new ArrayList<>();
        List<Casa> casasTabuleiro = new ArrayList<>();
        int i = 1;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        boolean teste1 = true;
        for(@SuppressWarnings("unused") List<String> casa : t.getCasas()){
            casas.add(i);
            casasTabuleiro.add(new CasaSimples(i));
            i++;
        }
        while(teste1 == true){
            teste1 = false;
            try{
                System.out.println("Escolha quantas casas serão azaradas: ");
                int a = sc.nextInt();
                sc.nextLine();
                if(a > casas.size() || a < 0){
                    throw new InvalidNumberException("Digite uma quantidade válida!");
                }
                else if(a == 0){
                    continue;
                }
                else{
                    try{
                        System.out.println("Quais?(Digite o número da(s) casa(s) que deseja selecionar separada(s) por espaço)");
                        System.out.println("Casas disponíveis: " + casas);
                        String c = sc.nextLine();
                        String[] c2 = c.split(" ");
                        int[] numeros = new int[c2.length];
                        for(i = 0; i < numeros.length; i++){
                            numeros[i] = Integer.parseInt(c2[i]);
                        }
                        for(int num : numeros){
                            if(!casas.contains(num)){
                                throw new InvalidNumberException("Número(s) não disponível(is) no tabuleiuro!");
                            }
                            casas.remove(Integer.valueOf(num));
                            casasTabuleiro.remove(num-1);
                            casasTabuleiro.add(num-1, new CasaAzar(num-1));
                        }
                    }
                    catch(InvalidNumberException e){
                        System.out.println(e.getMessage());
                        teste1 = true;
                    }
                    catch(NumberFormatException e){
                        System.out.println("Digite um número!");
                        teste1 = true;
                    }
                }
            }
            catch(InvalidNumberException e){
                System.out.println(e.getMessage());
                teste1 = true;
            }
            catch(InputMismatchException e){
                System.out.println("Digite um número!");
                teste1 = true;
            }
        }
        teste1 = true;
        while(teste1 == true){
            teste1 = false;
            try{
                System.out.println("Escolha quantas casas serão sorte: ");
                int a = sc.nextInt();
                sc.nextLine();
                if(a > casas.size() || a < 0){
                    throw new InvalidNumberException("Digite uma quantidade válida!");
                }
                else if(a == 0){
                    continue;
                }
                else{
                    try{
                        System.out.println("Quais?(Digite o número da(s) casa(s) que deseja selecionar separada(s) por espaço)");
                        System.out.println("Casas disponíveis: " + casas);
                        String c = sc.nextLine();
                        String[] c2 = c.split(" ");
                        int[] numeros = new int[c2.length];
                        for(i = 0; i < numeros.length; i++){
                            numeros[i] = Integer.parseInt(c2[i]);
                        }
                        for(int num : numeros){
                            if(!casas.contains(num)){
                                throw new InvalidNumberException("Número(s) não disponível(is) no tabuleiuro!");
                            }
                            casas.remove(Integer.valueOf(num));
                            casasTabuleiro.remove(num-1);
                            casasTabuleiro.add(num-1, new CasaSorte(num-1));
                        }
                    }
                    catch(InvalidNumberException e){
                        System.out.println(e.getMessage());
                        teste1 = true;
                    }
                    catch(NumberFormatException e){
                        System.out.println("Digite um número!");
                        teste1 = true;
                    }
                }
            }
            catch(InvalidNumberException e){
                System.out.println(e.getMessage());
                teste1 = true;
            }
            catch(InputMismatchException e){
                System.out.println("Digite um número!");
                teste1 = true;
            }
        }
        teste1 = true;
        while(teste1 == true){
            teste1 = false;
            try{
                System.out.println("Escolha quantas casas serão jogar novamente: ");
                int a = sc.nextInt();
                sc.nextLine();
                if(a > casas.size() || a < 0){
                    throw new InvalidNumberException("Digite uma quantidade válida!");
                }
                else if(a == 0){
                    continue;
                }
                else{
                    try{
                        System.out.println("Quais?(Digite o número da(s) casa(s) que deseja selecionar separada(s) por espaço)");
                        System.out.println("Casas disponíveis: " + casas);
                        String c = sc.nextLine();
                        String[] c2 = c.split(" ");
                        int[] numeros = new int[c2.length];
                        for(i = 0; i < numeros.length; i++){
                            numeros[i] = Integer.parseInt(c2[i]);
                        }
                        for(int num : numeros){
                            if(!casas.contains(num)){
                                throw new InvalidNumberException("Número(s) não disponível(is) no tabuleiuro!");
                            }
                            casas.remove(Integer.valueOf(num));
                            casasTabuleiro.remove(num-1);
                            casasTabuleiro.add(num-1, new CasaJogaDeNovo(num-1));
                        }
                    }
                    catch(InvalidNumberException e){
                        System.out.println(e.getMessage());
                        teste1 = true;
                    }
                    catch(NumberFormatException e){
                        System.out.println("Digite um número!");
                        teste1 = true;
                    }
                }
            }
            catch(InvalidNumberException e){
                System.out.println(e.getMessage());
                teste1 = true;
            }
            catch(InputMismatchException e){
                System.out.println("Digite um número!");
                teste1 = true;
            }
        }
        teste1 = true;
        while(teste1 == true){
            teste1 = false;
            try{
                System.out.println("Escolha quantas casas serão prisão: ");
                int a = sc.nextInt();
                sc.nextLine();
                if(a > casas.size() || a < 0){
                    throw new InvalidNumberException("Digite uma quantidade válida!");
                }
                else if(a == 0){
                    continue;
                }
                else{
                    try{
                        System.out.println("Quais?(Digite o número da(s) casa(s) que deseja selecionar separada(s) por espaço)");
                        System.out.println("Casas disponíveis: " + casas);
                        String c = sc.nextLine();
                        String[] c2 = c.split(" ");
                        int[] numeros = new int[c2.length];
                        for(i = 0; i < numeros.length; i++){
                            numeros[i] = Integer.parseInt(c2[i]);
                        }
                        for(int num : numeros){
                            if(!casas.contains(num)){
                                throw new InvalidNumberException("Número(s) não disponível(is) no tabuleiuro!");
                            }
                            casas.remove(Integer.valueOf(num));
                            casasTabuleiro.remove(num-1);
                            casasTabuleiro.add(num-1, new CasaPrisao(num-1));
                        }
                    }
                    catch(InvalidNumberException e){
                        System.out.println(e.getMessage());
                        teste1 = true;
                    }
                    catch(NumberFormatException e){
                        System.out.println("Digite um número!");
                        teste1 = true;
                    }
                }
            }
            catch(InvalidNumberException e){
                System.out.println(e.getMessage());
                teste1 = true;
            }
            catch(InputMismatchException e){
                System.out.println("Digite um número!");
                teste1 = true;
            }
        }
        teste1 = true;
        while(teste1 == true){
            teste1 = false;
            try{
                System.out.println("Escolha quantas casas serão reversas: ");
                int a = sc.nextInt();
                sc.nextLine();
                if(a > casas.size() || a < 0){
                    throw new InvalidNumberException("Digite uma quantidade válida!");
                }
                else if(a == 0){
                    continue;
                }
                else{
                    try{
                        System.out.println("Quais?(Digite o número da(s) casa(s) que deseja selecionar separada(s) por espaço)");
                        System.out.println("Casas disponíveis: " + casas);
                        String c = sc.nextLine();
                        String[] c2 = c.split(" ");
                        int[] numeros = new int[c2.length];
                        for(i = 0; i < numeros.length; i++){
                            numeros[i] = Integer.parseInt(c2[i]);
                        }
                        for(int num : numeros){
                            if(!casas.contains(num)){
                                throw new InvalidNumberException("Número(s) não disponível(is) no tabuleiuro!");
                            }
                            casas.remove(Integer.valueOf(num));
                            casasTabuleiro.remove(num-1);
                            casasTabuleiro.add(num-1, new CasaReversa(num-1));
                        }
                    }
                    catch(InvalidNumberException e){
                        System.out.println(e.getMessage());
                        teste1 = true;
                    }
                    catch(NumberFormatException e){
                        System.out.println("Digite um número!");
                        teste1 = true;
                    }
                }
            }
            catch(InvalidNumberException e){
                System.out.println(e.getMessage());
                teste1 = true;
            }
            catch(InputMismatchException e){
                System.out.println("Digite um número!");
                teste1 = true;
            }
        }
        teste1 = true;
        while(teste1 == true){
            teste1 = false;
            try{
                System.out.println("Escolha quantas casas surpresa: ");
                int a = sc.nextInt();
                sc.nextLine();
                if(a > casas.size() || a < 0){
                    throw new InvalidNumberException("Digite uma quantidade válida!");
                }
                else if(a == 0){
                    continue;
                }
                else{
                    try{
                        System.out.println("Quais?(Digite o número da(s) casa(s) que deseja selecionar separada(s) por espaço)");
                        System.out.println("Casas disponíveis: " + casas);
                        String c = sc.nextLine();
                        String[] c2 = c.split(" ");
                        int[] numeros = new int[c2.length];
                        for(i = 0; i < numeros.length; i++){
                            numeros[i] = Integer.parseInt(c2[i]);
                        }
                        for(int num : numeros){
                            if(!casas.contains(num)){
                                throw new InvalidNumberException("Número(s) não disponível(is) no tabuleiuro!");
                            }
                            casas.remove(Integer.valueOf(num));
                            casasTabuleiro.remove(num-1);
                            casasTabuleiro.add(num-1, new CasaSurpresa(num-1));
                        }
                    }
                    catch(InvalidNumberException e){
                        System.out.println(e.getMessage());
                        teste1 = true;
                    }
                    catch(NumberFormatException e){
                        System.out.println("Digite um número!");
                        teste1 = true;
                    }
                }
            }
            catch(InvalidNumberException e){
                System.out.println(e.getMessage());
                teste1 = true;
            }
            catch(InputMismatchException e){
                System.out.println("Digite um número!");
                teste1 = true;
            }
        }
        teste1 = true;
        while(teste1 == true){
            teste1 = false;
            try{
                System.out.println("Escolha quantas casas serão troca: ");
                int a = sc.nextInt();
                sc.nextLine();
                if(a > casas.size() || a < 0){
                    throw new InvalidNumberException("Digite uma quantidade válida!");
                }
                else if(a == 0){
                    continue;
                }
                else{
                    try{
                        System.out.println("Quais?(Digite o número da(s) casa(s) que deseja selecionar separada(s) por espaço)");
                        System.out.println("Casas disponíveis: " + casas);
                        String c = sc.nextLine();
                        String[] c2 = c.split(" ");
                        int[] numeros = new int[c2.length];
                        for(i = 0; i < numeros.length; i++){
                            numeros[i] = Integer.parseInt(c2[i]);
                        }
                        for(int num : numeros){
                            if(!casas.contains(num)){
                                throw new InvalidNumberException("Número(s) não disponível(is) no tabuleiuro!");
                            }
                            casas.remove(Integer.valueOf(num));
                            casasTabuleiro.remove(num-1);
                            casasTabuleiro.add(num-1, new CasaTroca(num-1));
                        }
                        for(Casa casasas : casasTabuleiro){
                                System.out.println(casasas.tipo);
                        }
                    }
                    catch(InvalidNumberException e){
                        System.out.println(e.getMessage());
                        teste1 = true;
                    }
                    catch(NumberFormatException e){
                        System.out.println("Digite um número!");
                        teste1 = true;
                    }
                }
            }
            catch(InvalidNumberException e){
                System.out.println(e.getMessage());
                teste1 = true;
            }
            catch(InputMismatchException e){
                System.out.println("Digite um número!");
                teste1 = true;
            }
        }
        return casasTabuleiro;
    }

    public void rodarJogo(){
        Tabuleiro t = criarTabuleiro();
        List<String> cores = new ArrayList<>();
        List<Jogador> jogadores = new ArrayList<>();
        List<Casa> casas = new ArrayList<>();
        boolean encerrar = false;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        try{
            cores = selecionarJogadores();
            inicializarTabuleiro(cores, t);
            jogadores = instanciarJogadores(cores);
            casas = instanciarCasas(t);
            for(int i = 0; i<jogadores.size(); i++){
                jogadores.get(i).casa = 0;
                System.out.println("O jogador de peça " + jogadores.get(i).getCor() + " vai ser modo debug?(sim/nao)");
                String d = sc.next();
                if(d.equalsIgnoreCase("sim")){
                    jogadores.get(i).setDebug(true);
                }
                sc.nextLine();

            }
            while(encerrar == false){
                for(int i = 0; i<jogadores.size(); i++){
                    Jogador j = jogadores.get(i);
                    printTabuleiro(t, jogadores);
                    System.out.println("Vez do jogador de peça " + j.getCor() + " pressione Enter");
                    sc.nextLine();
                    if(!j.isPreso()){
                        if(j.getDebug() == true){
                            System.out.println("Digite o número de casas que deseja andar: ");
                            int d = sc.nextInt();
                            sc.nextLine();
                            j.Andar(d);
                        }
                        else{
                            j.JogarDados();
                            j.Andar();
                            System.out.println("Soma dos dados: " + j.somaDados());
                        }
                    }
                    if(j.casa >= 39){
                        encerrar = true;
                        System.out.println("Jogador de peça " + j.getCor() + " ganhou a partida!");
                        printTabuleiro(t, jogadores);
                        break;
                    }
                    if(casas.get(j.casa).tipo == TipoDeCasa.AZAR){
                        j.setRodadasJogadas(j.getRodadasJogadas() + 1);
                        System.out.println("Casa Azarada!");
                        casas.get(j.casa).aplicarRegra(j, jogadores);
                    }
                    else if(casas.get(j.casa).tipo == TipoDeCasa.JOGADENOVO){
                        while(casas.get(j.casa).tipo == TipoDeCasa.JOGADENOVO){
                            j.setRodadasJogadas(j.getRodadasJogadas() + 1);
                            casas.get(j.casa).aplicarRegra(j, jogadores);
                        }
                        if(casas.get(j.casa).tipo == TipoDeCasa.PRISAO){
                            CasaPrisao prisao = new CasaPrisao(j.casa);
                            System.out.println("Jogador foi preso!");
                            System.out.println("Pagar fiança? (2 moedas) (sim/nao): ");
                            String r = sc.next();
                            sc.nextLine();
                            prisao.setResposta(r);
                            prisao.aplicarRegra(j, jogadores);
                        }
                        else if(casas.get(j.casa).tipo == TipoDeCasa.TROCA){
                            CasaTroca troca = new CasaTroca(j.casa);
                            System.out.println("Casa troca!");
                            System.out.println("Deseja realizar uma compra?(sim/não)");
                            String r = sc.next();
                            troca.setResposta(r);
                            String corOriginal = j.getCor();
                            int casaOriginal = j.casa;
                            TipoDeJogador tipoOriginal = j.getTipo();
                            j = troca.aplicarRegra(j, jogadores);
                            boolean bone = j.isBone();
                            boolean moletom = j.isMoletom();
                            boolean oculosEscuros = j.isOculosEscuros();
                            int moedasOriginais = j.getMoedas();
                            j.casa = casaOriginal;
                            if(tipoOriginal == TipoDeJogador.AZARADO){
                                j = new JogadorAzarado(corOriginal);
                            }
                            else if(tipoOriginal == TipoDeJogador.COMUM){
                                j = new JogadorComum(corOriginal);
                            }
                            else{
                                j = new JogadorSortudo(corOriginal);
                            }
                            j.casa = casaOriginal;
                            j.setMoedas(moedasOriginais);
                            j.setBone(bone);
                            j.setMoletom(moletom);
                            j.setOculosEscuros(oculosEscuros);
                            jogadores.set(i, j);
                            sc.nextLine();
                        }
                        else{
                            System.out.println("Casa " + casas.get(j.casa).tipo + "!");
                            casas.get(j.casa).aplicarRegra(j, jogadores);
                        }
                        j.setRodadasJogadas(j.getRodadasJogadas() + 1);
                    }
                    else if(casas.get(j.casa).tipo == TipoDeCasa.PRISAO){
                        CasaPrisao prisao = new CasaPrisao(j.casa);
                        System.out.println("Jogador foi preso!");
                        System.out.println("Pagar fiança? (2 moedas) (sim/nao): ");
                        String r = sc.next();
                        sc.nextLine();
                        prisao.setResposta(r);
                        prisao.aplicarRegra(j, jogadores);
                        if(j.getSentenca() == 2){
                            j.setRodadasJogadas(j.getRodadasJogadas() + 1);
                        }
                        if(!j.isPreso()){
                            if(j.getDebug() == true){
                                System.out.println("Digite o número de casas que deseja andar: ");
                                int d = sc.nextInt();
                                sc.nextLine();
                                j.Andar(d);
                            }
                            else{
                                j.JogarDados();
                                j.Andar();
                                System.out.println("Soma dos dados: " + j.somaDados());
                            }
                            casas.get(j.casa).aplicarRegra(j, jogadores);
                        }
                    }
                    else if(casas.get(j.casa).tipo == TipoDeCasa.REVERSA){
                        j.setRodadasJogadas(j.getRodadasJogadas() + 1);
                        System.out.println("Casa reversa!");
                        casas.get(j.casa).aplicarRegra(j, jogadores);
                    }
                    else if(casas.get(j.casa ).tipo == TipoDeCasa.SIMPLES){
                        j.setRodadasJogadas(j.getRodadasJogadas() + 1);
                        System.out.println("Casa Simples!");
                        casas.get(j.casa).aplicarRegra(j, jogadores);
                    }
                    else if(casas.get(j.casa).tipo == TipoDeCasa.SORTE){
                        j.setRodadasJogadas(j.getRodadasJogadas() + 1);
                        System.out.println("Casa sortuda!");
                        casas.get(j.casa).aplicarRegra(j, jogadores);
                        casas.get(j.casa).aplicarRegra(j, jogadores);
                    }
                    else if(casas.get(j.casa).tipo == TipoDeCasa.SURPRESA){
                        j.setRodadasJogadas(j.getRodadasJogadas() + 1);
                        System.out.println("Casas Surpresa");
                        j = casas.get(j.casa).aplicarRegra(j, jogadores);
                        jogadores.set(i, j);
                    }
                    else if(casas.get(j.casa).tipo == TipoDeCasa.TROCA){
                        j.setRodadasJogadas(j.getRodadasJogadas() + 1);
                        CasaTroca troca = new CasaTroca(j.casa);
                        System.out.println("Casa troca!");
                        System.out.println("Deseja realizar uma compra?(sim/não)");
                        String r = sc.next();
                        troca.setResposta(r);
                        int rodadasJogadasOriginais = j.getRodadasJogadas();
                        boolean debugOriginal = j.getDebug();
                        String corOriginal = j.getCor();
                        int casaOriginal = j.casa;
                        TipoDeJogador tipoOriginal = j.getTipo();
                        j = troca.aplicarRegra(j, jogadores);
                        boolean bone = j.isBone();
                        boolean moletom = j.isMoletom();
                        boolean oculosEscuros = j.isOculosEscuros();
                        int moedasOriginais = j.getMoedas();
                        j.casa = casaOriginal;
                        if(tipoOriginal == TipoDeJogador.AZARADO){
                            j = new JogadorAzarado(corOriginal);
                        }
                        else if(tipoOriginal == TipoDeJogador.COMUM){
                            j = new JogadorComum(corOriginal);
                        }
                        else{
                            j = new JogadorSortudo(corOriginal);
                        }
                        j.casa = casaOriginal;
                        j.setMoedas(moedasOriginais);
                        j.setBone(bone);
                        j.setMoletom(moletom);
                        j.setOculosEscuros(oculosEscuros);
                        j.setRodadasJogadas(rodadasJogadasOriginais);
                        j.setDebug(debugOriginal);
                        jogadores.set(i, j);
                        sc.nextLine();
                    }
                    if(j.casa >= 39){
                        encerrar = true;
                        System.out.println("Jogador de peça " + j.getCor() + " ganhou a partida!");
                        printTabuleiro(t, jogadores);
                        break;
                    }
                }
            }
        }
        finally{}
    }
    
    
}
