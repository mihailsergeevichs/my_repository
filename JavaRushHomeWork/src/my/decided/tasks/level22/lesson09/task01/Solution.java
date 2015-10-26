package my.decided.tasks.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sss = reader.readLine();
        BufferedReader br = new BufferedReader(new FileReader(sss));
        CopyOnWriteArrayList<String> words = new CopyOnWriteArrayList<>();
        while(br.ready()){
            String s = br.readLine() + " ";
            words.addAll(Arrays.asList(s.substring(0, s.length() - 1).split(" ")));
        }
        for (String word : words){
            for(String revers : words) {
                if(word.equals(new StringBuilder(revers).reverse().toString()) && word != revers)
                {
                    result.add(new Pair(word, revers));
                    words.remove(word);
                    words.remove(revers);
                }
            }
        }
        for(Pair pair : result){
            System.out.println(pair);
        }
        reader.close();
        br.close();

    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
