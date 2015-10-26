package my.decided.tasks.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
        HashSet<String> hs = new HashSet<String>();
        String currentLine;
        while ((currentLine = br.readLine()) != null) {

            String[] pair = currentLine.split(" ");

            for (String res : pair) {
                char[] ch = res.toCharArray();
                for (char c : ch) {
                    if (Character.isDigit(c)) {
                        hs.add(res + " ");
                    }
                }
            }


        }
        for(String s : hs)
        {
            bw.write(s);
        }

        bw.close();
        br.close();
        reader.close();

    }
}
