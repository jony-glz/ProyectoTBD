package pckg;
import java.sql.*;

public class Conexion {
    Connection conexion;
    
    public boolean conectar(){
        String wallet = System.getProperty("user.dir")+"\\src\\pckg\\Wallet_Proyecto";
        String url = "jdbc:oracle:thin:@proyecto_high";
        
        try{
            System.setProperty("oracle.net.tns_admin", wallet);
            conexion = DriverManager.getConnection(url, "ADMIN", "GonzalezRamos596365");
            
            if (conexion != null && !conexion.isClosed()) {
                System.out.println("Conexion exitosa");
                return true;
            }
        } catch (Exception ex){
            System.err.println("Error en la conexion: "+ex.toString());
        }
        return false;
    }

    public boolean desconectar(){
        try{
           if (conexion!=null && !conexion.isClosed()) {
            conexion.close();
            System.out.println("Desconexion exitosa");
            return true;
        } 
        } catch (Exception ex){
            System.err.println("Error en la desconexion: "+ex.toString());
        }
        return false;
    }
}
