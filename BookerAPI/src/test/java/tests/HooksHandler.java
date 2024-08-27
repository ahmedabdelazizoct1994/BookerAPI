package tests;


import io.cucumber.java.Before;
import books_apis.BaseAPI;
import properties_reading.ReadPropertiesFile;

import java.io.IOException;


public class HooksHandler extends BaseAPI {
    public HooksHandler() throws IOException {
        super();}
    @Before
    public void setProperties() throws IOException {
        environmentProperties = ReadPropertiesFile.setEnvironmentProperties();
        booksDataProperties =ReadPropertiesFile.setBooksData();
    }
}
