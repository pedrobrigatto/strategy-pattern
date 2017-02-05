package br.com.devmedia.pedrobrigatto.microartigos.strategy.exceptions;

public class BaseException extends Exception {

	private static final long serialVersionUID = -2554694497315846405L;
	private static final Integer DEFAULT_ERROR_CODE = 1;
	
	private Integer exitCode = DEFAULT_ERROR_CODE;

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(String message) {
		super(message);
	}

	public Integer getExitCode() {
		return exitCode;
	}

	public void setExitCode(Integer exitCode) {
		this.exitCode = exitCode;
	}
}
