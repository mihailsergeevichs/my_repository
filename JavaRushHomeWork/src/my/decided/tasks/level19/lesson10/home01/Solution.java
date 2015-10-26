package my.decided.tasks.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader =  new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new HashMap<String,Double>();
        Map<String, Double> result = new TreeMap<String, Double>();

        String currentLine;
        while ((currentLine = reader.readLine()) != null) {

            String[] pair  = currentLine.split(" ");

            String key = pair[0];
            Double value = Double.parseDouble(pair[1]);
            if(map.containsKey(key)){
                value +=  map.get(key);
            }
            map.put(key,value);
        }
        for(Map.Entry<String, Double> entry : map.entrySet())
        {
            result.put(entry.getKey(), entry.getValue());
        }
        for(Map.Entry<String, Double> entry : result.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
