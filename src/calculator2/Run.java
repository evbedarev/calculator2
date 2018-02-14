package calculator2;

import java.util.Arrays;
import java.util.Scanner;

public class Run {

    private Calculate calculate = calcExpr('*');  //Интерфейс вычислений
    private ValueStorage valueStorage = new ValueStorage(); //Класс хранения результата
    private Scanner in  = new Scanner(System.in);
    VerifyAtFirstTimeOrNot verify = new VerifyAtFirstTimeOrNot(); //интерфейс проверки валидности выражения и какой раз производят вычисления.
    private String[] arr;

    void run () {
        String input = in.nextLine();
        arr = verify.launch(input);

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

//Проверяет первое выражение или нет и запускает соответствующий метод.

class VerifyAtFirstTimeOrNot {
    static boolean atFirstTime = true;

    VerifyLaunchAtFirstTime verifyLaunchAtFirstTime = verify("");

    public String[] launch(String cmd) {
        return verify(cmd).check(cmd);
    }

    static VerifyLaunchAtFirstTime verify (String cmd) {
        if (atFirstTime) {return new CheckValue();}
        else
            if (cmd.matches(" *[*+\\-/] *((?:[-+])?\\d+\\.?\\d*(?:[lLfF])?)$")) {
                return new CheckSecondValue();
            } else return new CheckValue();
    }

}
