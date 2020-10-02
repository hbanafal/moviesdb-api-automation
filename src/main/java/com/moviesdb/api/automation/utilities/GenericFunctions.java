package com.moviesdb.api.automation.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GenericFunctions {

    public static Properties prop;

    public static Properties getConfigProperties() {
        try (InputStream is = GenericFunctions.class.getResource("/config.properties").openStream()) {
            prop = new Properties();
            prop.load(is);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return prop;
    }

}
