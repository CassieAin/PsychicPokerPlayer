package main.java.org.roksolana.combinations;

import java.util.ArrayList;
import java.util.List;

import main.java.org.roksolana.Card;

public abstract class CombinationsSearcher {

    private final String name;

    /**
     * This method called with different sets of cards (from 0 to 10 cards)
     * to search a possible combination amongst them.
     * @param set of cards
     * @return collection of card with combination or null 
     */
    abstract protected List<Card> searchCombination(List<Card> cards);

    CombinationsSearcher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * This method takes each card in deck and checks woth hand cards
     * whether a valid combination can be formed
     * @param handCards
     * @param deckCards
     * @return true for a valid combination and false otherwise
     */
    public boolean check(List<Card> handCards, List<Card> deckCards) {
        for (int n = 0; n <= 5; n++) {
            List<Card> takenFromDeck = deckCards.subList(0, n);
            if (checkInner(handCards, takenFromDeck)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method takes each card in hand and unites it with deck cards 
     * to search for a valid combination
     * @param handCards collection of cards
     * @param takenFromDeck collection of cards
     * @return true if found combination is valid
     */
    private boolean checkInner(List<Card> handCards, List<Card> takenFromDeck) {
        for (int n = 0; n <= 5; n++) {
            List<Card> handCardSubList = handCards.subList(0, n);
            List<Card> union = cardsUnion(handCardSubList, takenFromDeck);
            List<Card> combination = searchCombination(union);
            if (isValid(combination, takenFromDeck)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ensures if the hand combination is valid.
     * Sum of cards taken from the deck and the hand cards that are used in the combination,
     * must be not more then 5. 
     * @param collection of the hand cards
     * @param tcollection of cards taken from the deck
     * @return true if the combination is valid otherwise - false
     */
    private boolean isValid(List<Card> combination, List<Card> takenFromDeck) {
        if (combination == null) {
            return false;
        }
        List<Card> copy = new ArrayList<Card>(combination);
        copy.removeAll(takenFromDeck);
        int size = copy.size();
        return size + takenFromDeck.size() <= 5;
    }

    /**
     * Combines 2 lists of cards into 1 list
     * @param list1 - collection of cards
     * @param list2 - collection of cards
     * @return list of united list1 and list2
     */
    private List<Card> cardsUnion(List<Card> list1, List<Card> list2) {
        List<Card> cards = new ArrayList<Card>(list1);
        cards.addAll(list2);
        return cards;
    }
}
