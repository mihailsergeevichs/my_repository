package my.decided.tasks.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(s));
        while (reader.ready())
        {
            line = reader.readLine();
            String[] array = line.split(" ");
            int count = 0;
            Map<Integer, String> map = new HashMap<>();
                for(String target : array)
                {
                    if(words.contains(target))
                    {
                         count++;
                    }
                }
            if(count == 2){
                System.out.println(line);
            }

        }
        br.close();
        reader.close();

    }
}
