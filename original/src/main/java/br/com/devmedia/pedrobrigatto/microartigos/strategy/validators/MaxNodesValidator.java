package br.com.devmedia.pedrobrigatto.microartigos.strategy.validators;

import br.com.devmedia.pedrobrigatto.microartigos.strategy.exceptions.ValidationException;

public class MaxNodesValidator extends BaseValidator {
	
	private static final Integer MIN_NODES_ALLOWED = 1;
	private static final Integer MAX_NODES_ALLOWED = 3;

	@Override
	public void validate(String input) throws ValidationException {
		super.validate(input);
		if (Integer.parseInt(input) < MIN_NODES_ALLOWED || Integer.parseInt(input) > MAX_NODES_ALLOWED) {
			throw new ValidationException("o número de nós configurados para a solução não deve "
					+ "ser menor que " + MIN_NODES_ALLOWED + " nem exceder " + MAX_NODES_ALLOWED);
		}
	}
}
