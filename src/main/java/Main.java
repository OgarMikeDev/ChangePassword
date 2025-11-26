import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Character> alphabet = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Введите пароль: ");
        String inputPassword = new Scanner(System.in).nextLine();

        /*
        TODO Hello -> I(7 + 1)g(4 + 2)o(11 + 3)p(11 + 4)t(14 + 5) -> Igopt
         (7 + 1) ->
            7 - индекс буквы "H" в английском алфавите(начинается с 0);
            1 - порядковый номер текущей буквы("H") в слове(начинается с 1)
         */
        for (int i = 65; i <= 122; i++) {
            if (i == 91) {
                i += 6;
            }
            Character currentChar = (char) i;
            alphabet.add(currentChar);
        }

        String encryptionPassword = encryptionPassword(inputPassword);
        System.out.println("Исходный пароль: " + inputPassword +
                "\nЗашифрованный пароль: " + encryptionPassword);
    }

    public static String encryptionPassword(String inputPassword) {
        String encryptionPassword = "";

        /*
        TODO
         ABD:
            A -> 0;
            B -> 1;
            D -> 3
            Подсказка:
            1) Обойти каждую букву пароля.
            Для получения кол-ва букв пароля(.length()).
            Для получения текущей буквы(.charAt(int index)).
            2) Обойти каждую букву алфавита для каждой буквы исходного пароля.
            Для получения кол-ва букв алфавита(.size()).
            Для получения текущей буквы алфавита(.get(int index)).
            3) Сравнить буквы исходного пароля и текущей в алфавите
            и вывести индекс и её саму в консоль
         */
        int step = 1;
        for (int indexForLetterPassword = 0; indexForLetterPassword < inputPassword.length(); indexForLetterPassword++) {
            char letterPassword = inputPassword.charAt(indexForLetterPassword);
            for (int indexForLetterAlphabet = 0; indexForLetterAlphabet < alphabet.size(); indexForLetterAlphabet++) {
                char letterAlphabet = alphabet.get(indexForLetterAlphabet);
                if (letterPassword == letterAlphabet) {
                    //TODO y в слове "Fly", 50
                    if (indexForLetterAlphabet + step > alphabet.size() - 1) {
                        int index = indexForLetterAlphabet + step; //TODO 53
                        System.out.println("Index: " + index);
                        int real = index - (alphabet.size() - 1); //todo 2
                        System.out.println("Real: " + real);
                        char letter = alphabet.get(real - 1);
                        System.out.println("Letter: " + letter);
                        encryptionPassword += letter;
                    } else {
                        encryptionPassword += alphabet.get(indexForLetterAlphabet + step);
                    }
                }
            }
            step++;
        }
        return encryptionPassword;
    }
}
