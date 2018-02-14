package calculator2;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CheckValue implements VerifyLaunchAtFirstTime{

    public String[] check (String cmd) {

        String[] groups = new String[4];
        Pattern pattern3 = Pattern.compile("^((?:[-+])?\\d+\\.?\\d*(?:[lLfF])?) *([*+\\-/]) *((?:[-+])?\\d+\\.?\\d*(?:[lLfF])?)$");
        Pattern pattern1 = Pattern.compile("^((?:[-+])?\\d+\\.?\\d*(?:[lLfF])?).*");
        Pattern pattern2 = Pattern.compile("^((?:[-+])?\\d+\\.?\\d*(?:[lLfF])?) *([*+\\-/]).*");


        groups = retArr(pattern1, 2, cmd, "Error, wrong expr at first number");
        if (groups[0].matches("Error.*")) {
            return groups;
        }

        groups = retArr(pattern2, 3, cmd, "Error, wrong expr at mathematical operation");
        if (groups[0].matches("Error.*")) {
            return groups;
        }

        groups = retArr(pattern3, 4, cmd, "Error, wrong expr at second number");
        if (groups[0].matches("Error.*")) {
            return groups;
        }

        return groups;

    }


    //получает паттерн и колличество групп в паттерне, строку в которой будет производится поиск и сообщение ошибки
    public String[] retArr(Pattern pat1, int val, String cmd, String msg) {

        String[] groups = new String[4];
        Matcher m = pat1.matcher(cmd);

        if (m.find()) {
            for (int i=1; i<val; i++) {
                groups[i-1] = m.group(i);
            }

        } else {
            groups[0] = msg;

        }
        return groups;

    }
}


class CheckSecondValue extends CheckValue {
    public String[] check (String cmd) {
        String[] groups = new String[4];
        Pattern pattern = Pattern.compile(".*= *(-?\\d+\\.?\\d*(?:[lLfF])?) *([*+\\-/]) *(-?\\d+\\.?\\d*(?:[lLfF])?)$");

        groups = retArr(pattern, 4, cmd, "Error, wrong expr at second nuber or mathematical operation");
        if (groups[0].matches("Error.*")) {
            return groups;
        }
        return groups;

    }
}

