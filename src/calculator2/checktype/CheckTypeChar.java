package calculator2.checktype;

public class CheckTypeChar extends CheckTypeFloat {
    public Double check(String num) {
        return isMaxValue((long)num.charAt(0)); //Удаляем в конце lL
    }
}
