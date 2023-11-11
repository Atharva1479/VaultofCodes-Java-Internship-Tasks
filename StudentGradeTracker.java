import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {

        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Integer> studentGrades = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Student Grade Tracker Menu:");
        System.out.println("1. Add new student and grade");
        System.out.println("2. View list of students and grades");
        System.out.println("3. Calculate and display average grade");
        System.out.println("4. Exit");

        while (true) {
            
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();

            if (choice==1){

                    System.out.print("Enter student name: ");
                    String newName = scanner.next();
                    studentNames.add(newName);

                    System.out.print("Enter student grade: ");
                    int newGrade = scanner.nextInt();
                    studentGrades.add(newGrade);

                    System.out.println("Student added successfully!");
                    
                }

            else if (choice==2) {

                    System.out.println("List of students and grades:");
                    for (int i = 0; i < studentNames.size(); i++) {
                        System.out.println(studentNames.get(i) + ": " + studentGrades.get(i));
                    }                 
                  }
                   
            else if (choice==3) {
                    if (studentGrades.size() == 0) {
                        System.out.println("No students added yet.");
                    } else {
                        double average = calculateAverage(studentGrades);
                        System.out.println("Average grade: " + average);
                    }
                   
                }

            else if (choice==4) {
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                }

            else{
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static double calculateAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
}
