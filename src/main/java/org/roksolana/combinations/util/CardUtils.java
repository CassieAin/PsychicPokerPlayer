package main.java.org.roksolana.combinations.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.org.roksolana.Card;
import main.java.org.roksolana.Rank;

public class CardUtils {

	 /**
     * This method creates a map with suits as keys and cards like values.
     * It groups all the cards by specific suits.
     * @param cards
     * @return card values from the map grouped by suits
     */
    public static Collection<List<Card>> groupBySuit(List<Card> cards) {
        Map<String, List<Card>> result = new HashMap<String, List<Card>>();
        for (Card card : cards) {
            getOrCreateGroupedCards(result, card.getSuit()).add(card);
        }
        return result.values();
    }

    /**
     * This method creates a map with ranks as keys and cards like values.
     * It groups all the cards by specific ranks.
     * @param cards
     * @return card values from the map grouped by ranks
     */
    public static Collection<List<Card>> groupByRank(List<Card> cards) {
        Map<Rank, List<Card>> result = new HashMap<Rank, List<Card>>();
        for (Card card : cards) {
            getOrCreateGroupedCards(result, card.getRank()).add(card);
        }
        return result.values();
    }

    /**
     * This method gets (if already exists) or creates a list of cards 
     * taking into consideration params
     * @param result - map of specific params as keys with cards a values
     * @param param - key of the map
     * @return list of cards by params
     */
    private static <T> List<Card> getOrCreateGroupedCards(Map<T, List<Card>> result, T param) {
        List<Card> cardList = result.get(param);
        if (cardList == null) {
            cardList = new ArrayList<Card>();
            result.put(param, cardList);
        }
        return cardList;
    }
}
