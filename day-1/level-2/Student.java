import java.util.Scanner;
public class Student {
   private String name;
   private int rollnumber;
   private int marks;

   public Student(String name, int rollnumber, int marks) {
       this.name = name;
       this.rollnumber = rollnumber;
       this.marks = marks;
   }
   public char CalculateGrade () {
       if (marks >= 90) {
           return 'A';
       } else if (marks >= 80) {
           return 'B';
       } else if (marks >= 70) {
           return 'C';
       } else if (marks >= 60) {
           return 'D';
       } else {
           return 'F';
       }
   }
   public void displayDetails(){
       System.out.println("Name : " + name);
       System.out.println("Rollnumber : " + rollnumber);
       System.out.println("Marks : " + marks);
       System.out.println("Grade : " + CalculateGrade());
   }
   public static void main (String[] args) {
       Scanner sc = new Scanner(System.in);
       int numberOfStudents = sc.nextInt();
       sc.nextLine();
       Student [] students = new Student[numberOfStudents];
       for (int i = 0; i < numberOfStudents; i++) {
           System.out.println("details of student "+(i+1));
           System.out.println("Name : " );
           String name = sc.nextLine();
           System.out.println("Rollnumber : " );
           int rollnumber = sc.nextInt();
           System.out.println("Marks : ");
           int marks = sc.nextInt();
           sc.nextLine();
           students[i] = new Student(name, rollnumber, marks);
       }
       for (int i = 0; i < numberOfStudents; i++) {
           students[i].displayDetails();
       }
       sc.close();

   }
}