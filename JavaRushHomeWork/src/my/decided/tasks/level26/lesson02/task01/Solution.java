package my.decided.tasks.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        double median;
        int middle = array.length / 2;
        if(array.length % 2 == 1)
            median = array[middle];
        else
            median = ( array[middle-1] + array[middle] ) / 2.0;
        final double med = median;
        Comparator<Integer> mediancmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                int result1 = Math.abs((int) ((double) o1 - med));
                int result2 = Math.abs( (int)((double)o2 - med) );
                int addendum = (result1 == result2) ? ((o1 > o2) ? 1 : -1) : 0;

                int result  = (result1 - result2) * 10 + addendum;
                return result;
            }
        };

        Arrays.sort(array, mediancmp);
        //implement logic here
        return array;
    }


    public static void main(String[] args) {
        Integer[] array = {5, 8, 13, 15 ,17};
        sort(array);
        for(Integer i : array){
            System.out.println(i);
        }
    }

}
