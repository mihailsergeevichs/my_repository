package my.decided.tasks.level17.lesson10.bonus01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        //start here - начни тут
        if (args[0].equals("-c"))
        {
            Person person;
            String name = args[1];
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            if (args[2].equals("м")){
                person = Person.createMale(name, format.parse(args[3]));
                allPeople.add(person);
            }
            if (args[2].equals("ж")){
                person = Person.createFemale(name, format.parse(args[3]));
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }

        }
        else if ((args[0].equals("-u")))
        {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            person.setName(args[2]);
            person.setBirthDay(format.parse(args[4]));
            if (args[4].equals("м"))
            {
                person.setSex(Sex.MALE);
            }
            if (args[4].equals("ж"))
            {
                person.setSex(Sex.FEMALE);
            }
        }
        else if ((args[0].equals("-d")))
        {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDay(null);
        }
        else if ((args[0].equals("-i")))
        {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
            System.out.println(person.getName() + " " + sex + " " + format.format(person.getBirthDay()));
        }
    }
}
