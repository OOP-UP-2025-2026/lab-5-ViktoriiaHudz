package ua.opnu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Person[] people = new Person[] {
                new Person("Петренко", "Іван", 40),
                new Person("Седашова", "Софія", 20),
                new Student("Гудз", "Вікторія", 18, "УП 241", "12345"),
                new Student("Ківганов", "Олександр", 18, "УІ 241", "67890"),
                new Lecturer("Сидоренко", "Марія", 45, "Комп'ютерних наук", 22500),
                new Lecturer("Захарчук", "Ігор", 40, "Математики", 22000)
        };

        System.out.println("=== Інформація про людей ===");
        for (Person person : people) {
            System.out.println(person.toString());
        }

        SwingUtilities.invokeLater(() -> new MainFrame("RoShamBo"));
    }
}

