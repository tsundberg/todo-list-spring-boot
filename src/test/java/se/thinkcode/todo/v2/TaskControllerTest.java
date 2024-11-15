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
        TaskResponse expected = new TaskResponse("Öva");
        TodoRepository repository = new InMemoryTodoRepository();
        TodoService service = new TodoService(repository);
        TaskControllerV2 controller = new TaskControllerV2(service);
        TaskRequest task = new TaskRequest("Kalla", "Öva");

        controller.createTask(task);
        List<TaskResponse> actual = controller.getTasks("Kalla");

        assertThat(actual).containsExactly(expected);
    }
}
