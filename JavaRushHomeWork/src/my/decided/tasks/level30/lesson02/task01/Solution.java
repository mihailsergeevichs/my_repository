package my.decided.tasks.level30.lesson02.task01;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

/* Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        if(s.startsWith("0b")){
            s = s.substring(2, s.length());
            if(s.length() < 8){
                while(s.length() != 8){
                    s = "0" + s;
                }
            }
            return String.valueOf(Integer.parseInt(s, 2));
        }

        if(s.startsWith("0x")){
            return String.valueOf(Integer.decode(s));
        }

        if(s.startsWith("0")){
            return String.valueOf(Integer.decode(s));
        }
        else return s;
    }
}
