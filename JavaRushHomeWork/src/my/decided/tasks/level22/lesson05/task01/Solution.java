package my.decided.tasks.level22.lesson05.task01;

import java.util.ArrayList;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }
    public static String getPartOfString(String string) throws TooShortStringException {

        if(string==null)
        {
            throw new TooShortStringException();
        }
        int begin = string.indexOf(" ");
        if (begin == -1)
        {
            throw new TooShortStringException();
        }
        ArrayList<Integer> indexes = new ArrayList<>();
        int index = 0;
        while(index >= 0) {
            index = string.indexOf(" ", index+1);
            indexes.add(index);

        }
        if(indexes.get(3) == -1)
        {
            throw new TooShortStringException();
        }
        String result = string.substring(begin + 1, indexes.get(4));
        return result;
    }

    public static class TooShortStringException extends Exception {
    }
}
