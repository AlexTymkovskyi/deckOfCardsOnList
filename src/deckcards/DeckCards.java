package deckcards;

import java.util.*;

public class DeckCards {
    Card[] orderCardDeck;
    Card[] cardDeck;

    public DeckCards() {
        orderCardDeck = deck();
        cardDeck = deck();
    }

    private Card[] deck() {
        int counter = 0;
        int deckCardSize = Rank.values.length * Suit.values.length;
        Card[] cards = new Card[deckCardSize];
        for (Suit suit : Suit.values) {
            for (Rank rank : Rank.values) {
                cards[counter] = new Card(rank, suit);
                counter++;
            }
        }
        return cards;
    }

    //Перемішує колоду у випадковому порядку
    public void shuffle() {
        Random rnd = new Random();
        for(int i = 0; i < cardDeck.length; i++) {
            int index = rnd.nextInt(i + 1);
            Card a = cardDeck[index];
            cardDeck[index] = cardDeck[i];
            cardDeck[i] = a;
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
        int counter = 0;
        Card[] orderDeck = new Card[cardDeck.length];
        for (Card a:orderCardDeck){
            for (Card b:cardDeck){
                if (a.getSuit().getName().equals(b.getSuit().getName())&a.getRank().getName().equals(b.getRank().getName())){
                    orderDeck[counter] = new Card(a.getRank(),a.getSuit());
                    counter++;
                }
            }
        }
        cardDeck=orderCardDeck;
    }

    //Повертає true у випадку коли в колоді ще доступні карти
    public boolean hasNext() {
        return cardDeck[1] != null;
    }

    //"Виймає" одну карту з колоди, коли буде видано всі 36 карт повертає null
    //Карти виймаються з "вершини" колоди. Наприклад перший виклик видасть SPADES 6 потім
    //SPADES 7, ..., CLUBS 6, ..., CLUBS Ace і так далі до HEARTS Ace
    public Card drawOne() {
        if (cardDeck.length == 0) {
            return null;
        }
        {
            Card drawOneCard=cardDeck[cardDeck.length-1];
            cardDeck= Arrays.copyOf(cardDeck, cardDeck.length-1);
            return drawOneCard;
        }
    }

}

