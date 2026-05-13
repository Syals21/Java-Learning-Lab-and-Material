/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labpractice1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class LabPractice1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner in = new Scanner(System.in);
        LinkedList<Student> stud = new LinkedList<>();

        int choice = 0;

        while (choice != 5) {

            System.out.println("\n==== Student System ====");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Display All Students (Sorted)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = in.nextInt();

            switch (choice) {

                case 1: // ADD STUDENT
                    try {
                        System.out.print("Enter ID: ");
                        int id = in.nextInt();
                        in.nextLine(); // clear buffer

                        System.out.print("Enter Name: ");
                        String name = in.nextLine();

                        System.out.print("Enter Marks: ");
                        int marks = in.nextInt();

                        Student s = new Student(id, name, marks);
                        stud.add(s);

                        System.out.println("Student successfully added!");

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2: // SEARCH STUDENT
                    try {
                        System.out.print("Enter ID to search: ");
                        int sid = in.nextInt();

                        Student found = searchStudent(stud, sid);
                        System.out.println("Student FOUND:\n" + found);

                    } catch (StudentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3: // REMOVE STUDENT
                    try {
                        System.out.print("Enter ID to remove: ");
                        int rid = in.nextInt();

                        Student removed = removeStudent(stud, rid);
                        System.out.println("Removed: " + removed);

                    } catch (StudentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4: // DISPLAY SORTED
                    if (stud.isEmpty()) {
                        System.out.println("No students to display.");
                    } else {

                        System.out.println("\nSort By:");
                        System.out.println("1. Marks (Natural Order - Comparable)");
                        System.out.println("2. Name (Comparator)");
                        System.out.print("Enter option: ");
                        int sortChoice = in.nextInt();

                        if (sortChoice == 1) {
                            // Uses compareTo() in Student
                            Collections.sort(stud);
                            System.out.println("\n--- Students Sorted by Marks ---");

                        } else if (sortChoice == 2) {
                            // Uses NameComparator
                            Collections.sort(stud, new NameComparator());
                            System.out.println("\n--- Students Sorted by Name ---");
                        } else {
                            System.out.println("Invalid sort option.");
                            break;
                        }

                        for (Student s : stud) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        in.close();
    }

    // =========================
    // SEARCH METHOD
    // =========================
    public static Student searchStudent(LinkedList<Student> list, int id)
            throws StudentNotFoundException {

        for (Student s : list) {
            if (s.getId() == id) {
                return s;
            }
        }
        throw new StudentNotFoundException("Student with ID " + id + " not found.");
    }

    // =========================
    // REMOVE METHOD
    // =========================
    public static Student removeStudent(LinkedList<Student> list, int id)
            throws StudentNotFoundException {

        for (Student s : list) {
            if (s.getId() == id) {
                list.remove(s);
                return s;
            }
        }
        throw new StudentNotFoundException("Student with ID " + id + " not found.");
    }
}
