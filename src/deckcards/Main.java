package deckcards;

public class Main {

   public static void main(String[] args) {
       DeckCards cards = new DeckCards();
       cards.shuffle();
       cards.drawOne();
       cards.order();
       cards.drawOne();
       cards.drawOne();
//       System.out.println(cards.cardDeck.toString());
}
}
