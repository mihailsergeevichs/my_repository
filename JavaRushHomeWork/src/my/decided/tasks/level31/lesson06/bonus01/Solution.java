package my.decided.tasks.level31.lesson06.bonus01;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFile = args[0];
        String[] array = new String[args.length-1];
        for(int i = 1; i < args.length; i++){
            array[i-1] = args[i];
        }
        Arrays.sort(array);
        Vector<FileInputStream> v = new Vector<FileInputStream>(array.length);
        for (int i = 0; i < array.length; i++) {
            v.add(new FileInputStream(array[i]));
        }
        Enumeration<FileInputStream> e = v.elements();
        SequenceInputStream sequenceInputStream = new SequenceInputStream(e);
        ZipInputStream is = new ZipInputStream(sequenceInputStream);
        try {
            for (ZipEntry entry = null; (entry = is.getNextEntry()) != null;) {
                OutputStream os = new BufferedOutputStream(new FileOutputStream(resultFile));
                try {
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
                    for (int readBytes = -1; (readBytes = is.read(buffer, 0, bufferSize)) > -1;) {
                        os.write(buffer, 0, readBytes);
                    }
                    os.flush();
                } finally {
                    os.close();
                }
            }
        } finally {
            is.close();
        }
    }
}
