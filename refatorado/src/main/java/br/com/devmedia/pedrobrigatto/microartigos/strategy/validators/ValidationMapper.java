package br.com.devmedia.pedrobrigatto.microartigos.strategy.validators;

/**
 * Mapeamento dos validadores associados a cada uma das propriedades suportadas pela aplicação.
 */
public enum ValidationMapper {
	
	INPUT_HOST ("HOST", IpAddressValidator.class),
	INPUT_LOGGING_ENABLED ("ENABLE-LOG", BooleanValidator.class),
	INPUT_SERVERS_COUNT ("SERVERS", MaxNodesValidator.class);
	
	private Class<? extends Validator> validatorType;
	private String alias;
	
	ValidationMapper (String alias, Class<? extends Validator> validatorType) {
		this.alias = alias;
		this.validatorType = validatorType;
	}

	public Class<? extends Validator> getValidatorType() {
		return validatorType;
	}

	public String getAlias() {
		return alias;
	}
}
