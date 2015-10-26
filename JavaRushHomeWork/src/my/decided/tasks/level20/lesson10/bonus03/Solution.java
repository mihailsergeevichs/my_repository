package my.decided.tasks.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        List<Word> list = detectAllWords(crossword, "home", "same", "poeej", "fulm", "rek", "gsf", "rj", "rrj", "mglp", "jhvok", "orgn");
        for (Word w : list) {
            System.out.println(w);
        }

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> result = new ArrayList<>();
        for(String word : words) {
            char[] wordArray = word.toCharArray();
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if(wordArray[0] == crossword[i][j]){
                        int[] res = searchAllDirection(crossword, i, j, wordArray);
                        if(res != null){
                            Word resultWord = new Word(word);
                            resultWord.setStartPoint(j, i);
                            resultWord.setEndPoint(res[0], res[1]);
                            result.add(resultWord);
                            break;
                        }else {
                            continue;
                        }
                    }

                }
            }
        }
        return result;
    }
    private static int[] searchAllDirection(int[][] crossword, int firstXPosition, int firstYPosition, char[] word){
        int[] lactCharCoords = null;
        for(int i = 0; i < 8; i++){
            if(lactCharCoords != null){
                break;
            }
            lactCharCoords = concreteSideSearch(crossword, firstXPosition, firstYPosition, word, i);
        }
        return lactCharCoords;
    }

    private static int[] concreteSideSearch(int[][] crossword, int firstXPosition, int firstYPosition, char[] word, int direction){

        int[] lastCharCoords = new int[2];
        int count = 0;
        for(int i = 0; i < word.length; i++){
            if(firstXPosition < 0 && firstXPosition > crossword.length && firstYPosition < 0 && firstYPosition > crossword[firstXPosition].length){
                break;
            }
            try {
                if (crossword[firstXPosition][firstYPosition] == word[i]) {
                    count++;
                    if (count == word.length) {
                        break;
                    }
                    if (direction == 0) {
                        firstXPosition--;
                    }
                    if (direction == 1) {
                        firstXPosition++;
                    }
                    if (direction == 2) {
                        firstYPosition--;
                    }
                    if (direction == 3) {
                        firstYPosition++;
                    }
                    if (direction == 4) {
                        firstXPosition--;
                        firstYPosition--;
                    }
                    if (direction == 5) {
                        firstXPosition--;
                        firstYPosition++;
                    }
                    if (direction == 6) {
                        firstXPosition++;
                        firstYPosition--;
                    }
                    if (direction == 7) {
                        firstXPosition++;
                        firstYPosition++;
                    }

                } else {
                    break;
                }
            }catch (IndexOutOfBoundsException e){}
        }
        if(count == word.length){
            lastCharCoords[0] = firstYPosition;
            lastCharCoords[1] = firstXPosition;
            return lastCharCoords;
        }
        return null;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
