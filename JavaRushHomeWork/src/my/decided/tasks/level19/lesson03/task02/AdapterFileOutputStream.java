package my.decided.tasks.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream a;

    AdapterFileOutputStream(FileOutputStream a)
    {
        this.a = a;
    }

    @Override
    public void flush() throws IOException {
        a.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        a.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        a.close();
    }
}

