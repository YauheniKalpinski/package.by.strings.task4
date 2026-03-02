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
        s = s.toLowerCase();
        if (s.isEmpty()) {
            System.out.println("Строка пустая и является палиндромом");
            return true;
        }

        char[] chars = s.toCharArray();
        boolean isLetters = isAllLetters(chars);

        if (isLetters) {
            int left;
            int right = chars.length - 1;
            int mismatchCount = 0;
            int mismatchIndex1 = 0;
            int mismatchIndex2 = 0;

            for (left = 0; left < right; left++, right--) {
                if (chars[left] != chars[right]) {
                    System.out.printf("Первый несовпадающий символ под индексом: %d," +
                            " второй под индексом: %d%n", left, right);
                    mismatchCount++;
                    mismatchIndex1 = left;
                    mismatchIndex2 = right;
                    break;
                }
            }
            if (mismatchCount == 0) {
                System.out.println("Строка паллиндром");
                return true;
            }

            char[] newArray1 = removeChar(chars, mismatchIndex1);
            char[] newArray2 = removeChar(chars, mismatchIndex2);

            boolean resultNewArray1 = isPallindrome(newArray1);
            boolean resultNewArray2 = isPallindrome(newArray2);

            if (resultNewArray1 || resultNewArray2) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("В строке должны быть только буквы");
            return false;
        }
    }

    public static boolean isAllLetters(char[] array) {
        for (char c : array) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPallindrome(char[] array) {
        int right = array.length - 1;
        for (int left = 0; left < right; left++, right--) {
            if (array[left] != array[right]) {
                return false;
            }
        }
        return true;
    }

    public static char[] removeChar(char[] chars, int indexToRemove) {
        char[] newArray1 = new char[chars.length - 1];
        System.arraycopy(chars, 0, newArray1, 0, indexToRemove);
        System.arraycopy(chars, indexToRemove + 1, newArray1, indexToRemove,
                chars.length - indexToRemove - 1);
        return newArray1;
    }
}
