package assignment.todo.java.console.app.tdd;

public class TaskFactory {
    private TaskFactory() {
    }

    static Task creatTask(int id, String line) {
        final var fields = line.split(" ", 2);
        final var name = fields[1];
        boolean isCompleted = fields[0].equals("x");
        return new Task(id, name, isCompleted);
    }
}
