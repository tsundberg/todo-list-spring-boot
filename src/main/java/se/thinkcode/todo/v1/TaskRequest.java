package se.thinkcode.todo.v1;

import se.thinkcode.todo.Owner;
import se.thinkcode.todo.Task;

public record TaskRequest(String name, String task) {
    public Task toTask() {
        return new Task(task());
    }

    public Owner toOwner() {
        return new Owner(name());
    }
}
