
package applirdv;

import java.util.LinkedList;
import java.util.List;

public class Champs {
      
    public  void       ajouter(String unNom, String uneValeur){
    
        lesChamps.add(new Champ(unNom,uneValeur));
    
    }
    
    public  int        getNbChamps(){
      //  A modifier
      return lesChamps.size() ;
    }  
    
    public  String     getNom( int unIndex){
    
          return lesChamps.get(unIndex).nom;
    }
    
    public  String     getValeur(int unIndex){
        return lesChamps.get(unIndex).valeur;}
    
    public  void       vider(){
        lesChamps.clear();
    }
    
    //<editor-fold defaultstate="collapsed" desc="RESTE DU CODE">
    
    private class Champ{
        
        String nom;
        String valeur;
        
        public Champ(String nom, String valeur) {
            this.nom = nom;
            this.valeur = valeur;
        }
        
        
    }
    
    private List<Champ> lesChamps= new LinkedList<Champ>();
    
    //</editor-fold>
}
