package my.decided.tasks.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner sc;
        PersonScannerAdapter(Scanner sc)
        {
            this.sc = sc;
        }

        @Override
        public Person read() throws IOException {

            int i = 0;
            String string = sc.nextLine();
            String[] line = string.split(" ");
            String lastName = line[0];
            String middleName = line[2];
            String firstName = line[1];
            int j = line.length;
            Calendar cal = new GregorianCalendar(Integer.parseInt(line[5]), Integer.parseInt(line[4])-1, Integer.parseInt(line[3]));
            Date birthDate = cal.getTime();
            Person p = new Person(firstName, middleName, lastName, birthDate);
            return p;
        }

        @Override
        public void close() throws IOException {
            sc.close();
        }
    }
}
