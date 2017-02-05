package br.com.devmedia.pedrobrigatto.microartigos.strategy.commands;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

import br.com.devmedia.pedrobrigatto.microartigos.strategy.exceptions.CommandException;
import br.com.devmedia.pedrobrigatto.microartigos.strategy.exceptions.ValidationException;
import br.com.devmedia.pedrobrigatto.microartigos.strategy.model.Property;
import br.com.devmedia.pedrobrigatto.microartigos.strategy.model.PropertyAlias;
import br.com.devmedia.pedrobrigatto.microartigos.strategy.validators.ValidationMapper;

public class NodeConfigurationManager {

	private static final Logger LOGGER = 
			Logger.getLogger(NodeConfigurationManager.class);
	private static final String PROPS_LOCATION = 
			System.getProperty(PropertyAlias.PROPS_LOCATION.getValue());

	private static NodeConfigurationManager manager;
	private static Properties properties;

	private NodeConfigurationManager () {}

	public static NodeConfigurationManager getManager() throws IOException {
		if (manager == null) {
			manager = new NodeConfigurationManager();
			loadProperties();
		}
		return manager;
	}

	public static void applyChanges (Property property) throws CommandException {
		try {
			validateInput(property);
			LOGGER.info("arquivo de propriedade localizado em " + PROPS_LOCATION);
			PropertiesConfiguration propsConfiguration = 
					new PropertiesConfiguration(PROPS_LOCATION);
			propsConfiguration.setProperty(PropertyAlias.valueOf(
					property.getName()).getValue(), property.getValue());
			propsConfiguration.save();
		} catch (ValidationException e) {
			throw new CommandException("o valor inserido para "
					+ "esta propriedade é inválido", e);
		} catch (ConfigurationException e) {
			throw new CommandException("não foi possível salvar a propriedade " + 
					property.getName() + " no sistema", e);
		}
	}

	private static void validateInput(Property property) 
			throws CommandException, ValidationException {
		try {
			ValidationMapper.valueOf(property.getName()).
			    getValidatorType().newInstance().validate(property.getValue());
		} catch (InstantiationException | IllegalAccessException e) {
			LOGGER.info("não foi possível identificar um "
					+ "validador para a propriedade " + property.getName());
		}
	}

	private static void loadProperties() throws IOException {
		FileInputStream propertiesStream = new FileInputStream(PROPS_LOCATION);
		properties = new Properties();
		properties.load(propertiesStream);
	}
}
