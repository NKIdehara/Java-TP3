package exceptions;

public class SalaInvalidaException extends Exception {
	private static final long serialVersionUID = 1L;

	public SalaInvalidaException(String mensagem) {
		super(mensagem);
	}
}