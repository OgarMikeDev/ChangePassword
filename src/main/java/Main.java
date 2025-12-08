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

//     public static void main(String[] args) {
//         System.out.println("Введите пароль: ");
//         //TODO Hello10
//         String password = new Scanner(System.in).nextLine();
//         //TODO key имеет размер как и у пароля
//         String key = "TRS5sdy";
//         //TODO Прохождение по итерациям, равным кол-ву символов в пароле
// //        for (int i = 0; i < password.length(); i++) {
// //            Random random = new Random();
// //            /*
// //            TODO цифры, англ-е буквы и другие символы.
// //             Сначала возвращается индекс в пределах от 48 до 122 включительно.
// //             Затем с помощью (char) индекс заменяется символов,
// //             кот-й этот индекс имеет,
// //             напр-р, при индекс 65 символ будет является "A"
// //             */
// //            key += (char) random.nextInt(48, 123);
// //        }
// //        System.out.println("Пароль, введённый пользователем: " + password);
//         System.out.println("Ключ для пароля: " + key);
//         /*
//         TODO
//          Пароль: Hello10 -> (0)H(1)e(2)l(3)l(4)o(5)1(6)0;
//          Ключ: TRS5sdy;
//          Зашифрованный пароль: 7?YUI -> (0)(1)7(2)?(3)Y(4)(5)U(6)I
//          */
//         String encryptionPassword = encryptPassword(password, key);
//         System.out.println("Зашифрованный пароль: " + encryptionPassword);
//         String originPassword = decryptPassword(encryptionPassword, key);
//         System.out.println("Расшифрованный пароль: " + originPassword);
//     }

//     public static String encryptPassword(String password, String key) {
//         String encryptionPassword = "";
//         for (int indexSymbolPassword = 0; indexSymbolPassword < password.length(); indexSymbolPassword++) {
//             /*
//             TODO
//              Исключающее ИЛИ -> если равны, то 0, если не равны, то 1
//              Пароль Hello10, ключ TRS5sdy, зашифрованный пароль 7?YUI
//              1) l преобразуется в десятичный формат, т.е. в индекс 108; S в 83
//              2) 108 преобразуется в двоичный формат -> 1101100; 83 в 1010011
//              3) 1101100 ^ 1010011 -> Исключающее ИЛИ(если символы одинаковы -> 0, иначе 1) -> 0111111
//              4) 0111111 из двоичного формата переводится в десятичный, т.е. в 63
//              5) Преобразование 63 в char, т.е. в ?
//              */
//             /*
//             TODO Задание:
//              Пароль Hello10, ключ TRS5sdy, зашифрованный пароль 7?YUI
//              Из зашифрованного пароля 7?YUI получить символ (5)"U",
//              с помощью символа в Hello10 с индексом 5
//              и символа в TRS5sdy с индексом 5.
//              Если символов в двоичном коде меньше 7, то в начало добавляется 0
//              1) 1 в 49; d в 100
//              2) 49 в 110001; 100 в 1100100
//              3) 0110001 ^ 1100100 -> 1010101
//              4) 1010101 в 85
//              5) 85 в U
//              */
//             encryptionPassword += (char) (password.charAt(indexSymbolPassword) ^ key.charAt(indexSymbolPassword));
//         }
//         return encryptionPassword;
//     }

//     public static String decryptPassword(String encryptionPassword, String key) {
//         String originPassword = "";
//         for (int indexSymbolPassword = 0; indexSymbolPassword < encryptionPassword.length(); indexSymbolPassword++) {
//             /*
//             TODO Задание:
//              Написать алгоритм разшифровки 6-го элемента в encryptionPassword -> U в 1
//              Зашифрованный пароль 7?YUI, ключ TRS5sdy, пароль Hello10
//              1) U в 85, d в 100
//              2) 85 в 1010101, 100 в 1100100
//              3) 1010101 ^ 1100100 -> 0110001
//              4) 0110001 в 49
//              5) 49 в 1
//              */
//             originPassword += (char) (encryptionPassword.charAt(indexSymbolPassword) ^ key.charAt(indexSymbolPassword));
//         }
//         return originPassword;
//     }
}
