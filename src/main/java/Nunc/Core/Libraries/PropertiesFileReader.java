package Nunc.Core.Libraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
	
	public Properties getProperty(String path) throws IOException
	{
		Properties properties = new Properties();
        try {  
        	properties.load(new FileInputStream(path));
           // properties.load(new FileInputStream("resources/browser-config.properties"));
          //  properties.load(new FileInputStream("resources/testdata-config.properties"));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
       } 
         return properties;	
	}

}
