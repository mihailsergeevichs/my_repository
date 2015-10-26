package my.decided.tasks.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution {
    private static final int KEY = 10;
    public static void main(String[] args) throws Exception {
        if (args[0].equals("-e")) {
            String in = args[1];
            String out = args[2];
            FileInputStream input = new FileInputStream(in);
            FileOutputStream output = new FileOutputStream(out);
            while (input.available() > 0) {
                int data = input.read();
                output.write(crypted(data, KEY));
            }
            input.close();
            output.close();
        } else if (args[0].equals("-d")) {
            String in = args[1];
            String out = args[2];
            FileInputStream input = new FileInputStream(in);
            FileOutputStream output = new FileOutputStream(out);
            while (input.available() > 0) {
                int data = input.read();
                output.write(crypted(data, KEY));
            }
            input.close();
            output.close();
        }
    }

    public static int crypted(int data, int key) {
        return data^key;
    }

}



