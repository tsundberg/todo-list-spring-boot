package se.thinkcode.todo_spring_boot.todo;

import java.util.List;

public interface TodoRepository {
    void add(Owner owner, Task task);

    List<Task> getTasks(Owner owner);

}
