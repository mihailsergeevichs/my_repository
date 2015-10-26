package my.decided.tasks.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution[] s = new Solution[2];
        s[0] = new Solution();
        s[1] = new Solution();
        s[0].innerClasses[0] = new Solution(). new InnerClass();
        s[0].innerClasses[1] = new Solution(). new InnerClass();

        s[1].innerClasses[0] = new Solution(). new InnerClass();
        s[1].innerClasses[1] = new Solution(). new InnerClass();
        return  s;
    }
}
