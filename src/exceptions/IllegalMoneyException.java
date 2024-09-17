package exceptions;


public class IllegalMoneyException extends Exception{
    private static final long serialVersionUID = 1L;
    
    public IllegalMoneyException(){
        super("Número de moedas tem que ser maior ou igual a 0");
    }
}    
