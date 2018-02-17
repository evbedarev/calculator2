package calculator2.checktype;

public class CheckTypeNum extends CheckTypeFloat {

    public Double check(String num) {
        return isMaxValue(Long.parseLong(num,10));
    }
}
