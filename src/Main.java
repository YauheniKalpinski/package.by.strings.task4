import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово");
        String text = scanner.nextLine();
        scanner.close();
        boolean isValid = validPalindrome(text);
        System.out.println("Output: " + isValid);
    }

    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        boolean isLetters = isAllLetters(chars);

        if (!s.isEmpty() && isLetters) {
            int i;
            int j = chars.length - 1;
            int matchCount = 0;
            int mismatchCount = 0;
            int mismatchIndex = 0;

            for (i = 0; i < j; i++, j--) {
                if (chars[i] == chars[j]) {
                    matchCount++;
                } else {
                    System.out.println("Найден не совпадающий символ под индексом: " + i);
                    mismatchCount++;
                    mismatchIndex = i;
                }
            }

            char[] newArray = new char[chars.length - 1];

            for (i = 0; i < mismatchIndex; i++) {
                newArray[i] = chars[i];
            }

            for (i = mismatchIndex + 1; i < chars.length; i++) {
                newArray[i - 1] = chars[i];
            }

            for (i = 0; i < newArray.length; i++) {
                System.out.print(newArray[i]);
            }
            return isPallindrome(newArray);

        } else if (s.isEmpty()) {
            System.out.println("Строка пустая это паллиндром");
        }
        return true;
    }

    public static boolean isAllLetters(char[] array) {
        for (char c : array) {
            if (!Character.isLetter(c)) {
                System.out.println("В строке должны быть только буквы");
                return false;
            }
        }
        return true;
    }

    public static boolean isPallindrome(char[] array) {
        String finalString = new String(array);
        String reverse = new StringBuilder(finalString).reverse().toString();
        if (finalString.equals(reverse)) {
            System.out.println();
            System.out.println("Строка является палиндромом");
            return true;
        } else {
            System.out.println();
            System.out.println("Строка не является палиндромом");
            return false;
        }
    }
}
