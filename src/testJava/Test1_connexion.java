package testJava;
import connexion.Connexion;
import java.sql.SQLException;
import packageClient.Individu;

public class Test1_connexion {
    public static void main(String[] args) throws SQLException {
        test2();
    } 
    //-------------------test1
    static void  test1(){
        Connexion c = new Connexion();
        c.seConnecter();
    }
    //-------------------test2
    static void  test2() throws SQLException{
        Connexion c = new Connexion();
        c.seConnecter();
       Individu ind01=new Individu();
       ind01.lister();
    }
}
