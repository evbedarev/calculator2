package calculator2;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class CheckType {

}

class CheckTypeFloat implements VerifyType{
    String stringNum;

    public Double check(String num) {
        return isMaxValue(Float.valueOf(num).longValue());
    }

    Double isMaxValue(Long num) {
        if (num < Double.MAX_VALUE) {
            return num.doubleValue();
        } else {
            return Double.MAX_VALUE; //Must be exception
        }

    }
}

class CheckTypeNum extends CheckTypeFloat {

    public Double check(String num) {
        return isMaxValue(Long.parseLong(num,10));
    }
}

class CheckTypeLong extends CheckTypeFloat {
    public Double check(String num) {
        return isMaxValue(Long.parseLong(num.substring(0, num.length() - 1))); //Удаляем в конце lL
    }
}

class CheckTypeChar extends CheckTypeFloat {
    public Double check(String num) {
        return isMaxValue((long)num.charAt(0)); //Удаляем в конце lL
    }
}

class CheckTypeBin extends CheckTypeFloat {
    CheckValue checkValue = new CheckValue();

    public Double check(String num) {
        stringNum = checkValue.retArr(Pattern.compile("0b([01]+)"),2, num, "Error")[0];
        return isMaxValue(Long.parseLong(stringNum,2));
    }
}

class CheckTypeHex extends CheckTypeBin {

    public Double check(String num) {
        stringNum = checkValue.retArr(Pattern.compile("0x([0-9a-fA-F]+)"),2, num, "Error")[0];
        System.out.println(stringNum);
        return isMaxValue(Long.parseLong(stringNum,16));
    }
}

class CheckTypeOcta extends CheckTypeBin {

    public Double check(String num) {
        stringNum = checkValue.retArr(Pattern.compile("0([0-7]+)"),2, num, "Error")[0];
        return isMaxValue(Long.parseLong(stringNum,8));

    }
}