package assignment.todo.java.console.app.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TaskFactoryTest {
    @Test
    void should_parse_completed_property() {
        final var isCompleted = TaskFactory.creatTask(1,"+ foobar").isCompleted();
        assertFalse(isCompleted);
    }

    @Test
    void should_support_name_with_multiple_white_spaces() {
        Task task = TaskFactory.creatTask(1, "+   foo  bar");
        assertEquals("  foo  bar", task.getName());
    }
}
