package my.decided.tasks.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        FileInputStream fis = new FileInputStream(filename);
        int p1 = 0;
        int p2 = 0;
        while (fis.available()> 0){
            if (fis.read() == 32){ p2++; p1++;}
            else {p1++;}
        }

        fis.close();
        double d = (double) p2/p1*100;
        System.out.println(String.format("%.2f", d));
    }
}
