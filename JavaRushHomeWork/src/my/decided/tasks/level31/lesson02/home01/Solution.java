package my.decided.tasks.level31.lesson02.home01;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.*;
import java.util.*;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path directory = Paths.get(args[0]);
        Path fileName = Paths.get(args[1]);
//        Path directory = Paths.get("e:/111");
//        Path fileName = Paths.get("e:/111/1.txt");
        ArrayList<Path> filelist = new ArrayList<>();

        Queue<File> queue = new ArrayDeque<>();
        Collections.addAll(queue, directory.toFile().listFiles());
        while (!queue.isEmpty()){
            File file = queue.poll();
            if (file.isDirectory()) {
                if (file.listFiles().length > 0){
                    Collections.addAll(queue, file.listFiles());
                }else {
                    file.delete();
                }
            }else {
                if(file.equals(fileName.toFile())){

                }else {
                    if (file.length() > 50) {
                        file.delete();
                    } else {
                        filelist.add(Paths.get(file.toString()));
                    }
                }
            }
        }
        Collections.sort(filelist, new Comparator<Path>() {
            @Override
            public int compare(Path o1, Path o2) {
                return o1.getFileName().compareTo(o2.getFileName());
            }
        });
        OutputStream outputStream = Files.newOutputStream(fileName);

        for (Path path : filelist){
            InputStream inputStream = Files.newInputStream(path);
            byte[] buffer = new byte[8 * 1024];
            int len;
            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
            outputStream.write(System.lineSeparator().getBytes());
            inputStream.close();
        }
        outputStream.close();
        Files.move(fileName, fileName.resolveSibling("allFilesContent.txt"));
    }
}
