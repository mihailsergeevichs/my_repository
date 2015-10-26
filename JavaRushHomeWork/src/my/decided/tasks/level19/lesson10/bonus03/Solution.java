package my.decided.tasks.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        String openTag = args[0];
//        String openTag = "span";
        String openTagWithBrace = "<" + openTag + ">";
//        System.out.println(openTagWithBrace);
        openTag = "<" + openTag;
//        System.out.println(openTag);
        String tag = openTag.substring(1, openTag.length()); //  span
        String closeTag = openTag.substring(0, 1) + "/" + tag + ">";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = null;
        FileReader fileReader = null;
        try {
            file = new String(Files.readAllBytes(Paths.get(br.readLine())));
//            file = new String(Files.readAllBytes(Paths.get("e:/1.txt")));
        } catch (IOException e) {}
        ArrayList<Integer> startIndexes = new ArrayList<>();
        ArrayList<Integer> endIndexes = new ArrayList<>();
        String openTagReplace = "";
        while(openTagReplace.length() < openTag.length()){
            openTagReplace = " " + openTagReplace;
        }
        String closeTagReplace = "";
        while(closeTagReplace.length() < closeTag.length()){
            closeTagReplace = " " + closeTagReplace;
        }
        file = file.replaceAll(System.lineSeparator(), "");
        String original = new String(file);
        Pattern pattern = Pattern.compile("<(/)?"+ tag + "(>)?+$?");
        Matcher matcher = pattern.matcher(original);
        while(matcher.find()){
            if(matcher.group().equals(openTag)){
                startIndexes.add(original.indexOf(matcher.group()));
                endIndexes.add(null);
                original = original.replaceFirst(matcher.group(), openTagReplace);
            }
            if(matcher.group().equals(openTagWithBrace)){
                startIndexes.add(original.indexOf(matcher.group()));
                endIndexes.add(null);
                original = original.replaceFirst(matcher.group(), openTagReplace + " ");
            }
            if(matcher.group().equals(closeTag)){
                int i = endIndexes.lastIndexOf(null);
                endIndexes.set(i, original.indexOf(matcher.group()) + closeTag.length());
                original = original.replaceFirst(matcher.group(), closeTagReplace);
            }
        }
        for(int i = 0; i < startIndexes.size(); i++){
            System.out.println(file.substring(startIndexes.get(i), endIndexes.get(i)));
        }
    }

}
