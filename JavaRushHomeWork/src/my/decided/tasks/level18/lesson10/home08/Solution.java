package my.decided.tasks.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> filenames = new ArrayList<>();
        String s = "";
        while(!(s=br.readLine()).equals("exit")){
            filenames.add(s);
        }
        br.close();
        for(String filename : filenames){
            try{
            new ReadThread(filename).start();}
            catch (Exception e){}
        }
        System.out.println(resultMap.isEmpty());

    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
            //implement constructor body
        }

        @Override
        public void run() {
            try
            {
                FileInputStream stream = new FileInputStream(fileName);
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                while (stream.available() > 0)
                {
                    Integer c = stream.read();
                    Integer count = map.get(c);
                    map.put(c, (count == null ? 0 : count + 1));
                }
                Map.Entry<Integer, Integer> entry = map.entrySet().iterator().next();
                for (Map.Entry<Integer, Integer> e : map.entrySet())
                {
                    if (e.getValue() > entry.getValue())
                    {
                        entry = e;
                    }
                }
                synchronized (Solution.class)
                {
                    resultMap.put(fileName, entry.getKey());
                }
                stream.close();
            }
            catch (IOException e)
            {

            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
