package br.com.devmedia.pedrobrigatto.microartigos.strategy.validators;

import java.util.regex.Pattern;

import br.com.devmedia.pedrobrigatto.microartigos.strategy.exceptions.ValidationException;

public class IpAddressValidator extends BaseValidator {
	
	private static final String IP_REGEX = "\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}\\b";

	@Override
	public void validate(String input) throws ValidationException {
		super.validate(input);
		
		if (!Pattern.compile(IP_REGEX).matcher(input).matches()) {
			throw new ValidationException("o valor informado não corresponde a um endereço IP válido");
		}
	}
}
