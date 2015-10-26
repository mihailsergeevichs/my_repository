package my.decided.tasks.level32.lesson02.task01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* Запись в файл
В метод main приходят три параметра:
1) fileName - путь к файлу
2) number - число, позиция в файле
3) text - текст
Записать text в файл fileName начиная с позиции number.
Если файл слишком короткий, то записать в конец файла.
*/
public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        String number = args[1];
        String text = args[2];
        String available = null;
        Integer position = Integer.parseInt(number);
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(fileName, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(position > raf.length()){
            try {
                raf.seek((long)raf.length());
                raf.writeBytes(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                raf.seek((long)position);
                raf.writeBytes(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
