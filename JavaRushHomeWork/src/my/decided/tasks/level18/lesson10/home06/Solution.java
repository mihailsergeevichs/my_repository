package my.decided.tasks.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String s = args[0];
        FileInputStream fs = new FileInputStream(s);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        TreeMap<Object, Object> map2 = new TreeMap<>();
        while(fs.available() > 0)
        {
            int i = fs.read();
            list.add(i);
        }
        Collections.sort(list);
        for (int i : list)
        {
            map.put(i, Collections.frequency(list, i));
        }
        for (Map.Entry entry : map.entrySet()) {
            map2.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry entry : map2.entrySet()) {
            int i = Integer.valueOf((Integer) entry.getKey());
            System.out.println((char)i + " " + entry.getValue());
        }


        fs.close();

    }
}
