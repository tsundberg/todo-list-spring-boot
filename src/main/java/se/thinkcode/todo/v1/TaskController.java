package se.thinkcode.todo.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.thinkcode.todo.Owner;
import se.thinkcode.todo.Task;
import se.thinkcode.todo.TodoService;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class TaskController {
    private final TodoService service;

    public TaskController(TodoService service) {
        this.service = service;
    }

    @PostMapping("/addTask")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@RequestBody
                           TaskRequest task) {
        Task taskModel = task.toTask();
        Owner ownerModel = task.toOwner();

        service.createTask(taskModel, ownerModel);
    }

    @GetMapping("/getTasks/{owner}")
    public List<TaskResponse> getTasks(@PathVariable
                                       String owner) {
        Owner ownerModel = new Owner(owner);
        List<Task> taskList = service.getTasks(ownerModel);

        return TaskResponse.fromModel(taskList);
    }
}
