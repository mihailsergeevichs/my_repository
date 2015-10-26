package my.decided.tasks.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);

        ArrayList<String> words = new ArrayList<>();
        while(st.hasMoreTokens()){
            words.add(st.nextToken());
        }
        String[] bar = words.toArray(new String[words.size()]);
        return bar;
    }

    public static void main(String[] args) {
        String[] tokens = getTokens("level22.lesson13.task01", ".");
        for(String s : tokens){
            System.out.println(s);
        }
    }
}
