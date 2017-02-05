package br.com.devmedia.pedrobrigatto.microartigos.strategy.validators;

import org.apache.commons.lang3.StringUtils;

import br.com.devmedia.pedrobrigatto.microartigos.strategy.exceptions.ValidationException;

public abstract class BaseValidator implements Validator {

	@Override
	public void validate(String input) throws ValidationException {
		if (StringUtils.isEmpty(input)) {
			throw new ValidationException(
					"valor informado é vazio, o que é considerado dado inválido no escopo da solução");
		}
	}

}
