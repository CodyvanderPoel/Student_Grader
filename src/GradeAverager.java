import java.util.ArrayList;
import java.util.Scanner;

public class GradeAverager {
    LetterGrader grader = new LetterGrader();

    public int gradeAverage;
    public String name;
    public Integer total;
    public ArrayList<Integer> grades = new ArrayList();
    private Scanner user = new Scanner(System.in);
    private GradeBook gb = new GradeBook();


    public void gradeScoring() {
        String letterGrade = grader.letterGrade(gradeAverage);
        System.out.printf("Average: %d || Letter Grade: %s", gradeAverage, letterGrade);
        gb.saveGrades(grades, gradeAverage, letterGrade, name);
    }


    public void gatherGrades() {
        total = 0;
        var statement = true;
        var exp = "[0-9]+";
        System.out.println("Enter Student Name:");
        name = user.nextLine();
        System.out.println("Enter a grade and then press the enter key to insert the number.\nEnter END to average the numbers.\nEnter CLOSE to exit the application" );
        while (statement) {
            System.out.println("Grade: ");
            String input = user.nextLine();
            if (input.equals("END")){
                try {
                gradeAverage = total / grades.size();
                gradeScoring();
                statement = false;} catch (ArithmeticException ex){
//              Commented for development  ex.printStackTrace();
                    System.out.println("No numbers were provided!\nDid you mean CLOSE?");
                }
            } else if (input.matches(exp) && Integer.parseInt(input) <=100 && Integer.parseInt(input) >-1) {
                int g = Integer.parseInt(input);
                total += g;
                System.out.println("Current: "+total);
                grades.add(g);
                System.out.println("# of grades: " +grades.size());
            } else if (input.equals("CLOSE")) {
                System.out.println("Thanks for viewing the application.");
                System.exit(0);
            }
            else {
                System.out.println("Invalid entry");
            }
        }
    }
}