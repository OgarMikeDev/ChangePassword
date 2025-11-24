import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Character> alphabetLetters = new ArrayList<>();
    public static void main(String[] args) {
        /*
        TODO
         Abd -> B(0 + 1)d(1 + 2)g(3 + 3) -> Bdg.
         */

        System.out.println("Введите пароль: ");
        String inputPassword = new Scanner(System.in).nextLine();
        System.out.println(changePassword(inputPassword));
    }

    public static String changePassword(String inputPassword) {
        String newPassword = "";

        for (int i = 65; i <= 122; i++) {
            if (i == 91) {
                i += 6;
            }
            char currentSymbol = (char) i;
            alphabetLetters.add(currentSymbol);
        }

        /*
        TODO
         .length() - кол-во букв в пароле.
         .size() - кол-во букв в алфавите.
         .charAt(int index) - получение текущего символа(буквы) по его индексу,
         inputPassword.charAt(0) при слове "Hello" -> "H"
         alphabetLetters.get(0) -> A;
         alphabetLetters.get(1) -> B;
         Напр-р, в слове Hello, .length() вернёт 5,
         а от Hello метод .chatAt(1) вернёт "e".
         Подсказка, использовать 2 цикла fori.
         1-й для обхода всех букв пароля,
         2-й для обхода каждой буквы с её индексом в алфавите
         ABD ->
         A - 0
         B - 1
         D - 3
         */
        int step = 1;
        for (int indexLetterInputPassword = 0; indexLetterInputPassword < inputPassword.length(); indexLetterInputPassword++) {
            char letterInputPassword = inputPassword.charAt(indexLetterInputPassword);
            for (int indexCurrentLetterAlphabet = 0; indexCurrentLetterAlphabet < alphabetLetters.size(); indexCurrentLetterAlphabet++) {
                char currentLetterAlphabet = alphabetLetters.get(indexCurrentLetterAlphabet);
                if (letterInputPassword == currentLetterAlphabet) {
                    //TODO Hello -> I(7 + 1)g(4 + 2)o(11 + 3)p(11 + 4)t(14 + 5) -> Igopt
                    newPassword += alphabetLetters.get(indexCurrentLetterAlphabet + step);
                }
            }
            step++;
        }
        return newPassword;
    }
}
