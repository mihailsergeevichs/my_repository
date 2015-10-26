package my.decided.tasks.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(br.readLine());
        FileOutputStream output2 = new FileOutputStream(br.readLine());
        byte[] b = new byte[input.available()];
        input.read(b);
        for(int i = b.length-1; i>=0; i--)
        {
            output2.write(b[i]);
        }
        br.close();
        input.close();
        output2.close();
    }
}
