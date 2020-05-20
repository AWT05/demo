package org.fundacion.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Environment {
    private static final Logger LOGGER = LoggerFactory.getLogger(Environment.class);
    private static final String BASE_URL = "baseUrl";
    private static final String PROPERTIES_FILE_PATH = "gradle.properties";
    private static Environment instance;
    private Properties properties;

    /**
     * Configures the environment properties from gradle.properties.
     * Initializes an instance of PropertiesUtils class.
     */
    private Environment() {
        try (FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            String message = "Environment config file not found.";
            LOGGER.error(message);
            LOGGER.info(message, e);
            //throw new MissingConfigurationsError(message);
        } catch (IOException e) {
            String message = "Input/Output exception, failed to load gradle.properties";
            LOGGER.error(message);
            LOGGER.info(message, e);
            //throw new MissingConfigurationsError(message);
        }
    }

    /**
     * Gets singleton instance of the Environment class.
     *
     * @return Environment instance.
     */
    public static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
        }
        return instance;
    }

    /**
     * Gets string containing a specific environment property.
     *
     * @param env is the property name string.
     * @return the wanted property value.
     */
    private String getEnvProperty(final String env) {
        String property = System.getProperty(env);
        if (property == null) {
            return properties.getProperty(env);
        }
        return property;
    }

    /**
     * Gets environment base URI.
     *
     * @return environment base URI.
     */
    public String getBaseUri() {
        String baseUri = getEnvProperty(BASE_URL);
        return baseUri;
    }



}