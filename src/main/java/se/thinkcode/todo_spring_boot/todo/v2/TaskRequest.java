package se.thinkcode.todo_spring_boot.todo.v2;

import se.thinkcode.todo_spring_boot.todo.Owner;
import se.thinkcode.todo_spring_boot.todo.Task;

public record TaskRequest(String taskOwner, String taskTodo) {
    public Task getTask() {
        return new Task(taskTodo());
    }

    public Owner getOwner() {
        return new Owner(taskOwner());
    }
}
