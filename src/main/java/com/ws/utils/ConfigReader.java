package com.ws.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    /**
     * this method is used to read the properties file
     * @return properties file object
     */
    public Properties init_prop() {
       prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(fis);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;

    }
}
