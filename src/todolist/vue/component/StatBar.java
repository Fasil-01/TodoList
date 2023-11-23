package todolist.vue.component;


import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.*;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import todolist.model.Etat;
import todolist.model.Todo;
import todolist.vue.Observer;

public class StatBar extends JPanel implements Observer { 
    private JPanel paneStatTodoPending;
    private JPanel paneStatTodoInProgress; 
    private JPanel paneStatTodoBroke;
    private JPanel paneStatTodoFinished;
    private JPanel paneStatTodoAll;
    private JPanel paneStatTodo[] = {
                                    paneStatTodoPending, 
                                    paneStatTodoInProgress,
                                    paneStatTodoBroke,
                                    paneStatTodoFinished
                                    };
    
    public StatBar(){
        this.setPreferredSize(new Dimension(350,110));
        this.setBackground(new Color(13,21,32));
    }
    private List<Todo> filterTodosByState(List<Todo> todos,Etat etat){
          return todos.stream()
                       .filter(todo->todo.getEtat() == etat)
                        .collect(toList());
    }
    @Override
    public void notify(List<Todo> todos) {
        List<Todo> pendingTodos = filterTodosByState(todos,Etat.EN_ATTENTE);
        List<Todo> inProgressTodos = filterTodosByState(todos,Etat.EN_COURS);
        List<Todo> brokeTodos = filterTodosByState(todos,Etat.INTERROMPUE);
        List<Todo> finishedTodos = filterTodosByState(todos,Etat.FINI);
   
    }
    
    
}
