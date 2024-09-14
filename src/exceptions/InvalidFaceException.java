package exceptions;

public class InvalidFaceException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public InvalidFaceException(String message) {
		super(message);
	}

}
