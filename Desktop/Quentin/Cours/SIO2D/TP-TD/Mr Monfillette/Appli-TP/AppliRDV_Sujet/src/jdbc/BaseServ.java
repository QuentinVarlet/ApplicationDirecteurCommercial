package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseServ {
    
   private static final String     URL                   = "jdbc:derby://localhost:1527/baseRDV";
   private static final String     UTILISATEUR    =  "rdv";
   private static final String     MOTDEPASSE    =  "slam";
        
   private static   Connection   connexion;

   static {
       
        try {
                 DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());    
                 connexion =    DriverManager.getConnection(URL, UTILISATEUR, MOTDEPASSE); 
                 System.out.println("\nConnexion OK\n");
                  
        } catch (SQLException ex) {
                  
                  Logger.getLogger(BaseServ.class.getName()).log(Level.SEVERE, "Erreur de Connexion", ex);
        }
    }

   public static Connection getConnexion() {
        return connexion;
   }
     
}
