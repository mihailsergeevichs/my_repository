package my.decided.tasks.level35.lesson08.bonus01;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K, V> Map<K, V> convert(List<? extends Convertable<K>> list) {
        Map result = new HashMap();
        for(int i = 0; i < list.size(); i++){
            result.put(list.get(i).getKey(), list.get(i));
        }
        return result;
    }
}
