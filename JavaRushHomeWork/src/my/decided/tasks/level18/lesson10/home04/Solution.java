package my.decided.tasks.level18.lesson10.home04;
 
/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream inputStream1 = new FileInputStream(fileName1);

        ArrayList<Integer> list = new ArrayList<Integer>();

        while (inputStream1.available() > 0) {
            int i = inputStream1.read();
            list.add(i);
        }

        FileInputStream inputStream2 = new FileInputStream(fileName2);
        FileOutputStream outputStream = new FileOutputStream(fileName1);

        while (inputStream2.available() > 0) {
            int i = inputStream2.read();
            outputStream.write(i);
        }

        PrintStream out = new PrintStream(new BufferedOutputStream(outputStream));

        for (int elem : list) {
            out.write(elem);
            out.flush();
        }

        inputStream1.close();
        inputStream2.close();
        outputStream.close();
        out.close();
        reader.close();
    }
}