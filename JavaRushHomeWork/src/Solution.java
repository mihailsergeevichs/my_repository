/* ��������� �����
�������� � ������� ��� �����
� ������ main ��������� ������ System.out ���������� ���� �����-�������� �� �������� � �������
���� �����-������� ������ ����������� ����� ����� ������ � ����, ��� �������� �� �������
�������� ������� ����� printSomething(), �������������� testString
������� ���������� System.out �������������� �����
�������� ����� �����

������ ������ �� �����:
it's a text for testing

������ ���� �����:
it's a text for testing
*/

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintStream cs = System.out;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(os);
        System.setOut(output);
        testString.printSomething();
        String temp = os.toString();
        BufferedWriter writer = new BufferedWriter(new FileWriter(br.readLine()));
        writer.write(temp);
        System.setOut(cs);
        System.out.println(temp);
        os.close();
        output.close();
        br.close();
        writer.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
