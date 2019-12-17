
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
	
	/////////////////////////////////////////////////////////////////
	// Atributos
	/////////////////////////////////////////////////////////////////
	private boolean    DEBUG       = false;
	private String[]   columnNames = DataLoader.getHeader();
	private Object[][] data        = DataLoader.getData();
	private Object[][] dataMun     = DataLoader.getDataOrdenadoMunicipio();
	private Object[][] dataMunPop  = DataLoader.getDataOrdenadoMunicipioPopulacao();

	
	/////////////////////////////////////////////////////////////////
	// Getters
	/////////////////////////////////////////////////////////////////
	public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Object getRowData(int row){
    	return data[row];
    }
    
    public Object getRowDataMunicipio(int row) {
    	return dataMun[row];
    }
    
    public Object getRowDataMunicipioPopulacao(int row) {
    	return dataMunPop[row];
    }
    
    public Class getColumnClass2(int c) {
    	/*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        return getValueAt(0, c).getClass();
    }
    
    public Class getColumnClass(int column) 
    {
          Class returnValue;
          if ((column >= 0) && (column < getColumnCount())) 
          {
              returnValue = getValueAt(0, column).getClass();
          } 
          else 
          {
             returnValue = Object.class;
          }

          return returnValue;

   }
    
    
    /////////////////////////////////////////////////////////////////
    // Setters
    /////////////////////////////////////////////////////////////////
    
    public void setValueAt(Object value, int row, int col) {
    	/*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        if (DEBUG) {
            System.out.println("Setting value at " + row + "," + col
                               + " to " + value
                               + " (an instance of "
                               + value.getClass() + ")");
        }

        data[row][col] = value;
        fireTableCellUpdated(row, col);

        if (DEBUG) {
            System.out.println("New value of data:");
            printDebugData();
        }
    }
    
    
    /////////////////////////////////////////////////////////////////
    // Outros métodos
    /////////////////////////////////////////////////////////////////    

    public boolean isCellEditable(int row, int col) {
    	/*
         * Don't need to implement this method unless your table's
         * editable.
         *
         * Note that the data/cell address is constant,
         * no matter where the cell appears onscreen.
         */
        if (col < 7) {
            return false;
        } else {
            return true;
        }
    }

    private void printDebugData() {
        int numRows = getRowCount();
        int numCols = getColumnCount();

        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + data[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
