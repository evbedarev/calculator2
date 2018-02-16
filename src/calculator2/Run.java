package calculator2;
import java.util.Scanner;

public class Run {
    private Double numOne;
    Double numTwo;
    private char mathOper;
    private Calculate calculate;  //Интерфейс вычислений
    private ValueStorage valueStorage = new ValueStorage();

    private Scanner in  = new Scanner(System.in);
    CheckValue checkValue = new CheckValue();
    private String[] arr;

    void run () {
        String input;

        for (; ;) {
            input = in.nextLine();
            if (input.equals("")) {break;}
            if (valueStorage.getRunAtFirstTime()) {
                valueStorage.setRunAtFirstTime(false);
                System.out.println("First Time");
                runFirstTime(input);
            } else {runSecondTime(input);}
        }
    }

    void runFirstTime(String input) {
        arr = checkValue.check(input);
        if (!(arr[0].matches("Error.*"))) {
            numOne = checkType(arr[0]).check(arr[0]);
            numTwo = checkType(arr[2]).check(arr[2]);
            mathOper = arr[1].charAt(0);
            expr(numOne, numTwo, mathOper);
            System.out.println(arr[0] + arr[1] + arr[2] + "=" + valueStorage.getResult());
        } else {
            System.out.println(arr[0]);
        }
    }

    void runSecondTime(String input) {

        arr = checkValue.checkSecondValue(input);
        if (arr[0].matches("[*/+\\-]")) {
            if (!(arr[0].matches("Error.*"))) {
                numOne = checkType(arr[1]).check(arr[1]);
                mathOper = arr[0].charAt(0);
                expr(numOne, mathOper);
                System.out.println(valueStorage.getResult() + arr[0] + arr[1] + "=" + valueStorage.getResult());
            } else {
                System.out.println(arr[0]);
            }
        }
        else {runFirstTime(input);}
    }


}