package todolist.vue.component;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import todolist.service.TodoList;

public class SearchTodoBar extends JPanel {
    private TodoList todoList;
    private JTextField searchTextField;
    private JButton searchBtn;
    private JButton reInitbtn;
    private JButton verticalMenuBtn;
    public SearchTodoBar(TodoList todoList) {
        this.todoList = todoList;
        this.initComponents();
        this.searchBtn.addActionListener(e->{
            todoList.searchTodo(searchTextField.getText());
            searchTextField.setText("");
        });
        this.reInitbtn.addActionListener(e-> {
            todoList.loadTodo();

        });
    }
    private void initComponents() {
       this.initSearchBtn();
       this.initSearchTextField();
       this.reInitbtn();
       this.initVerticalMenutbtn();
       this.add(reInitbtn);
       this.add(searchTextField);
       this.add(searchBtn);
       this.add(verticalMenuBtn);
    }
    private void initSearchTextField() {
        searchTextField = new JTextField();
        searchTextField.setPreferredSize(new Dimension(230,20));
        searchTextField.setBorder(null);
    }
    private void initVerticalMenutbtn(){
        ImageIcon imgVerticalMenuBtn =new ImageIcon("src/img/icon/menu-points-vertical.png");
        verticalMenuBtn = new JButton(imgVerticalMenuBtn);
        verticalMenuBtn.setPreferredSize(new Dimension(5,20));
        verticalMenuBtn.setBorder(null);
        verticalMenuBtn.setBackground(null);
    }
    


    private void initSearchBtn() {
        ImageIcon imgSearch =new ImageIcon("src/img/icon/chercher.png");
        searchBtn = new JButton(imgSearch);
        searchBtn.setBorderPainted(false);
        searchBtn.setPreferredSize(new Dimension(25,20));
        searchBtn.setBorder(null);
        searchBtn.setBackground(new Color(13,40,71));
        searchBtn.setForeground(new Color(192,230,255));
    } private void reInitbtn(){
        ImageIcon imgReInit =new ImageIcon("src/img/icon/rafraichir.png");
        reInitbtn = new JButton(imgReInit);
        reInitbtn.setPreferredSize(new Dimension(20,20));
        reInitbtn.setBorder(null);
        reInitbtn.setBackground(new Color(13,40,71));
    }
    
   
}
