/**
 * Created by rook on 1/7/17.
 *
 */
public class Bonuses {

    public static void main(String args[]) {
        /*
        Uncomment to test.

        NOTE: I did not complete the following:
        * Weekdays
        * Currency
        * The Game Of Life
        * Bonus++
         */

        // fizzBuzz(1000);
        // containsFizzBuzz(35);

        // The below function returns 837799,
        // which has a chain 525 numbers long
        // System.out.println(largestCollatzChain(1000000));
    }

    private static void fizzBuzz(int n) {
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 5 == 0 && (i + 1) % 3 == 0) System.out.println("FizzBuzz");
            else if ((i + 1) % 5 == 0) System.out.println("Buzz");
            else if ((i + 1) % 3 == 0) System.out.println("Fizz");
            else System.out.println(i + 1);
        }
    }

    private static void containsFizzBuzz(int n) {
        for (int i = 0; i < n; i++) {
            if (contains3(i + 1) && contains5(i + 1)) System.out.println("FizzBuzz");
            else if ((contains5(i + 1))) System.out.println("Buzz");
            else if ((contains3(i + 1))) System.out.println("Fizz");
            else System.out.println(i + 1);
        }
    }

    private static boolean contains3 (int n) {
        return n % 10 == 3 || (n - (n % 10)) / 10 == 3;
    }

    private static boolean contains5 (int n) {
        return n % 10 == 5 || (n - (n % 10)) / 10 == 5;
    }

    private static int collatz(long n) {
        int collatzChainSize = 1;

        while (n != 1) {

            if (numberIsOdd(n)) n = (3 * n) + 1;
            else n = n / 2;
            collatzChainSize++;
        }
        return collatzChainSize;
    }

    private static boolean numberIsOdd(long n) {
        return (n % 2) != 0;
    }

    private static long largestCollatzChain(long n) {

        long numWithLargestChain = n;

        for (int i = 1; i < n; i++) {
            int currentCollatz = collatz(i);
            System.out.println("Current number: " + i + " - Chain size: " + currentCollatz);
            if (collatz(numWithLargestChain) < currentCollatz) {
                numWithLargestChain = i;
            }
        }
        return numWithLargestChain;
    }
}
