
package applirdv;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.BaseServ;

public class GereRDV {
    
    Connection       cx=BaseServ.getConnexion();
    
    public String    getType(String nomChamp){
       
        String leType=null;
        
        try {
                 
               ResultSet rs=cx.getMetaData().
                              getColumns(null, null, "RDV",nomChamp.toUpperCase());
             
               if (rs.next()){
                   leType=null;
                   int typecode=rs.getInt(5);
                   switch( typecode){
                       
                       case  1: leType = "C" ;break;
                       case  4: leType = "N" ;break;
                       case  5: leType = "N" ;break;    
                       case 12: leType = "C" ;break;
                       case 91: leType = "D" ;break;    
                   }

           }
        } catch (SQLException ex) {
            Logger.getLogger(GereRDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return leType;
    }
    
    public String    valeurFormatee(String nomChamp, String valeurChamp){
        
             if(getType(nomChamp).equals("N")){
                 return valeurChamp;
             }else{
                 return "'" + valeurChamp + "'";
             }
    }
    
    public int       execSQL_LMD( String requeteSQL){
        
      int n=0;
      try {      
            Statement reqLMD=cx.createStatement();
            reqLMD.execute(requeteSQL);
            n=reqLMD.getUpdateCount();
      } catch (SQLException ex) {
            Logger.getLogger(GereRDV.class.getName()).log(Level.SEVERE, null, ex);
      }
      return n;
    }

    public ResultSet execSQL_QRY( String requeteSQL){
      
      ResultSet rs=null;
      try {
         Statement cmde=cx.createStatement();
         rs=cmde.executeQuery(requeteSQL); 
      } catch (SQLException ex) {
         Logger.getLogger(GereRDV.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      return rs;
    }
    
    public void      supprimer( String numero){
       
       
        String requete = "delete from RDV where numRdv=" + valeurFormatee("numRdv", numero);
        System.out.println("Requete de suppression effectué");
        execSQL_LMD(requete);
        
    }

    public void      ajouter(String numero, Champs champs){
       
       String requete = "insert into RDV values(" + valeurFormatee("numRdv", numero);
       int i;
       for (i=0;i<=champs.getNbChamps()-1;i++){
           String nom = champs.getNom(i);
           String valeur = champs.getValeur(i);
           requete = requete + "," + valeurFormatee(nom, valeur);
       }
       requete = requete + ")";
       System.out.println("Requete d'ajout effectué");
       execSQL_LMD(requete);

       
       
       
    }
    
    public void      modifier(String numero, Champs champs){
    
       String requete = "update from RDV set";
       int i;
       for (i=0;i<=champs.getNbChamps()-1;i++){
           String nom = champs.getNom(i);
           String valeur = champs.getValeur(i);
           if (i==0){
           requete = requete + nom +"=" + valeurFormatee(nom, valeur)+",";
           }else{
           requete = requete + nom +"=" + valeurFormatee(nom, valeur);

           }
       }
       requete = requete + "where numRdv="+ valeurFormatee("numRdv", numero);
       System.out.println("Requete de modification effectué");
    }

    void ajouter(String rdv, String rdv0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
