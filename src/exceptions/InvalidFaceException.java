package exceptions;

public class InvalidFaceException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public InvalidFaceException() {
		super("Face do dado deve estar entre [1,6]");
	}

}
