package my.decided.tasks.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename = br.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        while(reader.ready()){
            sb.append(reader.readLine());
        }
        String[] words = sb.toString().split(" ");
//        for(String word : words){
//            System.out.println(word);
//        }
        //...
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
        br.close();
        reader.close();
    }

    public static StringBuilder getLine(String... words) {
        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, words);
        StringBuilder sb = new StringBuilder();
        if (strings.size() == 0)
            return new StringBuilder();

        sb.append(strings.get(strings.size()-1));
        strings.remove(strings.size()-1);

        while (strings.size() != 0){
            for (int i = 0; i < strings.size(); i++) {
                String s1 = strings.get(i).toUpperCase().toLowerCase();
                String s2 = sb.toString().toUpperCase().toLowerCase();
                if (s1.charAt(0) == s2.charAt(sb.length() - 1)) {
                    sb.append(" ").append(strings.get(i));
                    strings.remove(i);
                    continue;
                }else if (s2.charAt(0) == s1.charAt(s1.length() - 1))
                {
                    sb.insert(0, " ");
                    sb.insert(0, strings.get(i));
                    strings.remove(i);
                }
            }
        }
        return sb;

    }
}
