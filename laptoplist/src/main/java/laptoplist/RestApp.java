package laptoplist;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

// if mapped to '/', all static files won't be served by JBoss
@ApplicationPath("/api")
public class RestApp extends Application{

}
