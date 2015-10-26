package my.decided.tasks.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    static int counter = 0;
    static char currentChar = ' ';
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(br.readLine());

        String text = "";
        while (reader.ready())
        {
            currentChar = (char)reader.read();

            text = text+currentChar;

        }

        String replacedString = text.replaceAll("\\p{P}"," ").toLowerCase();
        replacedString=replacedString.replaceAll("\\s"," ");

        String splitString[] = replacedString.split(" ");
        for (String x : splitString) {
            if (x.equals("world")) {
                counter++;
            }
        }

        System.out.println(counter);
        reader.close();
        br.close();

    }


}