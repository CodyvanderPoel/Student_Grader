import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GradeBook {
    public static void saveGrades (ArrayList<Integer> grades, Integer average, String letter) {
        try {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.m").format(new java.util.Date());
            FileWriter writer = new FileWriter("src/gradebook.txt",true);
            writer.write("\n\n"+timeStamp + "\n" +"Grades: \n" +grades +"\n"+ "Average: "+average +" || Letter Grade: " +letter);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void readGrades () throws IOException {
        File file = new File("src/gradebook.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
    }
}