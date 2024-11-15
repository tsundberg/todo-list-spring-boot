package se.thinkcode.todo_spring_boot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TodoSpringBootApplicationTest {

    @Test
    void should_test_stuffy_things() {
        String[] empty = {};
        TodoSpringBootApplication.main(empty);
    }
}
