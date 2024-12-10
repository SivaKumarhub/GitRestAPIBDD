package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {

	public String getValue(String key) throws IOException {
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\aetig\\eclipse-workspace\\Rest API Work Space\\RestAPITesting\\Resources\\global.properties");
	prop.load(fis);
	return prop.getProperty(key);
	
	}
}
