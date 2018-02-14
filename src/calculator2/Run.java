package calculator2;

import java.util.Arrays;
import java.util.Scanner;

public class Run {

    Calculate calculate = calcExpr('*');
    ValueStorage valueStorage = new ValueStorage();
    Scanner in  = new Scanner(System.in);
    CheckValue checkValue = new CheckValue();
    String[] arr;

    void run () {
        String input = in.nextLine();


        expr(22.2,33.5,'q');
        if (calculate!=null) { expr(2.0,'/');}
        System.out.println(valueStorage.getResult());
    }

    void expr(Double num, char operator) {
        calculate = calcExpr(operator);
        if (calculate!=null) { valueStorage.setResult(calculate.calc(valueStorage.getResult(),num)); }
    }

    void expr(Double numOne, Double numTwo, char operator) {
        calculate = calcExpr(operator);
        if (calculate!=null) { valueStorage.setResult(calculate.calc(numOne,numTwo)); }
    }

    static Calculate calcExpr(char oper) {
        if (oper == '+') { return new Plus();}
        else if (oper == '*') { return new Multi();}
        else if (oper == '/') { return new Dev();}
        else  if (oper == '-') { return new Substr();}
        else return null;
    }

}
