package se.thinkcode.todo_spring_boot.todo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public void createTask(Task task, Owner owner) {
        repository.add(owner, task);
    }

    public List<Task> getTasks(Owner owner) {
        return repository.getTasks(owner);
    }
}