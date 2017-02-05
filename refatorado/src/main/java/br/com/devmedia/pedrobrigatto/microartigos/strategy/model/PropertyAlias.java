package br.com.devmedia.pedrobrigatto.microartigos.strategy.model;

/**
 * Mapeamento das propriedades suportadas pela aplicação.
 */
public enum PropertyAlias {
	
	PROPS_LOCATION ("props.location", "props.location"), 
	INPUT_HOST ("HOST", "HOST.ADDRESS"), 
	LOGGING_ENABLED ("ENABLE-LOG", "LOGGING.ENABLED"),
	SERVERS_COUNT ("SERVERS", "SERVERS.COUNT");
	
	private String alias;
	private String value;
	
	PropertyAlias (String alias, String value) {
		this.alias = alias;
		this.value = value;
	}
	
	public String getAlias () {
		return this.alias;
	}
	
	public String getValue () {
		return this.value;
	}
}
