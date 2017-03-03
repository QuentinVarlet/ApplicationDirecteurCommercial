
package applirdv;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Essais {

    private static  GereRDV gereRDV= new GereRDV();
    
    public static void main(String[] args) throws Exception
    {
         
       System.out.println("-----------------------\n");
       essaiMethodegetType();
       System.out.println("-----------------------\n");
       essaiExecSQL_QRY();
       System.out.println("-----------------------\n");
       essaiParserDOM();
          
    }
    
    public static void essaiParserDOM() throws ParserConfigurationException, SAXException, IOException
    {
    
       System.out.println("\nUtilisation du parser DOM sur le document exemple.xml\n");
   
       Document               catalogue= charger("exemple.xml");
    
       System.out.println("Racine :" + catalogue.getDocumentElement().getNodeName());
       
       NodeList   liste=catalogue.getElementsByTagName("produit");
       
       
       for (int i=0; i<liste.getLength();i++){
     
           Node noeud= liste.item(i);
           
           if( noeud.getNodeType()==Node.ELEMENT_NODE){
           
              Element elt= (Element ) noeud;
        
              System.out.println("Attribut Ref: "  + elt.getAttribute("ref"));
           
              System.out.println("Désignation : "  + elt.getElementsByTagName("designation").item(0).getTextContent());
              System.out.println("Prix: "          + elt.getElementsByTagName("prix").item(0).getTextContent());
           }
           System.out.println();
       }
    
    }

    public static void essaiExecSQL_QRY() throws SQLException
    {
    
      System.out.println("Liste de tous les RDV (seuls les noms des clients sont affichés) \n");
       
       ResultSet rs=gereRDV.execSQL_QRY("Select * from RDV");
       
       while (rs.next()){
           System.out.println(rs.getString("NOMCLIENT"));
       }  
    }

    public static void essaiMethodegetType()
    {
      System.out.println("Type du champ de nom nomClient: "+gereRDV.getType("nomClient")+"\n");
    }
    
    private static Document charger(String nomFicXml){
            
        DocumentBuilderFactory  dbf;
        DocumentBuilder             db;
          
        Document                doc=null;
        
        try {
            
            dbf= DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();     
            doc= db.parse(new File(nomFicXml));
            doc.getDocumentElement().normalize(); 
        } 
        catch (ParserConfigurationException ex) {
            Logger.getLogger(GereRDV.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SAXException ex) {
            Logger.getLogger(GereRDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(GereRDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return doc;
    } 
}
