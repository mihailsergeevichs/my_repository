package my.decided.tasks.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String searched = args[0];
        String filename = br.readLine();
        String line;
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while((line = reader.readLine()) != null)
        {
            list.add(line);
        }

        for(String s: list){
            String str = s.substring(0, s.indexOf(" "));
            if (searched.equals(str)){
                System.out.println(s);
            }
        }
        br.close();
        reader.close();

    }
}
