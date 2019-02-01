import java.io.IOException;
import java.util.Scanner;

public class Program {

    public static void main (String[] args) throws IOException {
        Scanner user = new Scanner(System.in);
//     Commented out for development   LetterGrader lg = new LetterGrader();
//        lg.grade();
        while (true) {
            System.out.println("\n[1]-- Average new set of grades\n[2]-- View Grades\n[3]-- Closes program");
            String input = user.nextLine();
            if (input.equals("1")) {
                GradeAverager ga = new GradeAverager();
                ga.gatherGrades();
            } else if (input.equals("2")) {
                GradeBook gb = new GradeBook();
                gb.readGrades();
            } else if (input.equals("3")) {
                System.exit(0);
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
