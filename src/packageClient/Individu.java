package packageClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public  class  Individu{

 
    private String civilite;
    private String nom;
    private String prenom;
    protected Date datenaissance;

    public Individu(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCivilite() {
        return civilite;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }


    public Individu() {
    }
    public Individu(String civilite,String nom,String prenom) {
    }
    public Individu(String nom,String prenom) {
    }

    public void ajouter() {
        
    }

   
    public void lister() throws SQLException {
        // code depuis java 7
        // informations de connexion
        String url = "jdbc:sqlserver://localhost;databaseName=Librairie;";
        String user = "sa";
        String mdp = "sa";
        
        try (Connection cnt = DriverManager.getConnection(url, user, mdp);
                Statement stm = cnt.createStatement();) {
            String req = "select idClient,nomClient,prenomClient from client";
            ResultSet rs = stm.executeQuery(req);
            System.out.println("req = " + req);
            
            List<Individu> ListIndividu = new ArrayList();
            while(rs.next()){
                 rs.getInt("idClient");                               
                 rs.getString("nomClient");                
                 rs.getString("prenomClient"); 
                
            }
            for(Individu v:ListIndividu){
                System.out.println(v);
            }
            
        }
    }
 
    public void supprimer() {
        
    }

 
    public void modifier() {
        
    }

}
