package my.decided.tasks.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        String file3 = br.readLine();
        FileOutputStream fos = new FileOutputStream(file1);
        FileInputStream fis = new FileInputStream(file2);
        FileInputStream fis2 = new FileInputStream(file3);
        while(fis.available() > 0)
        {
            fos.write(fis.read());
        }
        while(fis2.available() > 0)
        {
            fos.write(fis2.read());
        }
        fos.close();
        fis.close();
        fis2.close();
    }
}
