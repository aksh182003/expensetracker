
package expensetracker;

/**
 *
 * @author bejgum akshara
 */
import java.util.List;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class expensetable extends AbstractTableModel{
    
    private final List<expenseentry> entries;
    private final String[] col={"Date","data","Amount","type"};
     public expensetable(){
         entries=new ArrayList<>();
     }
     public void addEntry(expenseentry entry){
         entries.add(entry);
         fireTableRowsInserted(entries.size()-1,entries.size()-1);
         
     }
    @Override
    public int getRowCount() {
        return entries.size();
    }

    @Override
    public int getColumnCount() {
        return col.length;
    }
     @Override
     public String getColumnName(int column){
      return col[column];
     }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       expenseentry entry=entries.get(rowIndex);
       switch(columnIndex){
           case 0:return entry.getdate();
           case 1:return entry.getdata();
           case 2:return entry.getamt();
           case 3:return entry.gettype();
           default:return null;
       }
    }

    
}
