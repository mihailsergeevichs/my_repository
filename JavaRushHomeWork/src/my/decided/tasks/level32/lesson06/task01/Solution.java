package my.decided.tasks.level32.lesson06.task01;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.Character;
import java.util.*;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Каждый сгенерированный символ пароля пишите сразу в ByteArrayOutputStream.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    private static Set<String> passwords = new HashSet<>();
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        Set<String> passwords = new HashSet<>();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> numbers = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            numbers.add(String.valueOf(i));
        }
        ArrayList<String> lowerCaseCharacters = new ArrayList<>();
        for(int i = 'a'; i <= 'z'; i++){
            lowerCaseCharacters.add(String.valueOf(Character.toChars(i)));
        }ArrayList<String> upperCaseCharacters = new ArrayList<>();
        for(int i = 'A'; i <= 'Z'; i++){
            upperCaseCharacters.add(String.valueOf(Character.toChars(i)));
        }
        Random random = new Random();



        String randCharLow = lowerCaseCharacters.get(random.nextInt(lowerCaseCharacters.size()-1));
        baos.write(randCharLow.getBytes());
        String randNumber = numbers.get(random.nextInt(numbers.size()-1));
        baos.write(randNumber.getBytes());
        String randCharUpper = upperCaseCharacters.get(random.nextInt(numbers.size()-1));
        baos.write(randCharUpper.getBytes());
        String randCharLow1 = lowerCaseCharacters.get(random.nextInt(lowerCaseCharacters.size()-1));
        baos.write(randCharLow1.getBytes());
        String randNumber1 = numbers.get(random.nextInt(numbers.size()-1));
        baos.write(randNumber1.getBytes());
        String randCharUpper1 = upperCaseCharacters.get(random.nextInt(numbers.size()-1));
        baos.write(randCharUpper1.getBytes());
        String randCharLow2 = lowerCaseCharacters.get(random.nextInt(lowerCaseCharacters.size()-1));
        baos.write(randCharLow2.getBytes());
        String randNumber2 = numbers.get(random.nextInt(numbers.size()-1));
        baos.write(randNumber2.getBytes());

        if(passwords.contains(sb.toString())){
            getPassword();
        }
        else {
            return baos;
        }
        return baos;

    }
}
