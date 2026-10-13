
import java.util.*;

public class DesignTaskManager {

    static class Task {
        int userId;
        int taskId;
        int priority;

        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    private Map<Integer, Task> tasks;
    private PriorityQueue<Task> queue;

    public DesignTaskManager() {
        tasks = new HashMap<>();

        queue = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) {
                return Integer.compare(b.priority, a.priority);
            }
            return Integer.compare(b.taskId, a.taskId);
        });
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        tasks.put(taskId, task);
        queue.offer(task);
    }

    public void edit(int taskId, int newPriority) {
        Task oldTask = tasks.get(taskId);

        if (oldTask != null) {
            Task newTask = new Task(
                oldTask.userId, taskId, newPriority
            );

            tasks.put(taskId, newTask);
            queue.offer(newTask);
        }
    }

    public void rmv(int taskId) {
        tasks.remove(taskId);
    }

    public int execTop() {
        while (!queue.isEmpty()) {
            Task task = queue.poll();

            // Ignore removed tasks and outdated priorities.
            if (tasks.get(task.taskId) == task) {
                tasks.remove(task.taskId);
                return task.userId;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        DesignTaskManager manager = new DesignTaskManager();

        manager.add(1, 101, 5);
        manager.add(2, 102, 8);
        manager.add(3, 103, 8);

        System.out.println(manager.execTop());

        manager.edit(101, 10);

        System.out.println(manager.execTop());
        System.out.println(manager.execTop());
        System.out.println(manager.execTop());
    }
}
