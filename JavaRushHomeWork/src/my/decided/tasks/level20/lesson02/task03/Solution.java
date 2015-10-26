package my.decided.tasks.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    Properties p = new Properties();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InputStream is = new FileInputStream(br.readLine());
        load(is);
        br.close();


        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter pw = new PrintWriter(outputStream);

        int size = p.size();
        if(size > 0) {
            p.putAll(properties);
        }
        p.store(outputStream, "no comment");
        pw.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        p.load(inputStream);
        for (String s : p.stringPropertyNames()) {
            properties.put(s, p.getProperty(s));
        }
    }
}
