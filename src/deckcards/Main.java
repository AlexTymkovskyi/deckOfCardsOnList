package deckcards;

public class Main {

    public static void main(String[] args) {
        DeckCards masive = new DeckCards();
        // write your code here
        masive.deck();
        System.out.println("Shuffle");
        masive.shuffle();
        System.out.println("Order");
        masive.order();
        System.out.println("Draw One");
        masive.drawOne();
        masive.drawOne();
//        masive.drawOne();
//        masive.drawOne();
        System.out.println(masive.hasNext());
	// write your code here
    }
}
