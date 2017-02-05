package br.com.devmedia.pedrobrigatto.microartigos.strategy.exceptions;

public class CommandException extends BaseException {
	
	private static final long serialVersionUID = -8067697619974154793L;

	public CommandException(String message) {
		super(message);
	}
	
	public CommandException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
