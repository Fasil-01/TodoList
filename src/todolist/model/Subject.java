package todolist.model;
import java.util.List;

import todolist.vue.Observer;
public interface Subject {
    
    public void registerObserver(Observer observer);
    public void notifyObservers(List<Todo> todos);
}