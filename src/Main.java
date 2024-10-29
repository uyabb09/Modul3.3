import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String name;
    boolean isCompleted;

    public Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return this.name + " [Completed: " + this.isCompleted + "]";
    }
}

class TaskManager {
    ArrayList<Task> tasks = new ArrayList<>();

    // Refactoring 3: Avoid multiple Scanner initialization by passing it as parameter
    public void addTask(Scanner scanner) {
        System.out.println("Enter task name: ");
        String name = scanner.nextLine();
        tasks.add(new Task(name));
        System.out.println("Task added.");
    }

    public void completeTask(Scanner scanner) {
        System.out.println("Enter task number to mark as completed: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void showTasks() {
        // Refactoring 4: Use enhanced for-loop
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}

public class Main {
    // Refactoring 2: Replace magic numbers with constants
    private static final int ADD_TASK = 1;
    private static final int COMPLETE_TASK = 2;
    private static final int SHOW_TASKS = 3;
    private static final int EXIT = 4;

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Refactoring 1: Extract method to display menu
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case ADD_TASK:
                    manager.addTask(scanner);
                    break;
                case COMPLETE_TASK:
                    manager.completeTask(scanner);
                    break;
                case SHOW_TASKS:
                    manager.showTasks();
                    break;
                case EXIT:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Refactoring 1: Method extracted to show menu
    private static void showMenu() {
        System.out.println("1. Add Task\n2. Complete Task\n3. Show Tasks\n4. Exit");
    }
}
