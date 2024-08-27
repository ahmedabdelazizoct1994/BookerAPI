package properties_reading;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

    private static final String booksConfigPath = "./resources/books-config.properties";

    private static final String dataConfigPath = "./resources/data-config.properties";

    public static Properties setEnvironmentProperties() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(booksConfigPath);
        configProperties.load(inputStream);
        return configProperties;
    }

    public static Properties setBooksData() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(dataConfigPath);
        configProperties.load(inputStream);
        return configProperties;
    }
}