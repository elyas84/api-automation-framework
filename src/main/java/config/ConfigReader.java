package config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Logger logger = LogManager.getLogger(ConfigReader.class.getName());
    public static Properties properties;

    static {
        try {
            logger.info("Loading properties file [{}] ", System.getProperty("configFile"));
            String path = AppData.configFile;
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (Exception e) {
            logger.error("Failed to load properties file");
        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }
}
