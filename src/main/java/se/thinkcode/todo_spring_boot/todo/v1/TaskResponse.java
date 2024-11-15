package se.thinkcode.todo_spring_boot.todo.v1;

import se.thinkcode.todo_spring_boot.todo.Task;

import java.util.ArrayList;
import java.util.List;

public record TaskResponse(String task) {
    public static List<TaskResponse> fromModel(List<Task> taskList) {
        List<TaskResponse> res = new ArrayList<>();
        for (Task task : taskList) {
            String t = task.task();
            TaskResponse taskResponse = new TaskResponse(t);
            res.add(taskResponse);
        }
        return res;
    }
}
