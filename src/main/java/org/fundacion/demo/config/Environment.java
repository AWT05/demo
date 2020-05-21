package org.fundacion.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Reads environment properties.
 */
public final class Environment {

    private static final Logger LOGGER = LoggerFactory.getLogger(Environment.class);
    private static final String ENVIRONMENT = "environmentName";
    private static final String FILTER_TAGS = "filterTags";
    private static final String PROPERTIES_FILE_PATH = "gradle.properties";
    private static final String JSON_CONFIG_FILE_PATH = "config.json";
    private static final String BASE_URI = "baseUri";
    private static final String ACCOUNTS = "accounts";
    private static final String USER_NAME = "userName";
    private static final String ROOT_PATH = ".";
    private static Environment instance;

    private final Properties properties;
    private Map<String, Object> envConfig;

    /**
     * Initializes instance of PropertiesUtils class.
     */
    private Environment() {
        List<Map<String, Object>> environments;
        try (FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties = new Properties();
            properties.load(fileInputStream);
//            environments = JsonPath.with(Files.readString(Paths.get(JSON_CONFIG_FILE_PATH), StandardCharsets.UTF_8))
//                    .getList(ROOT_PATH);
        } catch (IOException e) {
            String message = "Environment config file not found.";
            LOGGER.error(message);
            LOGGER.info(message, e);
            throw new RuntimeException(message, e);
        }
//        envConfig = environments.stream().filter(env -> env.get(ENVIRONMENT_NAME).equals(getEnvironmentName()))
//                .findFirst().orElse(new HashMap<>());
    }

    /**
     * Gets singleton instance of the EnvironmentReader class.
     *
     * @return EnvironmentReader instance.
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
     * Gets environment name property.
     *
     * @return environment name.
     */
    public String getEnvironmentName() {
        return getEnvProperty(ENVIRONMENT);
    }

    /**
     * Gets filter tags property.
     *
     * @return filter tags property.
     */
    public String getFilterTags() {
        return getEnvProperty(FILTER_TAGS);
    }

    /**
     * Gets environment base URI.
     *
     * @return environment base URI.
     */
    public String getBaseUri() {
        return envConfig.get(BASE_URI).toString();
    }

    /**
     * Gets account from environment config.
     *
     * @param username account username.
     * @return account json path object.
     */
    @SuppressWarnings("unchecked")
    public Map<String, String> getAccount(final String username) {
        List<Map<String, String>> accounts = (List<Map<String, String>>) envConfig.get(ACCOUNTS);
        return accounts.stream().filter(account -> account.get(USER_NAME).equals(username))
                .findFirst().orElse(new HashMap<>());
    }

/*    public static Map<String, String> convertToMap(final String content) {
        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();
        try {
            json = (JSONObject) parser.parse(content);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return json;
    }*/
}
