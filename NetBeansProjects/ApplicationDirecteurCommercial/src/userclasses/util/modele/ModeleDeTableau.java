package userclasses.util.modele;

import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.table.TableModel;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author rsmon
 */
public class ModeleDeTableau implements TableModel {
    
   private ArrayList<ArrayList> data = new ArrayList<ArrayList>();

   public ModeleDeTableau() {}

   public ModeleDeTableau(String ... titres) {
       
        this();
        remplirEntete(titres);
   }
     
   public int     getRowCount(){ return data.size()-1; }
   public int     getColumnCount(){ return data.get(0).size(); }
   public String  getColumnName(int i){ return (String) data.get(0).get(i); }
   public boolean isCellEditable(int row, int column) { return false;}
   public Object  getValueAt(int row, int column) { return data.get(row+1).get(column); }
   public void    setValueAt(int row, int column, Object val) {data.get(row+1).set(column, val); }
   public void    addDataChangeListener(DataChangedListener d) {}
   public void    removeDataChangeListener(DataChangedListener d) {}
    
   public final void remplirEntete(String[] titres) {
       
     data.clear();   
     ArrayList entetes= new ArrayList(Arrays.asList(titres));
     data.add(entetes);
   }         

   public void ajouterRangee(Object ... valeurs){
      
     ArrayList   ligSal= new ArrayList();    
     ligSal.addAll(Arrays.asList(valeurs));
     data.add(ligSal); 
   }
   
   public void viderData(){
       
      ArrayList entetes=data.get(0);
      data.clear();
      data.add(entetes);
   }
}

