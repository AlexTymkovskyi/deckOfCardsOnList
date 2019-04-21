package deckcards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckCards {
    List<Card> orderCardDeck;
    List<Card> cardDeck;

    public DeckCards() {
        cardDeck = deck();
        orderCardDeck = deck();
    }

    public List deck() {
        List<Card> cards = new ArrayList<>();
        for (Suit suit : Suit.values) {
            for (Rank rank : Rank.values) {
                cards.add(new Card(rank, suit));
            }
        }
        for (Card v : cards) {
            System.out.println(v.getSuit().getName() + " " + v.getRank().getName());

        }
        return cards;
    }

    //Перемішує колоду у випадковому порядку
    public void shuffle() {
        Collections.shuffle(cardDeck);
        for (Card v : cardDeck) {
            System.out.println(v.getSuit().getName() + " " + v.getRank().getName());

        }
    }

    /* * Впорядкування колоди за мастями та значеннями
     * Порядок сотрування:
     * Спочатку всі карти з мастю HEARTS, потім DIAMONDS, CLUBS, SPADES
     * для кожної масті порядок наступний: Ace,King,Queen,Jack,10,9,8,7,6
     * Наприклад
     * HEARTS Ace
     * HEARTS King
     * HEARTS Queen
     * HEARTS Jack
     * HEARTS 10
     * HEARTS 9
     * HEARTS 8
     * HEARTS 7
     * HEARTS 6
     * І так далі для DIAMONDS, CLUBS, SPADES */
    public void order() {

        for (Card v : orderCardDeck) {
            System.out.println(v.getSuit().getName() + " " + v.getRank().getName());

        }
    }

    //Повертає true у випадку коли в колоді ще доступні карти
    public boolean hasNext() {return cardDeck.get(1) != null;
    }

    //"Виймає" одну карту з колоди, коли буде видано всі 36 карт повертає null
    //Карти виймаються з "вершини" колоди. Наприклад перший виклик видасть SPADES 6 потім
    //SPADES 7, ..., CLUBS 6, ..., CLUBS Ace і так далі до HEARTS Ace
    public Card drawOne() {
        Card drawOneCard;
        if (orderCardDeck.size() == 0||orderCardDeck==null) {
            return null;
        }
        {int i = orderCardDeck.size()-1;
            System.out.println(orderCardDeck.get(i).getSuit().getName()+" "+orderCardDeck.get(i).getRank().getName());
            drawOneCard=orderCardDeck.remove(i);
        }
            for (Card v : orderCardDeck) {
            System.out.println(v.getSuit().getName() + " " + v.getRank().getName());
        }
        return drawOneCard;
    }

}

