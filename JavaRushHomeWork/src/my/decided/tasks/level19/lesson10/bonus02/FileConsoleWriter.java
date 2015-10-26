package my.decided.tasks.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;

public class FileConsoleWriter extends FileWriter {

    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        super(fd);
    }

    @Override
    public String getEncoding() {
        return super.getEncoding();
    }

    @Override
    public void write(int c) throws IOException {
        System.out.print((char) c);
        super.write(c);

    }

    @Override
    public void write(char[] cbuf) throws IOException {

        super.write(cbuf);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        System.out.print(String.valueOf(cbuf).substring(off, len + off));
        super.write(cbuf, off, len);
    }

    @Override
    public void write(String str) throws IOException {

        super.write(str);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        System.out.print(str.substring(off, len + off));
        super.write(str, off, len);
    }

    @Override
    public Writer append(CharSequence csq) throws IOException {
        return super.append(csq);
    }

    @Override
    public Writer append(CharSequence csq, int start, int end) throws IOException {
        return super.append(csq, start, end);
    }

    @Override
    public Writer append(char c) throws IOException {
        return super.append(c);
    }

    @Override
    public void flush() throws IOException {
        super.flush();
    }

    @Override
    public void close() throws IOException {
        super.close();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
    public static void main(String[] args) throws IOException{
        FileConsoleWriter writer = new FileConsoleWriter("e:/1.txt");
        writer.write("Тестовая строка".toCharArray());
        writer.write("Тестовая строка");
        writer.write(1);
        writer.write("Тестовая строка", 0, 4);
        writer.write("Тестовая строка".toCharArray(), 0, 4);
        writer.close();
    }
}
