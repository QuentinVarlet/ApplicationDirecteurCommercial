
package userclasses.util.paramreseau;

public class ParametresReseau {
     
    private static String ADRESSESERVEUR      = "192.168.43.116";     // DISTANTE OVH  
 // private static String ADRESSESERVEUR      = "172.16.212.182";  // LOCALE   LYCEE
 // private static String ADRESSESERVEUR      = "192.168.1.3";     // LOCALE   AT HOME
    
    
    private static String PORT                = "8080";
    private static String APPLI               = "Web_Appli_GC_PPES";
    private static String ENTREE_SERVICE      = "rest";
    
    public  static String RACINE_SERVICE_REST = "http://"+
                                                ADRESSESERVEUR+":"+
                                                PORT+"/"+
                                                APPLI+"/"+
                                                ENTREE_SERVICE+"/";          
}
