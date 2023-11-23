package todolist.vue;

import java.util.List;

import todolist.model.Todo;
public interface Observer{
    public void notify(List<Todo> todos);
}