package my.decided.tasks.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение, вывести в консоль переданное неправильное имя файла и завершить работу программы
Не забудьте закрыть все потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            String s = br.readLine();
           try {

               fis = new FileInputStream(s);
           }
           catch (FileNotFoundException e) {
               System.out.println(s);
               br.close();
               break;
           }
        }
    }
}
