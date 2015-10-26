package my.decided.tasks.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        String filename = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        //BufferedReader reader = new BufferedReader(new FileReader("e:/1.txt"));
        while(reader.ready()){
            String line = reader.readLine();
            String[] splitted = line.split(" ");
            int year = Integer.parseInt(splitted[splitted.length-1]);
            int month = Integer.parseInt(splitted[splitted.length-2]);
            int day = Integer.parseInt(splitted[splitted.length-3]);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < splitted.length-3; i++)
            {
                sb.append(splitted[i] + " ");

            }
            String name = sb.toString().substring(0, sb.length()-1);
            Date date = new GregorianCalendar(year, month-1, day).getTime();
            Person person = new Person(name, date);
            PEOPLE.add(person);

        }
        reader.close();
        //System.out.println(PEOPLE.get(0).getName() + " " +PEOPLE.get(0).getBirthday());
        //System.out.println(PEOPLE.get(1).getName() + " " + PEOPLE.get(1).getBirthday());

    }

}
