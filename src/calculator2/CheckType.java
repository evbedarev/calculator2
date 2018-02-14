package calculator2;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class CheckType {
    String numOne;
    String numTwo;
    Long numL;
    char oper[];


    private Double verifyType(String num) {
        double firstNum;

        if (num.matches(".*[fF]$")) {
            firstNum = Float.valueOf(num);
            return firstNum;

        } else if (num.matches(".*[lL]$")) {
            firstNum = Long.parseLong(num,10); //Удаляем в конце lL
            return firstNum;
        } else {
            firstNum = Double.valueOf(num);
            return firstNum;
        }
    }


//    private String splitArray(String[] arr) {
//        ArrayList<Double> nums= new ArrayList<Double>();
//        for (String s:arr) {
//            if (s.matches("(?:[+-])?\\d+\\.?\\d+")) {
//                this.num = verifyType(s);
//            } else if (s.matches("[*/\\-+]")){
//                this.oper = s.toCharArray();
//            }
//
//        }
//    }

    private Double isMaxValue(String num) {
        CheckValue parse = new CheckValue();

        if (num.matches("(?:[+-])?\\d+\\.\\d+(?:[lLfF])?$")) {
            num = parse.retArr(Pattern.compile("((?:[+-])?\\d+)\\.\\d+(?:[lLFf]$)?"),2, num, "Error")[1];
            return compare(num);

        } else {
            numL = Long.parseLong(num);
            return compare(num);
        }

    }

    private Double compare(String num) {
        numL = Long.parseLong(num);

        if (numL < Double.MAX_VALUE) {
            return Double.parseDouble(num);
        } else {
            return 0.0;
        }

    }

}
