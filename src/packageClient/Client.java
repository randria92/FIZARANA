
package packageClient;
import java.sql.Date;

public class Client  {
    private String civilite;
    private String nom;
    private String prenom;
    protected java.util.Date datenaissance;
    private String societeClient;
    private String telephoneClient;
    private String emailClient;
    private String motdepasseClient;
    private Date dateadhesionClient;
    private Date datefinadhesionClient;
    private String commentaireClient;
    private int statusClient;
    private int statusconnexionClient;
    private int idClient;

    public String getCivilite() {
        return civilite;
    }
    
    public int getIdClient() {
        return idClient;
    }

    public Client(String civilite, String nom, String prenom) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client(int idClient,String civilite, String nom, String prenom) {
        this.idClient = idClient;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        
    }
    
    public Client(int idClient,String nom, String prenom ) {
        this.nom = nom;
        this.prenom = prenom;
        this.idClient = idClient;
    }

    
    
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
    public Client() {
    }


}
