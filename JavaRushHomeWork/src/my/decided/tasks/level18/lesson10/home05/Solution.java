package my.decided.tasks.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(br.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(br.readLine()));
        String line = reader.readLine();
        String[] array = line.split(" ");

        for (String s : array) {
            writer.write(String.valueOf(Math.round(Double.parseDouble(s))) + " ");
        }
        br.close();
        reader.close();
        writer.close();

    }
}
