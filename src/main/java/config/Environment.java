package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Environment {
    private static final String FILE_NOT_FOUND_MESSAGE = "Environment config file not found";
    private static final String IO_EXCEPTION_MESSAGE = "Input/Output exception, failed to load gradle.properties";
    private static final String BASE_URL = "baseUrl";
    private static final String USER_NAME = "userName";
    private static final String USER_PASSWORD = "password";
    private static final String IMPLICIT_TIME_WAIT = "implicitTimeWait";
    private static final String EXPLICIT_TIME_WAIT = "explicitTimeWait";
    private static Environment instance;
    private Properties properties;

    private Environment() {
        try (FileInputStream fileInputStream = new FileInputStream("gradle.properties")) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(FILE_NOT_FOUND_MESSAGE);
        } catch (IOException e) {
            throw new RuntimeException(IO_EXCEPTION_MESSAGE);
        }
    }

    public static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
        }
        return instance;
    }

    private String getEnvProperty(final String nameProperty) {
        String property = System.getProperty(nameProperty);
        if (property == null) {
            return properties.getProperty(nameProperty);
        }
        return property;
    }

    public String getBaseUrl() {
        return getEnvProperty(BASE_URL);
    }

    public String getUserName() {
        return getEnvProperty(USER_NAME);
    }

    public String getPassword() {
        return getEnvProperty(USER_PASSWORD);
    }

    public int getImplicitTimeWait() {
        return Integer.parseInt(getEnvProperty(IMPLICIT_TIME_WAIT));
    }

    public int getExplicitTimeWait() {
        return Integer.parseInt(getEnvProperty(EXPLICIT_TIME_WAIT));
    }
}
