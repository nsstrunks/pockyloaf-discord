package com.nessynet.discord.pockyloaf.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by nss on 6/3/2016.
 */
public class PropertyHelper {

    private static final Logger logger = LoggerFactory.getLogger(PropertyHelper.class);

    private static PropertyHelper instance = new PropertyHelper();

    private Properties prop;

    private PropertyHelper() {
        prop = new Properties();
        String propFileName = "settings.prop";
        loadProperties(propFileName);
    }

    public static PropertyHelper getInstance() {
        return instance;
    }

    private void loadProperties(String propFile) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFile);
        try {
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new IOException("Input stream is null");
            }
        } catch (IOException e) {
            logger.error("Properties file not found: {}",propFile,e);
        }
    }

    public String getProperty(String propertyName) {
        return prop.getProperty(propertyName);
    }
}
