public class Variables {

    public static void main(String args[]) {

        int roomNumber = 113;
        double closeToE = 2.71828;
        String subject = "Computer Science";

        System.out.println("This is room # " + roomNumber);
        System.out.println("e is cloe to " + closeToE);
        System.out.println("I am learning a bit about " + subject);

        //Testing methods here
        System.out.println("isOdd: " + isOdd(5));
        System.out.print("Print Hello World: ");
        printHelloWorld();
        System.out.println("Greatest Common Factor: " + gCF(55, 5658540));
    }

    /*
    Wrote full methods instead of signatures,
    because why not? :)
     */

    // Func name suggests int arg, bool return
    private static boolean isOdd(int testNum) {
        return testNum % 2 != 0;
    }

    // Func name suggests no param/return types
    private static void printHelloWorld() {
        System.out.println("Hello World!");
    }

    // Func name suggests at least 2 int args,
    // single int return
    private static int gCF(int a, int b) {
        while (a != 0 && b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a + b;
    }
}
