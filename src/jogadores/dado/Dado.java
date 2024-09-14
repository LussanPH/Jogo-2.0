package jogadores.dado;
import exceptions.InvalidFaceException;
import java.util.Random;

public class Dado {
	Random dado = new Random();
	private int face;
	
	public Dado() {
		face = 1;
	}
	
	public int JogarDado() {
		face = dado.nextInt(6) + 1;
		return face;
	}
	
	public int getFace(){
		return face;
	}
	public void setFace(int face) throws InvalidFaceException{
		if (face > 0 && face < 7) {
			this.face = face;
		}else {
			throw new InvalidFaceException("Face must be beetween [1,6]");
		}
	}
}
