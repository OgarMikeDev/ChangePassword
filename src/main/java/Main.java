import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Character> alphabet = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Введите пароль: ");
        String inputPassword = new Scanner(System.in).nextLine();

        /*
        TODO Hello -> I(7 + 1)g(30 + 2)o(37 + 3)p(37 + 4)t(40 + 5) -> Igopt
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
        String decryptedPassword = decryptedPassword(encryptionPassword);
        System.out.println("Исходный пароль: " + inputPassword +
                "\nЗашифрованный пароль: " + encryptionPassword +
                "\nРасшифрованный пароль: " + decryptedPassword);
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

    public static String decryptedPassword(String encryptionPassword) {
        String decryptedPassword = "";

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
        for (int indexForLetterPassword = 0; indexForLetterPassword < encryptionPassword.length(); indexForLetterPassword++) {
            char letterPassword = encryptionPassword.charAt(indexForLetterPassword);
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
                        decryptedPassword += letter;
                    } else {
                        decryptedPassword += alphabet.get(indexForLetterAlphabet - step);
                    }
                }
            }
            step++;
        }
        return decryptedPassword;
    }

    // public static void main(String[] args) {
    //     String password = "Hello10";
    //     String keyPassword = "";
    //     for (int i = 0; i < password.length(); i++) {
    //         Random r = new Random();
    //         char symbol = (char) r.nextInt(65, 122);
    //         keyPassword += symbol;
    //     }
    //     System.out.println("Введённый пароль: " + password);
    //     String encryptionPassword = encryptionPassword(password, keyPassword);
    //     System.out.println("Зашифрованный пароль: " + encryptionPassword);
    //     String decryptionPassword = decryptionPassword(encryptionPassword, keyPassword);
    //     System.out.println("Расшифрованный пароль: " + decryptionPassword);
    // }

    // /*
    // TODO
    //  Text: Hello10
    //  Key: N]D_TMJ
    //  Ключ и текст одинаковой длины.
    //  Переходим в цикл for, где обращаемся к элементам ключа и текста с одинаковым индексом.
    //  H ^ N;
    //  H = 72 в десятеричной;
    //  N = 78 в десятеричной;
    //  72 ^ 78 ->
    //  1001000 ^ 1001110 = (шифротекст) 0000110 (6 в десятичной) ->
    //     символ при шифровании в десятичной системе счисления (char) 6 =
    //     ACK - символ подтверждения получения (не печатается).
    //     И так для каждого символа пароля и ключа
    //     В итоге получился зашифрованный текст: 8(3;|z
    //  */
    // public static String encryptionPassword(String password, String keyPassword) {
    //     System.out.println("Ключ: " + keyPassword);
    //     String encryptionPassword = "";
    //     for (int i = 0; i < password.length(); i++) {
    //         //TODO ^ побитовая операция XOR(исключающее или)
    //         encryptionPassword += (char) (password.charAt(i) ^ keyPassword.charAt(i));
    //     }
    //     return encryptionPassword;
    // }

    // public static String decryptionPassword(String encryptionPassword, String keyPassword) {
    //     String decryptionPassword = "";
    //     for (int i = 0; i < encryptionPassword.length(); i++) {
    //         //TODO ^ побитовая операция XOR(исключающее или)
    //         decryptionPassword += (char) (encryptionPassword.charAt(i) ^ keyPassword.charAt(i));
    //     }
    //     return decryptionPassword;
    // }
}
