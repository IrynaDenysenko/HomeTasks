package HomeTask2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IfElse {
    public static void main(String[] args) throws IOException{
        System.out.println("Please enter your month number");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String sMonth = reader.readLine();

        int month = Integer.parseInt(sMonth);

        String season;
        if (month==12 || month==1 || month==2) {
            season = "Winter";
        }
        else if  (month==3 || month==4 || month==5) {
            season = "Spring";
        }
        else if  (month==6 || month==7 || month==8) {
            season = "Summer";
        }
        else if  (month==9 || month==10 || month==11) {
            season = "Autumn";
        }
        else {
            season = "Incorrect Month";
        }

        System.out.println(+month+ " month is " +season);


    }
}


