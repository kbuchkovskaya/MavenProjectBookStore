package bookStore.utils.database;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ValuesForDatabase {

    private final static Logger LOGGER = Logger.getLogger(ValuesForDatabase.class);

    public String getDatabaseProperties(String key){

        Properties properties = new Properties();
        FileInputStream fileInputStream;

        try {

            fileInputStream = new FileInputStream(DatabasePropertiesPath.DATABASE_PROP_PATH);
            properties.load(fileInputStream);

            fileInputStream.close();

            return properties.getProperty(key);

        } catch (IOException e){
            LOGGER.error(e.getMessage());
        }

        return "default";

    }



}
