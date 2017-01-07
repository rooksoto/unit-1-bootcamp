import java.util.ArrayList;
import java.util.List;

public class Loops {

    public static void main(String args[]) {

        /*
        Tested then commented out
        Uncomment to run
         */

        // loopToTen();
        // loopToTen2();
        // loopToN(7);
        // loopEvenToN(7);
        // loopAndSumToTen();
        // loopAndSumToN(3);

        // ***** Exercise 7 *****
        loopAndSumToN(10000); // Result is 50005000!

        // printStringNTimes(-5, "Testing");
        // concatStringNTimes(-5, "Testing");
        // fibonacciToTen();
        // fibonacciSumToTen();
        // fibonacciSumToN(11);
        System.out.println(sumNumbers("7 11"));
        System.out.println(notReplace("This is right"));
        System.out.println(wordEnds("XY1XY", "XY"));
        System.out.println(numberPuzzle());
        digits();
    }

    // Exercise 1
    private static void loopToTen() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
        }
    }

    // Exercise 2
    private static void loopToTen2() {
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i < 11);
    }

    // Exercise 3
    private static void loopToN(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1);
        }
    }

    // Exercise 4
    private static void loopEvenToN(int n) {
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 2 == 0) {
                System.out.println(i + 1);
            }
        }
    }

    // Exercise 5
    private static void loopAndSumToTen() {
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += (i + 1);
        }
        System.out.println(result);
    }

    // Exercise 6
    private static void loopAndSumToN(int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += (i + 1);
        }
        System.out.println(result);
    }

    // Exercise 8
    private static void printStringNTimes(int n, String s) {
        if (n < 0) {
            System.out.println("");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.println(s);
            }
        }
    }

    // Exercise 9
    private static void concatStringNTimes(int n, String s) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += s;
        }
        System.out.println(result);
    }

    //Exercise 10
    private static void fibonacciToTen() {
        int fibonacci;
        int num1 = 0;
        int num2 = 1;

        System.out.println(num1);
        System.out.println(num2);
        for (int i = 0; i < 8; i++) {
            fibonacci = num1 + num2;
            num1 = num2;
            num2 = fibonacci;
            System.out.println(fibonacci);
        }
    }

    //Exercise 11
    private static void fibonacciSumToTen() {
        int fibonacci;
        int num1 = 0;
        int num2 = 1;
        int result = 1;

        for (int i = 0; i < 8; i++) {
            fibonacci = num1 + num2;
            num1 = num2;
            num2 = fibonacci;
            result += (fibonacci);
        }
        System.out.println(result);
    }

    // Exercise 12
    private static void fibonacciSumToN(int n) {
        int fibonacci;
        int num1 = 0;
        int num2 = 1;
        int result = 1;

        for (int i = 0; i < (n - 2); i++) {
            fibonacci = num1 + num2;
            num1 = num2;
            num2 = fibonacci;
            result += (fibonacci);
        }
        System.out.println(result);
    }

    private static int sumNumbers(String string) {
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                int count = 0;
                for (int j = i; j < string.length(); j++) {
                    if (Character.isDigit(string.charAt(j))) count++;
                    else break;
                }
                sum += Integer.parseInt(string.substring(i, i + count));
                i += count;
            }
        }
        return sum;
    }

    private static String notReplace(String string) {
        String result = "";
        //Brilliant trick I learned online to avoid
        // corner case issues
        string = " " + string + "  ";
        for (int i = 0; i < string.length() - 2; i++) {
            if (string.charAt(i) == 'i') {
                if (string.charAt(i + 1) == 's'
                        && !Character.isLetter(string.charAt(i + 2))
                        && !Character.isLetter(string.charAt(i - 1))) {
                    result += "is not";
                    i += 1;
                } else result += "i";
            } else result += string.charAt(i);
        }
        return result.substring(1);
    }

    private static String wordEnds(String string, String word) {
        String result = "";
        int position = string.indexOf(word);
        while (position != -1) {
            if (position != 0) result += string.charAt(position-1);
            if (position + word.length() == string.length()) break;
            result += string.charAt(position + word.length());
            position = string.indexOf(word, position+1);
        }
        return result;
    }

    private static List<String> numberPuzzle () {
        List<String> result = new ArrayList<>();
        for (int i = 10; i < 100; i++) {
            for (int j = 10; j < 100; j++) {
                if(j + i == 60 && j - i == 14) {
                    result.add(j + " & " + i);
                }
            }
        }
        return result;
    }

    // I didn't need nested loops for this question,
    // so I'm thinking I misunderstood it
    private static void digits () {
        for (int i = 10; i < 100; i++) {
            int tens = (i - (i % 10)) / 10;
            int ones = i % 10;
            int sum = tens + ones;

            System.out.println(i
                    + ", "
                    + tens
                    + "+"
                    + ones
                    + " = "
                    + sum);
        }
    }
}
