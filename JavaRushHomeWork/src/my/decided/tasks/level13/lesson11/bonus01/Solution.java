package my.decided.tasks.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String location = reader.readLine();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        BufferedReader is = new BufferedReader(new FileReader(location));
        while(is.ready())
        {
            int data = Integer.parseInt(is.readLine());
            if(data % 2 == 0)
            {temp.add(data);}
        }
        reader.close();
        is.close();
        Collections.sort(temp);
        for (Integer t : temp)
        {
                System.out.println(t);
        }



    }
}
