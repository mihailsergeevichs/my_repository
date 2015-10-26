package my.decided.tasks.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File folder = new File(root);
        List<String> list = new LinkedList<>();

        Queue<File> queue = new ArrayDeque<>();
        Collections.addAll(queue, folder.listFiles());

        while (!queue.isEmpty()){
            File file = queue.poll();
            if (file.isDirectory()) {
                if (file.listFiles().length > 0){
                    Collections.addAll(queue, file.listFiles());
                }else {
                    file.delete();
                }
            }else {
                list.add(file.getAbsolutePath());
            }
        }
        return list;
    }
}
