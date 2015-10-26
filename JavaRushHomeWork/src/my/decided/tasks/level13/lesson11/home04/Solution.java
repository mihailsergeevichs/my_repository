package my.decided.tasks.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dest = reader.readLine();
        OutputStream os = new FileOutputStream(dest);
        while(true)
        {
            String s = reader.readLine();

            if (!s.equals("exit")) {
                String f = (s + "\r\n");
                byte[] b = f.getBytes();
                os.write(b);
            }
            else
            {
                String f = (s + "\r\n");
                byte[] b = f.getBytes();
                os.write(b);
                break;
            }
        }
        os.close();
        reader.close();
    }
}
