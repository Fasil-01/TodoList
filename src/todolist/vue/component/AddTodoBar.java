package todolist.vue.component;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import todolist.model.Priorite;
import todolist.model.Todo;
import todolist.service.TodoList;
public class AddTodoBar extends JPanel {
    private JLabel labelTask;
    private JLabel labelPriority;
    private JTextField taskTf;
    private JComboBox<Priorite> comboBoxPriority;
    private JButton addBtn;
    private TodoList todoList;
    private SearchTodoBar paneSearchTodoBar; 
    public JButton getAddBtn() {
        return addBtn;
    }
    public AddTodoBar(TodoList todoList){
        this.todoList = todoList;
        this.initComponents();
        this.addBtn.addActionListener(e -> {
            String description = taskTf.getText();
            taskTf.setText("");
            Priorite etat = (Priorite) comboBoxPriority.getSelectedItem();
            todoList.addTodo(new Todo(description,etat));
        });
        
    }
    private void initComponents() {
        this.initLabelTask();
        this.initTaskTf();
        this.initLabelPriority();
        this.initComboBoxPriority();
        this.initAddBtn();
        this.add(labelTask);
        this.add(taskTf);
        this.add(labelPriority);
        this.add(comboBoxPriority);
        this.add(addBtn);
        paneSearchTodoBar = new SearchTodoBar(todoList);
        paneSearchTodoBar.setPreferredSize(new Dimension(350,30));
        this.add(paneSearchTodoBar);
        this.setPreferredSize(new Dimension(350,110));
        this.setBackground(new Color(13,21,32));
    }
    private void initAddBtn() {
        addBtn = new JButton("Creer");
        addBtn.setPreferredSize(new Dimension(200,20));
        addBtn.setBorder(null);
        addBtn.setBackground(new Color(13,40,71));
        addBtn.setForeground(new Color(192,230,255));
    }
    private void initTaskTf() {
        taskTf = new JTextField();
        taskTf.setPreferredSize(new Dimension(250,20));
        taskTf.setBorder(null);
    }
    private void initComboBoxPriority() {
        comboBoxPriority = new JComboBox<>(Priorite.values());
        comboBoxPriority.setPreferredSize(new Dimension(250,20));
        comboBoxPriority.setBorder(null);
    }
    private void initLabelPriority() {
        this.labelPriority = new JLabel("Priorite");
         labelPriority.setForeground(new Color(192,230,255));
    }
    private void initLabelTask() {
        this.labelTask = new JLabel("Tache");
        labelTask.setForeground(new Color(192,230,255));
    }
   
    public JTextField getTask() {
        return taskTf;
    }
    public void setTask(JTextField task) {
        this.taskTf = task;
    }
    public JComboBox getPriority() {
        return comboBoxPriority;
    }
    public void setPriority(JComboBox priority) {
        this.comboBoxPriority = priority;
    }
    
     
}
