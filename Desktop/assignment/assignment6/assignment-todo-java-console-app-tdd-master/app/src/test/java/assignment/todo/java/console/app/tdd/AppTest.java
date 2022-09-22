package assignment.todo.java.console.app.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

class AppTest {

    private App app;

    @BeforeEach
    void setUp() {
        if (isInit()) {
            writeDataFile(List.of(
                    "+ Task 01",
                    "+ Task 02",
                    "x Task 03",
                    "x Task 04"));
            app = new App();
        }

    }

    @Test
    void tasks_should_exists() {
        app = new App();
        if (!isInit()) {
            Assertions.assertEquals("Initialized successfully.", app.run("init").get(0));
        } else {
            Assertions.assertEquals("You have initialized.", app.run("init").get(0));
        }
    }

    @Test
    void should_list_existing_tasks() {
        if (!isInit()) {
            return;
        }
        Assertions.assertEquals(List.of(
                "# To be done"
                , "1 Task 01"
                , "2 Task 02",
                "# Completed"
                , "3 Task 03"
                , "4 Task 04"), app.run());
    }


    @Test
    void should_add_task_with_single_word_as_name() {
        if (!isInit()) {
            return;
        }
        app.run("add", "foobar");
        Assertions.assertEquals(List.of(
                "# To be done"
                , "1 Task 01"
                , "2 Task 02"
                , "5 foobar",
                "# Completed"
                , "3 Task 03"
                , "4 Task 04"), app.run());
    }

    @Test
    void should_add_task_with_multiple_word_as_name() {
        if (!isInit()) {
            return;
        }
        app.run("add", "fizz", "buzz");

        Assertions.assertEquals(List.of(
                "# To be done"
                , "1 Task 01"
                , "2 Task 02"
                , "5 fizz buzz",
                "# Completed"
                , "3 Task 03"
                , "4 Task 04"), app.run());
    }

    @Test
    void should_mark_one_task() {
        if (!isInit()) {
            return;
        }
        app.run("mark", "1");
        Assertions.assertEquals(List.of(
                "# To be done"
                , "2 Task 02",
                "# Completed"
                , "1 Task 01"
                , "3 Task 03"
                , "4 Task 04"), app.run());
    }

    @Test
    void should_mark_multiple_tasks() {
        if (!isInit()) {
            return;
        }
        new App().run("mark", "1", "2");
        Assertions.assertEquals(List.of(
                "# To be done"
                , "Empty",
                "# Completed"
                , "1 Task 01"
                , "2 Task 02"
                , "3 Task 03"
                , "4 Task 04"), app.run());
    }

    private void writeDataFile(List<String> lines) {
        try (var bw = Files.newBufferedWriter(Constants.TASKS_FILE_PATH)) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
    }

    private boolean isInit() {
        File file = Constants.TASKS_FILE_PATH.toFile();
        return file.exists();
    }
}
