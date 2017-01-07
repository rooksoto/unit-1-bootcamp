
public class Conditionals {

    public static void main(String args[]) {
        System.out.println(isOdd(5));
        System.out.println(isMultipleOfThree(15));
        System.out.println(isOddAndIsMultipleOfThree(21));
        System.out.println(isOddAndIsMultipleOfThree2(9));
        fizzMultipleofThree(3);

    }

    // Wrote this one in the first exercise,
    // didn't realize we'd be writing it here!
    private static boolean isOdd(int num) {
        return (num % 2 != 0);
    }

    private static boolean isMultipleOfThree(int num) {
        return (num % 3 == 0);
    }

    private static boolean isOddAndIsMultipleOfThree(int num) {
        return ((num % 2 != 0) &&
                (num % 3 == 0));
    }

    private static boolean isOddAndIsMultipleOfThree2(int num) {
        return isOdd(num) && isMultipleOfThree(num);
    }

    private static void fizzMultipleofThree(int num) {
        if (isMultipleOfThree(num)) {
            System.out.println("Fizz");
        } else {
            System.out.println(num);
        }
    }
}
