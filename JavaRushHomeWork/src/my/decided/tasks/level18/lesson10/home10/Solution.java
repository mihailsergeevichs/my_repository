package my.decided.tasks.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream output;
        BufferedInputStream input;
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        String partname;
        while(!(partname = br.readLine()).equals("end"))
        {
            int index = partname.indexOf(".part");
            String is = partname.substring(index+5, partname.length());
            map.put(Integer.parseInt(is), partname);
        }
        Integer firstKey = map.firstKey();
        String fileOutStr = map.get(firstKey).substring(0, map.get(firstKey).indexOf(".part"));
        output = new FileOutputStream(fileOutStr);
        for (Map.Entry<Integer, String> pair: map.entrySet()) {
            String fileNamePart = pair.getValue();
            input = new BufferedInputStream(new FileInputStream(fileNamePart));
            int data;
            while ((data = input.read()) != -1) {
                output.write(data);
            }
        }
        br.close();
    }
}

