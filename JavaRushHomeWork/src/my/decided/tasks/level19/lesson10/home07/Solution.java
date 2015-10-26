package my.decided.tasks.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];
        BufferedReader br1 = new BufferedReader(new FileReader(file1));
        BufferedWriter br2 = new BufferedWriter(new FileWriter(file2));
        //BufferedReader br1 = new BufferedReader(new FileReader("e:/1.txt"));
        //BufferedWriter br2 = new BufferedWriter(new FileWriter("e:/2.txt"));
        List<String> words = new ArrayList<String>();
        while(br1.ready()){
            String line = br1.readLine();
            String[] splitted = line.split(" ");
            for(String word : splitted){
                if(word.length() > 6){
                    words.add(word);
                }
            }
        }
        String result = null;
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            sb.append(word + ",");
        }
        result = sb.substring(0, sb.length()-1).toString();
        //System.out.println(result);
        br2.write(result);
        br1.close();
        br2.close();
    }
}
