
package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author JCANALES
 */
public class connectionbd {
    
    public static Connection cnnx = null;
    
    public static Connection conectar() throws Exception {
        try {
            String user = "sa";
            String pass = "root";
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=dbServisoft";
            Class.forName(driver).newInstance();
            cnnx = DriverManager.getConnection(url, user, pass);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error de conexión!!!");
            System.out.println("Error conexión " + e.getMessage());
        }
        return cnnx;
    }
    
    public void cerrar() throws Exception {
        if(cnnx != null){
            cnnx.close();
        }
    }
    
    public static void main(String[] args) throws Exception{
        
        conectar();
        if(cnnx != null){
            System.out.println("Ya estamos conectados a Servisoft!!!");
        }else{
            System.out.println("Aún no tenemos conexión con Servisoft");
        }
        
    }
}
