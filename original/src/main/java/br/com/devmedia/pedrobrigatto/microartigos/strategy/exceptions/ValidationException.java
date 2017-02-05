package br.com.devmedia.pedrobrigatto.microartigos.strategy.exceptions;

/**
 * Representa qualquer problema relacionado à validação de dados de entrada quando na configuração 
 * de um arquivo de propriedades.
 * 
 * @author pedrobrigatto
 */
public class ValidationException extends BaseException {

	private static final long serialVersionUID = -8573504064723457093L;
	
	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}
}
