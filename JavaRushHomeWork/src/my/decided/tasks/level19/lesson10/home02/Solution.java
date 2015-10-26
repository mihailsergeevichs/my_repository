package my.decided.tasks.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
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
        TreeMap<Double, String> result = new TreeMap<Double, String>();

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
            result.put(entry.getValue(), entry.getKey());
        }
        double res = result.lastKey();
        System.out.println(result.get(res));
    }
}