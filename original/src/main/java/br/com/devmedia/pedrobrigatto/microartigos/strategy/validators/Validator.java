package br.com.devmedia.pedrobrigatto.microartigos.strategy.validators;

import br.com.devmedia.pedrobrigatto.microartigos.strategy.exceptions.ValidationException;

/**
 * Representa o padrão que deve ser seguido por todo e qualquer validador de dados de entrada da 
 * aplicação. 
 * 
 * @author pedrobrigatto
 */
public interface Validator {
	
	/**
	 * Valida um determinado dado de entradainformado na execução da aplicação. 
	 * 
	 * @param input dado a ser validado
	 * 
	 * @throws ValidationException caso a validação encontre inconsistência no dado informado
	 */
	void validate (String input) throws ValidationException;
}
