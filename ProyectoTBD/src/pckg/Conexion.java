package pckg;
import java.sql.*;

public class Conexion {
    Connection conexion;
    
    public boolean conectar(){
        String wallet = System.getProperty("user.dir")+"\\src\\pckg\\Wallet_Proyecto";
        String url = "jdbc:oracle:thin@(description=(address_list=(address=(protocol=tcps)(host=adb.us-ashburn-1.oraclecloud.com)(port=1522)))(connect_data=(service=gb56437d6ad9cd9_proyecto_high.adb.oraclecloud.com)))";
        
        try{
            System.setProperty("oracle.net.wallet_location", wallet);
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
}
