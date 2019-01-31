import java.util.ArrayList;
import java.util.Scanner;

public class GradeAverager {
    LetterGrader grader = new LetterGrader();

    public int gradeAverage;
    public Integer total;
    public ArrayList<Integer> grades = new ArrayList();
    private Scanner user = new Scanner(System.in);


    public void gradeScoring() {
        String letterGrade = grader.letterGrade(gradeAverage);
        if (letterGrade == "F") {
            System.out.println("Uhhhh you failed big dawg :-(");
        }
        else {
            System.out.println("You passed homie!");
        }
        System.out.printf("Grade: %d || Letter Grade: %s", gradeAverage, letterGrade);
    }


    public void gatherGrades() {
        total = 0;
        var statement = true;
        var exp = "[0-9]+";
        System.out.println("Enter END to average the numbers.\nEnter CLOSE to exit the application" );
        while (statement) {
            System.out.println("Grade: ");
            String input = user.nextLine();
            if (input.equals("END")){
                try {
                gradeAverage = total / grades.size();
                System.out.println("Average: " + gradeAverage);
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