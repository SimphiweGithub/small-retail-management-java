package student;

import java.util.*;

public class Student {

    public static int AppStart = 0;
    public static ArrayList studentDetails = new ArrayList();

    public static void main(String[] args) {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("****************************************");
        startApllication();
    }

    public static int startApllication() {
        Scanner Input = new Scanner(System.in);
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        AppStart = Input.nextInt();
        while (AppStart == 1) {
            menuItems();
            if (AppStart > 1 || AppStart < 1) {
                System.exit(0);
            }
        }
        return AppStart;
    }

    public static void menuItems() {
        Scanner Input = new Scanner(System.in);
        System.out.println("");
        System.out.println("Please select one of the following menu items: ");
        System.out.println("(1) Capture a new student");
        System.out.println("(2) Search for a student");
        System.out.println("(3) Delete a student");
        System.out.println("(4) Print student report");
        System.out.println("(5) Exit application ");
        String userInput = Input.nextLine();
        switch (userInput) {
            case "1":
                saveStudent();
                break;
            case "2":
                searchStudent();
                break;
            case "3":
                deleteStudent();
                break;
            case "4":
                StudentReport();
                break;
            case "5":
                exitStudentApplication();
                break;
            default:
                System.out.println("Please select a number between 1 and 5");
                break;
        }
    }

    public static ArrayList saveStudent() {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("**************************");

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the student id: ");
        String studID = input.nextLine();

        System.out.print("\nEnter the student name: ");
        String studName = input.nextLine();

        int studAge = 0;
        boolean validAge = false;

        while (!validAge) {
            System.out.print("\nEnter the student age: ");
            try {
                studAge = input.nextInt();
                 input.nextLine();
                if (studAge >= 16) {
                    validAge = true;
                } else {
                    System.out.println("You have entered an incorrect student age!!! ");
                    System.out.println("Please re-enter the student age >> ");
                }
            } catch (InputMismatchException e) {
                System.out.println("You have entered an incorrect student age!!! ");
                System.out.println("Please re-enter the student age >> ");
                input.next();  // Clear the invalid input
            }
        }
        System.out.print("\nEnter the student email: ");
        String studEmail = input.nextLine();

        System.out.print("\nEnter the student course: ");
        String studCourse = input.nextLine();

        studentDetails.add(studID);
        studentDetails.add(studName);
        studentDetails.add(studAge);
        studentDetails.add(studEmail);
        studentDetails.add(studCourse);
        System.out.println("You have successfully captured all the details !");
        
        return studentDetails;
    }

    public static int searchStudent() {
        Scanner Input = new Scanner(System.in);
        System.out.print("Enter the Student Id to search: ");
        String userInput = Input.nextLine();
        System.out.println("-------------------------------");
        int studentSearch = studentDetails.indexOf(userInput);

        try {
            if (studentSearch != -1) {
                System.out.print("STUDENT ID: ");
                System.out.println(studentDetails.get(studentSearch));

                System.out.print("STUDENT NAME: ");
                System.out.println(studentDetails.get(studentSearch + 1));

                System.out.print("STUDENT AGE: ");
                System.out.println(studentDetails.get(studentSearch + 2));

                System.out.print("STUDENT EMAIL: ");
                System.out.println(studentDetails.get(studentSearch + 3));

                System.out.print("STUDENT COURSE: ");
                System.out.println(studentDetails.get(studentSearch + 4));

                System.out.println("------------------------------");

            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Student with Student Id: " + userInput + " was not found!");
        }
        return studentSearch;
    }

    public static ArrayList deleteStudent() {
        Scanner Input = new Scanner(System.in);
     //   Scanner newInput = new Scanner(System.in);
        System.out.print("Enter the Student Id to Delete: ");
        String userInput = Input.nextLine();
        System.out.println("-------------------------------");
        int studentSearch = studentDetails.indexOf(userInput);

        try {
            if (studentSearch != -1) {
                studentDetails.remove(studentSearch);
                studentDetails.remove(studentSearch);
                studentDetails.remove(studentSearch);
                studentDetails.remove(studentSearch);
                studentDetails.remove(studentSearch);

                System.out.println("------------------------------");

            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Student with Student Id: " + userInput + " was not found!");
        }
        return studentDetails;
    }

    public static void StudentReport() {
        int arraySize = studentDetails.size();
        int StudentNumber = 1;

        for (int i = 0; i < arraySize; i += 5) {
            System.out.println("STUDENT " + StudentNumber);
            System.out.println("-------------------------------");

            System.out.print("STUDENT ID: ");
            System.out.println(studentDetails.get(i));

            System.out.print("STUDENT NAME: ");
            System.out.println(studentDetails.get(i + 1));

            System.out.print("STUDENT AGE: ");
            System.out.println(studentDetails.get(i + 2));

            System.out.print("STUDENT EMAIL: ");
            System.out.println(studentDetails.get(i + 3));

            System.out.print("STUDENT COURSE: ");
            System.out.println(studentDetails.get(i + 4));

            System.out.println("------------------------------");

            StudentNumber++;
        }
    }

    public static void exitStudentApplication() {
        System.exit(0);
    }
}
