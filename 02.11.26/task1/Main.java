import java.util.*;

class Task {
    private String title;
    private String description;
    private int priority;
    private String status;

    public Task(String title, String description, int priority) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Пустое название");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Пустое описание");
        }
        checkPriority(priority);
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = "Новая";
    }

    private void checkPriority(int priority) {
        if (priority < 1 || priority > 5) {
            throw new IllegalArgumentException("Недопустимый приоритет");
        }
    }

    public void start() {
        if (status.equals("Выполнена")) {
            throw new IllegalStateException("Задача уже выполнена");
        }
        status = "В работе";
    }

    public void complete() {
        if (status.equals("Выполнена")) {
            throw new IllegalStateException("Задача уже выполнена");
        }
        status = "Выполнена";
    }

    public void changePriority(int priority) {
        checkPriority(priority);
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public boolean isCompleted() {
        return status.equals("Выполнена");
    }

    public String toString() {
        return title + " [приоритет " + priority + ", статус: " + status + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Task t1 = new Task("Купить продукты", "Молоко, хлеб, яйца", 2);
        Task t2 = new Task("Сделать лабу", "Практика по java за 02.11", 5);
        Task t3 = new Task("Позвонить маме", "Вечером после пар", 3);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println();

        System.out.println("Описание t2: " + t2.getDescription());
        System.out.println("Статус t2: " + t2.getStatus());
        System.out.println("t2 выполнена? " + t2.isCompleted());
        System.out.println();

        t2.start();
        System.out.println("После start(): " + t2);
        t2.complete();
        System.out.println("После complete(): " + t2);
        System.out.println("t2 выполнена? " + t2.isCompleted());
        System.out.println();

        t1.changePriority(4);
        System.out.println("Новый приоритет t1: " + t1.getPriority());
        System.out.println();

        try {
            t2.complete();
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            t3.changePriority(10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            new Task("", "что-то", 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            new Task("Задача", "  ", 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            new Task("Задача", "Описание", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
