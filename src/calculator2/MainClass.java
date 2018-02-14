package calculator2;

import java.util.Arrays;
import java.util.regex.Pattern;

public class MainClass {

    public static void main(String[] args) {
//        Run start = new Run();
//        start.run();
        mv("111111111.33333L");

    }

    static private void mv (String num) {
        CheckValue parse = new CheckValue();
        Long numL;
        Double numD = Double.MAX_VALUE;
        if (num.matches("(?:[+-])?\\d+\\.\\d+(?:[lLfF])?$")) {
            num = parse.retArr(Pattern.compile("((?:[+-])?\\d+)\\.\\d+(?:[lLFf]$)?"),2, num, "Error")[0];
            numL = Long.parseLong(num+"L", 10);
            if (numL < numD) {
                System.out.println(numL + " < " + numD);
            }

        }
    }

}

