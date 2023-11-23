package todolist.vue.component;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import todolist.model.Todo;
import todolist.vue.Observer;

public class TableTodo extends JTable implements Observer {
    List<Todo> todos;
    static DefaultTableModel modeleTable;
       
    private static  DefaultTableModel model(){
        modeleTable = new DefaultTableModel();
        modeleTable.addColumn("Tache");
        modeleTable.addColumn("Etat");
        modeleTable.addColumn("Priorite"); 
        return modeleTable;
    }
    public TableTodo(){
        super(model());
        
    }
    @Override
    public void notify(List<Todo> todos) {
        modeleTable.setRowCount(0);
        for(Todo todo: todos){
            Object [] rowData = {todo.getNom(), todo.getEtat(), todo.getPriorite()};
            modeleTable.addRow(rowData);
        }
     
    }
    
}
