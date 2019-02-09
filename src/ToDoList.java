import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    List<Task> tasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    public ToDoList(List<String> allLines) {
        this.tasks = new ArrayList<>();
        for (String line : allLines) {
            tasks.add(new Task(line));
        }
    }

    public String list() {
        String taskList = "";
        if (tasks.size() != 0) {
            for (int i = 0; i < tasks.size(); i++) {
                taskList += i + 1 +" - " + tasks.get(i).list() + "\n";
            }
            return taskList;
        }
        return "No todos for today! :)";
    }

    public List<String> add(String string) {
        this.tasks.add(new Task(string));
        return this.getAllLines();
    }

    public List<String> remove(String index) {
        try {
            int indexToRemove = Integer.parseInt(index);
            tasks.remove(indexToRemove - 1);
        } catch (IllegalArgumentException ex) {
            System.out.println("Unable to remove: index is not a number");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Unable to remove: index is out of bound");
        }
        return this.getAllLines();
    }

    public List<String> complete(String index) {
        try {
            int indexToCheck = Integer.parseInt(index);
            tasks.get(indexToCheck -1).complete();
        } catch (IllegalArgumentException ex) {
            System.out.println("Unable to check: index is not a number");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Unable to check: index is out of bound");
        }
        return this.getAllLines();
    }

    public List<String> getAllLines() {
        List<String> allLines = new ArrayList<>();
        for (Task task : tasks) {
            String line = task.getDescription();
            if (task.isDone) {
                line += " X";
            }
            allLines.add(line);
        }
        return allLines;
    }
}
