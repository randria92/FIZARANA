
package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    
    public void seConnecter(){
        try {
            // charger le driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("1) erreur de chargement du driver");
            ex.printStackTrace();
            System.exit(0);            
        }
        
        // code depuis java 7
        // informations de connexion
        String url = "jdbc:sqlserver://localhost;databaseName=Librairie;";
        String user = "sa";
        String mdp = "sa";
        try (Connection cnt = DriverManager.getConnection(url, user, mdp);) {
            System.out.println("connexion réussie!!!!");
        } catch (SQLException ex) {
            System.out.println("2) erreur sur la connexion PAS DE BASE");
            ex.printStackTrace();
        } 
    }
}
