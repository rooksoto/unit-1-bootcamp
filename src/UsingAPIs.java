import com.stripe.model.Charge;
import com.stripe.net.RequestOptions;

import java.net.URL;
import java.util.*;

public class UsingAPIs {

    // Book fields
    private static HashSet<String> taleOfTwo;
    private static HashSet<String> mobyDick;
    private static HashSet<String> wordIntersection;
    private static HashSet<String> wordUnion;

    // Stripe fields
    private static final String stripeKey = "sk_test_BQokikJOvBiI2HlWgH4olfQ2";
    private static Map<String, Object> chargeMap;
    private static Map<String, Object> cardMap;


    public static void main(String args[]) {

        /*
        Books
         */

        taleOfTwo = new HashSet<>();
        mobyDick = new HashSet<>();
        wordIntersection = new HashSet<>();
        wordUnion = new HashSet<>();

        try {
            downloadBooks();
        } catch (Exception e) {
            e.printStackTrace();
        }

        intersect();
        unite();

        System.out.println("There are " + taleOfTwo.size() + " unique words in 'A Tale of Two Cities'.");
        System.out.println("There are " + mobyDick.size() + " unique words in 'Moby Dick'.");
        System.out.println("There are " + wordIntersection.size() + " words in common between these books.");
        System.out.println("There are " + wordUnion.size() + " total unique words between these books.");

        /*
        Stripe API
         */

        initStripe();
    }

    private static void unite() {
        for (String word : taleOfTwo) {
            wordUnion.add(word);
        }
        for (String word : mobyDick) {
            wordUnion.add(word);
        }
    }

    private static void intersect() {

        for (String word : taleOfTwo) {
            if (mobyDick.contains(word)) {
                wordIntersection.add(word);
            }
        }
        for (String word : mobyDick) {
            if (taleOfTwo.contains(word)) {
                wordIntersection.add(word);
            }
        }
    }

    private static void downloadBooks() throws Exception {
        URL bookUrl = new URL("http://www.textfiles.com/etext/FICTION/2city11.txt");
        Scanner scanner = new Scanner(bookUrl.openStream()).useDelimiter("[^\\p{Alpha}']+");
        while (scanner.hasNext()) {
            taleOfTwo.add(scanner.next().toLowerCase());
        }
        scanner.close();

        bookUrl = new URL("http://www.textfiles.com/etext/FICTION/melville-moby-106.txt");
        scanner = new Scanner(bookUrl.openStream()).useDelimiter("[^\\p{Alpha}']+");
        while (scanner.hasNext()) {
            mobyDick.add(scanner.next().toLowerCase());
        }
        scanner.close();
    }

    /*
    Stripe-related methods
     */

    private static void initStripe() {
        RequestOptions requestOptions = (new RequestOptions
                .RequestOptionsBuilder())
                .setApiKey(stripeKey)
                .build();
        chargeMap = new HashMap<>();
        cardMap = new HashMap<>();

//        chargeMap.put("amount", 100);
//        chargeMap.put("currency", "usd");
//        cardMap.put("number", "4242424242424242");
//        cardMap.put("exp_month", 12);
//        cardMap.put("exp_year", 2020);
//        chargeMap.put("card", cardMap);

        try {
            Charge charge = Charge.create(chargeMap, requestOptions);
            System.out.println(charge);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
