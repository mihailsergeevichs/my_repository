package my.decided.tasks.level13.lesson11;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* ����
1. ��������� ������(���������) � �������, ���� ������������ �� ������ ������ ������(Enter).
2. ������ �������� ������������� ����� ����.
��� ������� ���������:
3. ������� ������ cat ������ Cat, ������� ����� ���� �� getCatByKey(String ��������).
4. ������� �� ����� cat.toString().
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            String name = reader.readLine();
            if (name.equals("")) {
                break;
            }
            else
            {
                Cat cat = CatFactory.getCatByKey(name);
                System.out.println(cat.toString());
            }
        }
    }

    static class CatFactory
    {

        static Cat getCatByKey(String key)
        {
            Cat cat = null;
            if ("vaska".equals(key))
            {
                cat = new MaleCat("�������");
            } else if ("murka".equals(key))
            {
                cat = new FemaleCat("�������");
            } else if ("kiska".equals(key))
            {
                cat = new FemaleCat("��������");
            } else
            {
                cat = new Cat(key);
            }

            return cat;
        }
    }

    static class Cat
    {
        private String name;

        protected Cat(String name)
        {
            this.name = name;
        }

        public String getName()
        {
            return this.name;
        }

        public String toString()
        {
            return "� ������� ��� " + getName();
        }
    }

    static class MaleCat extends Cat
    {
        MaleCat(String name)
        {
            super(name);
        }

        public String toString()
        {
            return "� - �������� ����� �� ����� " + getName();
        }
    }

    static class FemaleCat extends Cat
    {
        FemaleCat(String name)
        {
            super(name);
        }

        public String toString()
        {
            return "� - ����� ������� �� ����� " + getName();
        }
    }
}

