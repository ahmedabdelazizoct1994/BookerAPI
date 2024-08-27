package books_apis;

import properties_reading.ReadPropertiesFile;

import java.io.IOException;
import java.util.Properties;

public class BaseAPI {


    protected static Properties environmentProperties;
    protected static Properties booksDataProperties;

    public String BASE_URL_BOOKS;

    public BaseAPI() throws IOException {
        environmentProperties = ReadPropertiesFile.setEnvironmentProperties();
        booksDataProperties = ReadPropertiesFile.setBooksData();
        BASE_URL_BOOKS = environmentProperties.getProperty("BASE_URL_FOR_BOOKS");
    }
}