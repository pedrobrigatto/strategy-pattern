package br.com.devmedia.pedrobrigatto.microartigos.strategy;

import java.util.Scanner;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;

import br.com.devmedia.pedrobrigatto.microartigos.strategy.commands.NodeConfigurationManager;
import br.com.devmedia.pedrobrigatto.microartigos.strategy.exceptions.CommandException;
import br.com.devmedia.pedrobrigatto.microartigos.strategy.model.Property;

public class Main {
	
	private static final Scanner INPUT_READER = new Scanner(System.in);
	private static final Logger LOGGER = Logger.getLogger(Main.class);
	
	private static Boolean movingOn = true;

	public static void main(String[] args) {
		printInstructions();
		
		while (movingOn) {
			try {
				askForNextJob();
			} catch (CommandException | ConfigurationException e) {
				LOGGER.debug("Ooops, falha no comando atual ... abortando o programa ...", e);
				movingOn = false;
			}
		}	
	}
	
	private static void printInstructions() {
		LOGGER.info("=======================================================================");
		LOGGER.info("Bem vindo ao aplicativo de configuração DevMedia");
		LOGGER.info("Comandos disponíveis no momento:");
		LOGGER.info("\t--prop <prop_name> --set <valor>");
		LOGGER.info("\nPropriedades suportadas pela aplicação, primeira versão:");
		LOGGER.info("\thost       - endereço IP do host que está sendo configurado");
		LOGGER.info("\tenable-log - flag que indica se o log deve ser habilitado");
		LOGGER.info("\tservers    - indica o total de nós do cluster ");
		LOGGER.info("=======================================================================");
	}
	
	private static void askForNextJob() throws CommandException, ConfigurationException {
		LOGGER.info("E agora, que propriedade alteraremos?");
		String propertyName = INPUT_READER.next();
		LOGGER.info("Ótimo, vamos lá. E que valor ela deve ter a partir de agora?");
		String propertyValue = INPUT_READER.next();
		
		try {
			NodeConfigurationManager.applyChanges(new Property(propertyName, propertyValue));
		} catch (CommandException e) {
			LOGGER.debug("Oooooops, a propriedade não pôde ser alterada, e o programa será abortado", e);
		}
	}
}
