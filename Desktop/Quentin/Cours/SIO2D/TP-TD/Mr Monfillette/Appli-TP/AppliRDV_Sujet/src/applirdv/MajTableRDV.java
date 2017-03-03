
package applirdv;

import java.io.File;
import java.io.IOException;
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

public class MajTableRDV {
    
  public static void main(String[] args) {
  
     GereRDV gereRDV= new GereRDV();   
      
      Document   doc      = charger("modifsRDV.xml");       
     
     NodeList uneliste = doc.getElementsByTagName("rdv");
   
     
     for (int i=0; i<uneliste.getLength(); i++){
      
         Node noeud = uneliste.item(i);
         
         if (noeud.getNodeType()== Node.ELEMENT_NODE){
             Element elt = (Element) noeud;
             String rdv = elt.getElementsByTagName("numRdv").item(0).getTextContent();
             System.out.println(elt.getNodeName());
             
             NodeList nl = elt.getChildNodes();
             
             for (int ii=0; ii<nl.getLength(); ii++) {
                 Node nd = nl.item(ii);
                    if (nd.getNodeType()== Node.ELEMENT_NODE){
                        //System.out.println(nd.getNodeName());
                        Element node = (Element) nd;
                        System.out.println(node.getNodeName());
                        System.out.println (node.getTextContent());
                    }
             }
             
             /*if (elt.getAttribute("action").equals("ajout") || elt.getAttribute("action").equals("modif")){
                 //gereRDV.ajouter(rdv, rdv);
                 elt.getElementsByTagName("rdv");
             }
             else{
                 gereRDV.supprimer(rdv);
             }*/
             
             //System.out.println("Nméro rdv : " + elt.getAttribute("numRdv"));
             //System.out.println("Désignation : " + elt.getElementsByTagName("designation").item(0).getTextContent());
             //System.out.println("Prix :" + elt.getElementsByTagName("prix").item(0).getTextContent());
         }
         
     }
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
    
    
     
