package br.com.devmedia.pedrobrigatto.microartigos.strategy.validators;

import br.com.devmedia.pedrobrigatto.microartigos.strategy.exceptions.ValidationException;

public class BooleanValidator extends BaseValidator {
	
	@Override
	public void validate(String input) throws ValidationException {
		super.validate(input);
		if (Boolean.FALSE.toString().equalsIgnoreCase(input) || 
				Boolean.TRUE.toString().equalsIgnoreCase(input)) {
			throw new ValidationException("o dado informado não corresponde a um valor booleano");
		}
	}
}
