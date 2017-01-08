
public class Conditionals {

    public static void main(String args[]) {
        System.out.println(isOdd(5));
        System.out.println(isMultipleOfThree(15));
        System.out.println(isOddAndIsMultipleOfThree(21));
        System.out.println(isOddAndIsMultipleOfThree2(9));
        fizzMultipleofThree(3);

        // Extra
        System.out.println(cigarParty(100, true));
        System.out.println(caughtSpeeding(65, true));
        System.out.println(alarmClock(0, false));
        System.out.println(lotteryTicket(1, 1, 1));
        System.out.println(blackjack(19, 23));
        System.out.println(evenlySpaced(5, 5, 5));

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

    private static boolean cigarParty(int cigars, boolean isWeekend) {
        if (cigars >= 40) {
            if (cigars <= 60 || isWeekend) {
                return true;
            }
        }
        return false;
    }

    private static int caughtSpeeding(int speed, boolean isBirthday) {
        if (isBirthday) speed -= 5;
        if (speed >= 81) return 2;
        if (speed > 60) return 1;
        return 0;
    }

    private static String alarmClock(int day, boolean vacation) {
        if (day > 0 && day < 6) {
            if (vacation) return "10:00";
            return "7:00";
        }
        if (day == 0 || day == 6) {
            if (vacation) return "off";
            return "10:00";
        }
        return "off";
    }

    private static int lotteryTicket(int a, int b, int c) {
        if (a == b && b == c) return 20;
        if (a == b || b == c || c == a) return 10;
        return 0;
    }

    private static int blackjack(int a, int b) {
        if (a > 21 && b <= 21) return b;
        if (b > 21 && a <= 21) return a;
        if (a <= 21 && b <= 21) {
            if ((21 - b) < (21 - a)) return b;
            if ((21 - a) < (21 - b)) return a;
        }
        return 0;
    }

    private static boolean evenlySpaced(int a, int b, int c) {
        if (a == b && b == c) return true;
        if (a == b || b == c || c == a) return false;

        return Math.abs(a - b) == Math.abs(b - c) ||
                Math.abs(b - c) == Math.abs(c - a) ||
                Math.abs(c - a) == Math.abs(a - b);
    }

}
