//class for testing methods

import com.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionApp {

    public static void main(String[] args) {

        Connection connection = null;

        try{
            connection = ConnectionConfiguration.getConnection();
            if(connection !=null) {
                System.out.println("Connection established");
            }
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        finally{
            if(connection !=null){
                try{
                    connection.close();
                }
                catch(SQLException exc){
                    exc.printStackTrace();
                }
            }

        }
    }
}
