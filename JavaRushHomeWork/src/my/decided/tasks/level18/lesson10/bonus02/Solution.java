package my.decided.tasks.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        //String file = "e:/1.txt";
        BufferedReader br2 = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String index = "";
        String productName = "";
        String price = "";
        String quantity = "";
        String result = null;
        //if(args[0].equals("-с") && args.length == 4){
            StringBuilder sb = new StringBuilder();
            while (br2.ready()){
                sb.append(br2.readLine());
            }
            String s = sb.toString();
            try {
                int lastindex = Integer.parseInt(s.substring(s.length() - 50, s.length() - 42));
                index = String.valueOf(lastindex += 1);
            }
            catch (StringIndexOutOfBoundsException e){index = "1";}
            if(index.length() < 8){
                index = concatspaces(index, 8);
            }
            if(index.length() > 8){
            index = productName.substring(0, 8);
                }
            productName = args[1];
            //productName = "dfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdfg";
            if(productName.length() < 30){
                productName = concatspaces(productName, 30);
            }
            if(productName.length() > 30){
                productName = productName.substring(0, 30);
            }
            price = args[2];
            //price = "54345345345";
            if(price.length() < 8){
                price = concatspaces(price, 8);
            }
            if(price.length() > 8){
                price = price.substring(0, 8);
            }
            quantity = args[3];
            //quantity = "344534345";
            if(quantity.length() < 4){
                quantity = concatspaces(quantity, 4);
            }
            if(quantity.length() > 4){
                quantity = quantity.substring(0, 4);
            }
            br2.close();
            reader.close();
        //}
        result = (stringBuilder.append("\n").append(index).append(productName).append(price).append(quantity)).toString();
        System.out.println(productName.length());
        System.out.println(price.length());
        System.out.println(quantity.length());
        System.out.println(result);
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            out.println(result);
            out.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }




    }
    public static String concatspaces(String target, int countspaces){
        while (target.length() < countspaces){
            target = target + " ";
        }
        return target;

    }
}
