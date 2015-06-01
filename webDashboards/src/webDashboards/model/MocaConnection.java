package webDashboards.model;

import com.redprairie.moca.MocaException;
import com.redprairie.moca.client.ConnectionUtils;
import com.redprairie.moca.client.HttpConnection;

public class MocaConnection {
    
    public static final String SERVICE = "http://172.20.94.38:4650/service";
    public static final String USER = "EDGARG";
    public static final String PASS = "123";
    public HttpConnection conn;
    
    
    public MocaConnection() {
        // TODO Auto-generated constructor stub
        try {
            conn = new HttpConnection(SERVICE);
            ConnectionUtils.login(conn, USER, PASS);
        }
        catch (MocaException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MocaConnection conn = new MocaConnection();
    }

}
