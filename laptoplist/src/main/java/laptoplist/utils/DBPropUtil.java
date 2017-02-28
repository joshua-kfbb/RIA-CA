package laptoplist.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBPropUtil {
	private  Properties props;

	public DBPropUtil() throws IOException {
		this.props=new Properties();
		InputStream inputStream=getClass().getClassLoader().getResourceAsStream("db.properties");
		if(inputStream!=null){
			props.load(inputStream);
		}
	}
	
	public  String getProperty(String prop){
		return props.getProperty(prop);
	}
}
