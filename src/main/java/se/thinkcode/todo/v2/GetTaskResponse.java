package se.thinkcode.todo.v2;

import se.thinkcode.todo.Task;

import java.util.ArrayList;
import java.util.List;

public record GetTaskResponse(String task) {
    public static List<GetTaskResponse> fromModel(List<Task> taskList) {
        List<GetTaskResponse> res = new ArrayList<>();
        for (Task task : taskList) {
            String t = task.task();
            GetTaskResponse getTaskResponse = new GetTaskResponse(t);
            res.add(getTaskResponse);
        }
        return res;
    }
}
