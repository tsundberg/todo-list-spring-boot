package se.thinkcode.todo.v2;

import org.junit.jupiter.api.Test;
import se.thinkcode.todo.InMemoryTodoRepository;
import se.thinkcode.todo.TodoRepository;
import se.thinkcode.todo.TodoService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskControllerTest {
    @Test
    void should_create_task() {
        GetTaskResponse expected = new GetTaskResponse("Öva");
        TodoRepository repository = new InMemoryTodoRepository();
        TodoService service = new TodoService(repository);
        TaskController controller = new TaskController(service);
        CreateTaskRequest task = new CreateTaskRequest("Kalla", "Öva");

        controller.createTask(task);
        List<GetTaskResponse> actual = controller.getTasks("Kalla");

        assertThat(actual).containsExactly(expected);
    }
}
