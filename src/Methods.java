import java.util.Random;

public class Methods {

    public static void main(String args[]) {

        // Tested method calls here

        System.out.println(calculateSquare(3));
        System.out.println(calculateSquareRoot(4));
        System.out.println(toLowerCase("OpEn YoUr EyEs"));
        System.out.println(isMultiple(5, 100));
        prettyInteger(10);
        System.out.println(random(1, 2));
    }

  /*
  Methods
  */

    private static int calculateSquare(int n) {
        return n * n;
    }

    // I know I can cast the result as an int,
    // but I'm favoring accuracy here
    // pardon the decimal (too lazy to format)
    private static double calculateSquareRoot(int n) {
        return Math.sqrt(n);
    }

    // Using Java inbuilt String method
    private static String toLowerCase(String string) {
        return string.toLowerCase();
    }

    private static boolean isMultiple(int a, int b) {
        return b % a == 0;
    }

    private static void prettyInteger(int n) {
        String stars = "";

        for (int i = 0; i < n; i++) {
            stars += "*";
        }

        System.out.println(stars + " " + n + " " + stars);
    }

    private static int random(int a, int b) {
        Random random = new Random();
        return random.nextInt((Math.abs(a - b)) + 1) +
                Math.min(a, b);
    }
}
