
package DataService.Despachadores.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConectaDB {
    
    
    
    public static Connection conectar(){
        Connection cn = null;
        try {
            String ruta = "com.mysql.jdbc.Driver";
            Class.forName(ruta);
            cn = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/bdproductos", "root","1234");
//            if(cn!=null){
//                JOptionPane.showMessageDialog(null, ":)");
//            }
//            else{
//                JOptionPane.showMessageDialog(null, ":(");
//            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en el metodo conectar:" + e.getMessage());
        }
        
        return cn;
    }
    
    
}
