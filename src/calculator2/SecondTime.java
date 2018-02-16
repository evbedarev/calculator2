package calculator2;

public class SecondTime extends FirstTime{
    public ValueStorage verifyRunAtFirstTime(String[] arr) {
        Double numOne;
        Double numTwo;
        char mathOper;

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
