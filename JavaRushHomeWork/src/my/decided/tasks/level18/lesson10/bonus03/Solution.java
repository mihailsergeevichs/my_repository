package my.decided.tasks.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

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
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        //String file = "e:/1.txt";
        BufferedReader br2 = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder compiled = new StringBuilder();
        String index = "";
        String productName = "";
        String price = "";
        String quantity = "";
        String newstring = "";
        String oldstring = "";
        String s = "";
        while(br2.ready()){
            stringBuilder.append(br2.readLine()).append(System.lineSeparator());
        }
        s = stringBuilder.toString();
        //System.out.println(s);
        if(args[0].equals("-u")){
            //index = "198478";
            index = args[1];
            if(index.length() < 8){
                index = concatspaces(index, 8);
            }
            if(index.length() > 8){
                index = index.substring(0, 8);
            }
            productName = args[2];
            //productName = "dfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdfg";
            if(productName.length() < 30){
                productName = concatspaces(productName, 30);
            }
            if(productName.length() > 30){
                productName = productName.substring(0, 30);
            }
            price = args[3];
            //price = "54345345345";
            if(price.length() < 8){
                price = concatspaces(price, 8);
            }
            if(price.length() > 8){
                price = price.substring(0, 8);
            }
            quantity = args[4];
            //quantity = "344534345";
            if(quantity.length() < 4){
                quantity = concatspaces(quantity, 4);
            }
            if(quantity.length() > 4){
                quantity = quantity.substring(0, 4);
            }
            newstring = compiled.append(index).append(productName).append(price).append(quantity).append(System.lineSeparator()).toString();
            int indexoldstring = s.indexOf(index);
            oldstring = s.substring(indexoldstring, indexoldstring + 49);
            //System.out.println(oldstring);
            //System.out.println(newstring);
            s = s.replaceAll(oldstring, newstring);
            //System.out.println(s);
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, false)));
                out.println(s);
                out.close();
                } catch (IOException e) {
            //exception handling left as an exercise for the reader
            }
            reader.close();
            br2.close();
        }
        if(args[0].equals("-d")){
            //index = "198478";
            index = args[1];
            if(index.length() < 8){
                index = concatspaces(index, 8);
                }
            if(index.length() > 8){
                index = index.substring(0, 8);
                }
            int indexoldstring = s.indexOf(index);
            oldstring = s.substring(indexoldstring -1, indexoldstring + 49);
            s = s.replace(oldstring, "");
            System.out.println(s);
                    try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, false)));
                out.println(s);
                out.close();
                } catch (IOException e) {

                }
            reader.close();
            br2.close();
        }



    }

    public static String concatspaces(String target, int countspaces){
        while (target.length() < countspaces){
            target = target + " ";
        }
        return target;
    }
}
