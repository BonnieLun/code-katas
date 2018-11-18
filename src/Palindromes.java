import java.util.HashSet;
import java.util.Set;

public class Palindromes {

    public static void main(String[] args) {
        String string = "barbarabar";

        int count = howManyPalindromeInString(string);

        System.out.println(count);

//        System.out.println(min());

    }

    private static Integer howManyPalindromeInString(String word) {
        int count = 0;
        for (int start = 0; start <= word.length(); start++) {
            for (int sec = start + 1; sec <= word.length(); sec++) {
                String substring = word.substring(start, sec);
                if (isPalindrome(substring)) {
                    System.out.println(substring);
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPalindrome(String word) {
        for (int start = 0, end = word.length() - 1; start <= end; start++, end--) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
        }
        return true;
    }

    private static boolean duplicates() {
        int[] numbers = new int[]{1, 2, 3, 4, 1};
        Set<Integer> mySet = new HashSet<>();

        for (int num : numbers) {
            if (mySet.contains(num)) {
                return true;
            } else {
                mySet.add(num);
            }
        }
        return false;

    }


    private static int min() {
        int[] numbers = new int[]{3, 4, 0, 1, 2};

        int first = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < first) {
                return numbers[i];
            } else {
                first = numbers[i];
            }
        }
        return first;
    }

}
