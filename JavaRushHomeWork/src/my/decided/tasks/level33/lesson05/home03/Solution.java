package my.decided.tasks.level33.lesson05.home03;



import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/* Десериализация JSON объекта
НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.4.3

В метод convertFromJsonToNormal первым параметром приходит имя файла, который содержит один ДЖЕЙСОН объект.
Вторым параметром приходит имя класса, объект которого находится в файле.
Метод convertFromJsonToNormal должен вычитать объект из файла, преобразовать его из JSON и вернуть его.
*/
public class Solution {

    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.disableDefaultTyping();
        T result = mapper.readValue(new File(fileName), clazz);
        return result;
    }
}
