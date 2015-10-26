package my.decided.tasks.level31.lesson06.home01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path filename = Paths.get(args[0]);
        Path zipArchive = Paths.get(args[1]);
        Map<ZipEntry,byte[]> map = new HashMap<ZipEntry,byte[]>();
        InputStream is = Files.newInputStream(zipArchive);
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(is));
        try {
            ZipEntry ze;
            while ((ze = zis.getNextEntry()) != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;
                while ((count = zis.read(buffer)) != -1) {
                    baos.write(buffer, 0, count);
                }
                String ziEntryName = ze.getName();
                byte[] bytes = baos.toByteArray();
                map.put(ze, bytes);
            }
        } finally {
            zis.close();
        }
        OutputStream os = Files.newOutputStream(zipArchive);
        ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(os));
        try {
            for (Map.Entry<ZipEntry,byte[]> entry : map.entrySet()) {
                if(entry.getKey().getName().equals(filename.toFile().getName())){
                    InputStream inputStream = Files.newInputStream(filename);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int count;
                    while ((count = inputStream.read(buffer)) != -1) {
                        baos.write(buffer, 0, count);
                    }
                    byte[] bytes = baos.toByteArray();
                    zos.putNextEntry(entry.getKey());
                    zos.write(bytes);
                    zos.closeEntry();
                    inputStream.close();
                }else{
                    zos.putNextEntry(entry.getKey());
                    zos.write(entry.getValue());
                    zos.closeEntry();
                }
            }
        } finally {
            zos.close();
        }
    }
}
