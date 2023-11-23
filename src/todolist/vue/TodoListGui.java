package todolist.vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import todolist.service.TodoList;
import todolist.vue.component.AddTodoBar;
import todolist.vue.component.StatBar;
import todolist.vue.component.TableTodo;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

public class TodoListGui extends JFrame  {
    private TodoList todoList;
    private AddTodoBar paneAddTodoBar;
    private TableTodo paneTableTodo;
    private StatBar paneStatBar;
    private JPanel pane; 

    public TodoListGui() {
        this.todoList = new TodoList();
        this.paneAddTodoBar =new AddTodoBar(todoList);
        this.paneStatBar       = new StatBar();
        this. paneTableTodo    = new TableTodo();
        this. pane              = new JPanel();
        this.todoList.registerObserver(paneStatBar);
        this.todoList.registerObserver(paneTableTodo);
        this.initComponents();
        this.setVisible(true);   
    }

    private void initComponents() {
        this.setSize(350,600);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/img/icon/controle-de-liste.png");
        this.setIconImage(icon);
        this.setTitle("Todo-List");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        BorderLayout layout = new BorderLayout();
        this.getContentPane().setLayout(layout);
        pane.setPreferredSize(new Dimension(250,20));
        this.getContentPane().add(paneAddTodoBar,layout.NORTH);
        this.getContentPane().add(new JScrollPane(paneTableTodo),layout.CENTER);
        this.getContentPane().add(paneStatBar,layout.SOUTH);
        this.setLocationRelativeTo(null); 
    }
  
}
