public class Main implements Txt{
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Command Line Todo application\n" +
                    "=============================\n" +
                    "\n" +
                    "Command line arguments:\n" +
                    " -l   Lists all the tasks\n" +
                    " -a   Adds a new task\n" +
                    " -r   Removes an task\n" +
                    " -c   Completes an task");
        }

        if (args.length != 0) {
            ToDoList toDoList = new ToDoList(Txt.readFile());
            switch (args[0]) {
                case "-l":
                    System.out.println(toDoList.list());
                    break;
                case "-a":
                    try {
                        Txt.writeFile(toDoList.add(args[1]));
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Unable to add: no task provided");
                    }
                    break;
                case "-r":
                    try {
                        Txt.writeFile(toDoList.remove(args[1]));
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Unable to remove: no index provided");
                    }
                    break;
                case "-c":
                    try {
                        Txt.writeFile(toDoList.complete(args[1]));
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Unable to check: no index provided");
                    }

                    break;
                default:
                    System.out.println("Unsupported argument\n");
                    System.out.println("Command Line Todo application\n" +
                            "=============================\n" +
                            "\n" +
                            "Command line arguments:\n" +
                            " -l   Lists all the tasks\n" +
                            " -a   Adds a new task\n" +
                            " -r   Removes an task\n" +
                            " -c   Completes an task");
                    break;
            }
        }
    }
}
