package assignment.todo.java.console.app.tdd;

import java.util.ArrayList;
import java.util.List;

public class ResultMessage {
    public ResultMessage() {
    }

    List<String> resultMessage(String result) {
        List<String> res = new ArrayList<>();
        res.add(result);
        return res;
    }
}
