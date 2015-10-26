package my.decided.tasks.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fs = new FileInputStream(args[0]);
        int count = 0;
        while (fs.available() > 0) {
            int data = fs.read();
            if (data > 64 && data < 91 || data > 96 && data < 123) {
                count++;
            }
        }
        System.out.print(count);
    }
}
