import java.util.*;

public class DataStructures {

    public static void main(String args[]) {

        Cat garfield = new Cat("Garfield");
        Cat pinkPanther = new Cat("Pink Panther");
        Cat catwoman = new Cat("Catwoman");
        Cat nermal = new Cat("Nermal");
        Cat arya = new Cat("Arya");

        List<Cat> coolCats = new ArrayList<Cat>() {
            {
                add(garfield);
                add(pinkPanther);
                add(catwoman);
                add(nermal);
                add(arya);
            }
        };

        for (Cat cat : coolCats) {
            System.out.println(cat.getName());
        }

        ArrayList<Integer> myInts = new ArrayList<Integer>() {
            {
                add(7);
                add(8);
                add(1);
                add(3);
                add(3);
            }
        };
        mostFrequentElement(myInts);

        // BONUS: I rewrote my method to work with any
        // object type, including Strings (now takes generic
        // as param instead of Integer
        ArrayList<String> myNames = new ArrayList<String>() {
            {
                add("Rafael");
                add("Carlos");
                add("Will");
                add("Mike");
                add("Bryan");
                add("Rafael");
                add("Rafael");
            }
        };
        mostFrequentElement(myNames);

        HashMap<String, Integer> podAges = new HashMap<String, Integer>() {
            {
                put("Rafael", 38);
                put("Taryn", 35);
                put("Shawn", 25);
                put("Yojana", 31);
                put("Josiel", 26);
            }
        };

        // I didn't put this in a method because instructions
        // didn't specify
        for (Map.Entry<String, Integer> item : podAges.entrySet()) {
            System.out.println(item.getKey() + " is " + item.getValue());
        }

        System.out.println(canRentACar(podAges));

        System.out.println(wordsWithoutList(new String[]{"a", "bb", "b", "ccc"}, 3));

        System.out.println(countClumps(new int[]{1, 2, 2, 3, 4, 4}));

        System.out.println(sortingSentences("Another bit the dust the other day"));
    }

    private static void mostFrequentElement(ArrayList<?> items) {

        Object mostFrequent = items.get(0);

        for (int i = 0; i < items.size(); i++) {
            if (Collections.frequency(items, items.get(i)) >
                    Collections.frequency(items, mostFrequent)) {
                mostFrequent = items.get(i);
            }
        }

        System.out.println(
                "Most Frequent Element: "
                        + mostFrequent +
                        " (Appears " +
                        Collections.frequency(items, mostFrequent) +
                        " times)");

    }

    private static boolean canRentACar(HashMap<String, Integer> group) {
        for (Map.Entry<String, Integer> person : group.entrySet()) {
            if (person.getValue() > 25) {
                return true;
            }
        }
        return false;
    }

    private static List<String> wordsWithoutList(String[] list, int omitSize) {
        List result = new ArrayList();
        for (String item : list)
            if (item.length() != omitSize)
                result.add(item);
        return result;
    }

    private static int countClumps(int[] numList) {
        int result = 0;
        for (int i = 0; i < numList.length - 1; i++)
            if (numList[i] == numList[i + 1]) {
                result++;
                for (int j = i + 1; j < numList.length; j++)
                    if (numList[j] == numList[i]) i++;
                    else break;
            }
        return result;
    }

    private static List<String> sortingSentences(String sentence) {
        String[] split = sentence.split(" ");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            result.add(split[i]);
        }
        Collections.sort(result);
        return result;
    }
}
