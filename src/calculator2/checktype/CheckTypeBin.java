package calculator2.checktype;

import calculator2.CheckValue;

import java.util.regex.Pattern;

public class CheckTypeBin extends CheckTypeFloat {
    CheckValue checkValue = new CheckValue();

    public Double check(String num) {
        stringNum = checkValue.retArr(Pattern.compile("0b([01]+)"),2, num, "Error")[0];
        return isMaxValue(Long.parseLong(stringNum,2));
    }
}
