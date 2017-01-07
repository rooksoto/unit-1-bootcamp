public class ClassesAndObjects {

    public static void main(String args[]) {

        Cat garfield = new Cat("Garfield");
        Cat pinkPanther = new Cat("Pink Panther");
        Cat catwoman = new Cat("Catwoman");

        garfield.setFavoriteFood("Lasagna");
        pinkPanther.setFavoriteFood("Lemonade");
        catwoman.setFavoriteFood("Bat Stew");

        garfield.setAge(11);
        pinkPanther.setAge(65);
        catwoman.setAge(32);

        // Tests
        System.out.println(isOlder(pinkPanther, garfield));

        System.out.println(catwoman.getFavoriteFood());
        makeBestFriends(garfield, catwoman);
        System.out.println(catwoman.getFavoriteFood());

        Cat myNewCat = makeKitten(pinkPanther, catwoman);
        System.out.println(myNewCat.getName());
        System.out.println(myNewCat.getAge());

        Person jon = new Person("Jon");
        adoption(garfield, jon);
        System.out.println(garfield.getOwner().getName());
        adoption(catwoman, jon);
        System.out.println(catwoman.getOwner()); // Remains null

        System.out.println(isFree(garfield));
        System.out.println(isFree(catwoman));

        adoption(pinkPanther, jon);
        System.out.println(isSibling(garfield, catwoman));
        System.out.println(isSibling(garfield, pinkPanther));

    }

    private static boolean isOlder(Cat a, Cat b) {
        return (a.getAge() > b.getAge());
    }

    private static void makeBestFriends(Cat a, Cat b) {
        // Since the instructions didn't specify,
        // I set the second cat's favorite food to
        // be the same as the first cat's
        b.setFavoriteFood(a.getFavoriteFood());
    }

    private static Cat makeKitten(Cat a, Cat b) {
        Cat newKitten = new Cat(a.getName() + b.getName());
        newKitten.setAge(0);
        return newKitten;
    }

    private static void adoption(Cat cat, Person person) {
        if (cat.getName() == "Catwoman") {
            System.out.println("Catwoman will never be anyone's pet!");
        } else {
            cat.setOwner(person);
        }
    }

    private static boolean isFree(Cat cat) {
        return cat.getOwner() == null;
    }

    private static boolean isSibling(Cat a, Cat b) {
        return a.getOwner().equals(b.getOwner());
    }
}
