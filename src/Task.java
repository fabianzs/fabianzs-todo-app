public class Task {
    String description;
    boolean isDone;

    public Task(String line) {
        if (line.endsWith(" X")) {
            this.description = line.substring(0, line.length() - 3);
            this.isDone = true;
        } else {
            this.description = line;
            this.isDone = false;
        }
    }

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public void complete() {
        this.isDone = true;
    }

    public String list() {
        if (this.isDone) {
            return "[X] " + this.description;
        } else {
            return "[ ] " + this.description;
        }
    }

    public String getDescription() {
        return description;
    }
}
