package main.java.org.roksolana.combinations.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.org.roksolana.Card;
import main.java.org.roksolana.Rank;

/** Sequence extractor for the 'wheel straight' type of A-2-3-4-5. */
public class WheelSequenceExtractor {

    static class CardValue {

        private Card card;

        public CardValue(Card card) {
            this.card = card;
        }

        public Card getCard() {
            return card;
        }

        public Integer getValue() {
            return getValueNumberMapping().get(this.card.getRank());
        }

        /**
         * This method maps the rank name with its value of Integer type
         * @return map of ranks as keys and integer values of ranks
         */
        protected Map<Rank, Integer> getValueNumberMapping() {
            final HashMap<Rank, Integer> values = new HashMap<Rank, Integer>();
            values.put(Rank.ACE, 1);
            values.put(Rank.RANK2, 2);
            values.put(Rank.RANK3, 3);
            values.put(Rank.RANK4, 4);
            values.put(Rank.RANK5, 5);
            values.put(Rank.RANK6, 6);
            values.put(Rank.RANK7, 7);
            values.put(Rank.RANK8, 8);
            values.put(Rank.RANK9, 9);
            values.put(Rank.TEN, 10);
            values.put(Rank.JACK, 11);
            values.put(Rank.QUEEN, 12);
            values.put(Rank.KING, 13);
            return values;
        }
    }

    /**
     * This method creates sequence of 5 cards extracted from array
     * @param cards list
     * @return
     */
    public List<Card> extractSequence(List<Card> cards) {
        List<Card> result = new ArrayList<Card>();
        for (Card card : createSpotArray(cards)) {
            if (card == null) {
                result.clear();
            } else {
                result.add(card);
            }
            if (result.size() == 5) {
                return result;
            }
        }
        return null;
    }

    /**
     * This method creates an array from a list of wrapped cards. 
     * It puts those cards into a pile starting from the end of an array.
     * @param cards list
     * @return array of Cards
     */
    private Card[] createSpotArray(List<Card> cards) {
        Card[] cardArray = new Card[14];
        for (CardValue value : wrapList(cards)) {
            cardArray[value.getValue() - 1] = value.getCard();
        }
        return cardArray;
    }

    /**
     * This method wraps a list of cards with this CardValue class
     * @param cards
     * @return list of wrapped cards
     */
    private List<CardValue> wrapList(List<Card> cards) {
        List<CardValue> cardValues = new ArrayList<CardValue>();
        for (Card card : cards) {
            cardValues.add(wrap(card));
        }
        return cardValues;
    }

    /**
     * This method wraps a card into CardValue static class
     * @param card
     * @return value of a card
     */
    protected CardValue wrap(Card card) {
        return new CardValue(card);
    }
}
