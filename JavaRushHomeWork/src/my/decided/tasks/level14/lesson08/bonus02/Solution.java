package my.decided.tasks.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i;
        int j;
        boolean flag = true;
        while(flag)
        {
                i = Integer.parseInt(reader.readLine());
                j = Integer.parseInt(reader.readLine());
                if (i <= 0 || j <= 0) {
                    i = Integer.parseInt(reader.readLine());
                    j = Integer.parseInt(reader.readLine());
                } else {
                    flag = false;
                    reader.close();
                    int a = nod(i, j);
                    System.out.println(a);
                }
            }
    }
    public static int nod(int i, int j)
    {
        if (j == 0) {
            return i;
        } else {
            return nod(j, i % j);
        }
    }
}
