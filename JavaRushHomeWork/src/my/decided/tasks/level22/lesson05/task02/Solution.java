package my.decided.tasks.level22.lesson05.task02;



/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("kjhgksdhg   ldfjglkdjfg lkdjfgkjdf  jgjhg"));
    }
    public static String getPartOfString(String string) throws TooShortStringException {

        if(string==null)
        {
            throw new TooShortStringException();
        }
        int begin = string.indexOf("\t");;
        if (begin == -1)
        {
            throw new TooShortStringException();
        }
        int end = string.indexOf("\t", begin+1);
        if(end == -1)
        {
            throw new TooShortStringException();
        }
        String result = string.substring(begin + 1, end);
        return result;
    }

    public static class TooShortStringException extends Exception {
    }
}
