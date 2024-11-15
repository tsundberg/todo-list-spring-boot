package se.thinkcode.todo_spring_boot.todo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryTodoRepository implements TodoRepository {
    private final Map<Owner, List<Task>> tasks = new HashMap<>();

    @Override
    public void add(Owner owner, Task task) {
        List<Task> taskList = tasks.getOrDefault(owner, new ArrayList<>());
        taskList.add(task);
        tasks.put(owner, taskList);
    }

    @Override
    public List<Task> getTasks(Owner owner) {
        return tasks.getOrDefault(owner, new ArrayList<>());
    }
}
