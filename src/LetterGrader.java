import java.util.Scanner;

public class LetterGrader {
    private Scanner user = new Scanner(System.in);
    private Integer numGrade;
    private String letter;
    public void grade() {
        String num = getInput();
        numGrade = getNumber(num);
        letter = letterGrade(numGrade);
        System.out.println("Grade: " + letter);
    }
    public static Integer getNumber (String num) {
        Integer points = Integer.parseInt(num);
        return points;
    }
    public String getInput () {
        System.out.println("Enter grade: ");
        String input = user.nextLine();
        return input;
    }
    public String letterGrade (Integer numGrade) {
        var g = numGrade;
        if (g < 64) {
            return "F";
        } else if (g>64&&g<70) {
            return "D";
        } else if (g>=70&&g<80) {
            return "C";
        } else if (g>=80&&g<90) {
            return "B";
        } else if (g>=90&&g<100) {
            return "A";
        } else {
            return "A+";
        }
    }
}
