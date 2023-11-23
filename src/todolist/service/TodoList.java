package todolist.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import static java.util.stream.Collectors.*;

import java.io.File;
import java.io.IOException;

import todolist.model.Subject;
import todolist.model.Todo;
import todolist.vue.Observer;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TodoList implements Subject {
    private  List<Todo> todos = new ArrayList<>(); 
    private  List<Observer> observers = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();
    public TodoList(){
       this.loadTodo();
    }
    public void addTodo(Todo todo) {
        todos.add(todo);
        this.storeTodo(todos);
        this.notifyObservers(todos);
    }
    public void searchTodo(String search){
        List<Todo> todosSearched;
        todosSearched = todos.stream()
        .filter(t->Arrays.asList(t.getNom().split("\\s+")).contains(search))
        .collect(toList());
        todosSearched = todosSearched.size()> 0 ? todosSearched:todos;
        this.notifyObservers(todosSearched);
    }
    public void searchTodo(int id){
        List<Todo> todoSearched;
        if(todos.size()>id && id>0){
          todoSearched = todos.subList(id, id);
          this.notifyObservers(todoSearched);
        }
    }
    public void updateTodo(Todo todo){
        todos.add(todo.getId(), todo);
         this.storeTodo(todos);
        this.notifyObservers(todos);
    }
    public void deleteTodo(int id){
        if(todos.size()>id && id>0){
          todos.remove(id);
          this.storeTodo(todos);
          this.notifyObservers(todos);
        }
    }
    private void storeTodo(List<Todo> todos){
         try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("store/todolist.json"), todos);
        } catch (StreamWriteException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadTodo(){
        
        try {
             this.todos =  objectMapper.readValue(new File("store/todolist.json"),new TypeReference<List<Todo>>(){});
            if(this.todos.size()>0){
               this.notifyObservers(this.todos);
            }
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }
    @Override
    public void notifyObservers(List<Todo> todos) {
        observers.forEach(o-> o.notify(todos));
    }
}
