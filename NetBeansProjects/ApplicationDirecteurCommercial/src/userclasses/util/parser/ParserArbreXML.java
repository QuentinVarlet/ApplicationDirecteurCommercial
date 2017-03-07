package userclasses.util.parser;

import com.codename1.xml.Element;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

/**
 *
 * @author rsmon
 */
public class ParserArbreXML {
    
    public static  Vector<Element> getLesElementsFils(Element racine, String nomTag) {
           
     return (Vector<Element>)racine.getChildrenByTagName(nomTag);    
    }
    
    public static  String getValeur(Element element, String nomTag)  {
     
      String s=  element.getFirstChildByTagName(nomTag).getChildAt(0).getText();
   
      String us="";
      try {
            us = new String(s.getBytes(),"UTF8");
      }
      catch (UnsupportedEncodingException ex){}
      return us; 
    }
    
    public static  Element getElementDansPour(Vector<Element> listeElements,String nomTag,String valeur){
    
       Element element=null;
       for (Element elt: listeElements){
                             
         String  v=getValeur(elt,nomTag); 
         if(valeur.equals(v)){ element=elt;break;} 
       }        
       return element;
    }
}


