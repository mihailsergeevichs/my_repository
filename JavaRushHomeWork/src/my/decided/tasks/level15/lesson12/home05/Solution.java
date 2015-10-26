package my.decided.tasks.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution(){}
    public Solution(String s){}
    public Solution(Float f){}
    Solution(Double d){}
    Solution(Boolean b){}
    Solution(Integer i){}
    protected Solution(Byte b){}
    protected Solution(Short sh){}
    protected Solution(Character ch){}
    private Solution(Object o){}
    private Solution(Class c){}
    private Solution(Long l){}

}

