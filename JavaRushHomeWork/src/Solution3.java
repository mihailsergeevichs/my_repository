/**
 * Created by Overlord on 13.06.2015.
 */
/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости
*/

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public static Map<String,String> countries = new HashMap<String,String>();
    static{
        countries.put("UA", "Ukraine");
        countries.put("RU"," Russia");
        countries.put("CA", "Canada");
    }


    public static class IncomeDataAdapter implements Customer, Contact  {

        private IncomeData incomedata;
        public  IncomeDataAdapter(IncomeData incomedata){
            this.incomedata=incomedata;
        }


        @Override
        public String getName() {
            String s = incomedata.getContactLastName() + ", " + incomedata.getContactFirstName();
            return s;
        }

        @Override
        public String getPhoneNumber() {

            String s = incomedata.getPhoneNumber() + "";
            while(s.length() < 10)
            {
                s = "0" + s;
            }
            String result = "+" + incomedata.getCountryCode() + "(" + s.substring(0, 3) + ")" + s.substring(3, 6) + "-" + s.substring(6, 8) + "-" + s.substring(8,10);
            return result;
        }

        @Override
        public String getCompanyName() {
            String result = incomedata.getCompany();
            return result;
        }

        @Override
        public String getCountryName() {
            String result = countries.get(incomedata.getCountryCode());
            return result;
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        int getCountryPhoneCode();      //example 38
        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}
