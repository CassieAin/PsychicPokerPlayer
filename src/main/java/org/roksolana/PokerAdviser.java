package main.java.org.roksolana;

import java.util.List;

import main.java.org.roksolana.combinations.CombinationsSearcher;
import main.java.org.roksolana.combinations.Flush;
import main.java.org.roksolana.combinations.FourOfAKind;
import main.java.org.roksolana.combinations.FullHouse;
import main.java.org.roksolana.combinations.HighestCard;
import main.java.org.roksolana.combinations.OnePair;
import main.java.org.roksolana.combinations.Straight;
import main.java.org.roksolana.combinations.StraightFlush;
import main.java.org.roksolana.combinations.ThreeOfAKind;
import main.java.org.roksolana.combinations.TwoPairs;

public class PokerAdviser {

    private static CombinationsSearcher[] SEARCHERS = new CombinationsSearcher[]{
            new StraightFlush(),
            new FourOfAKind(),
            new FullHouse(),
            new Flush(),
            new Straight(),
            new ThreeOfAKind(),
            new TwoPairs(),
            new OnePair(),
            new HighestCard()};

    /**
     * This method forms hand and deck cards, searches for a poker combination,
     * checks its validity and builds an advice for a poker player
     * @param source all cards listed in a string
     * @return final advice of String type
     */
    public static String advice(String source) {
        CardDeckAndHand allCards = new CardDeckAndHand(source);
        List<Card> handCards = allCards.getHandCards();
        List<Card> deckCards = allCards.getDeckCards();

        for (CombinationsSearcher searcher : SEARCHERS) {
            if (searcher.check(handCards, deckCards)) {
                return buildAdviceString(searcher, handCards, deckCards);
            }
        }
        return null;
    }

    /**
     * Constructs the result string for a combination of cards.
     * @param detector  hand detector
     * @param handCards hand cards
     * @param deckCards deck cards
     * @return advise string
     */
    private static String buildAdviceString(CombinationsSearcher searcher, List<Card> handCards, List<Card> deckCards) {
        StringBuilder builder = new StringBuilder("Hand: ");
        getCardsString(builder, handCards);
        builder.append("Deck: ");
        getCardsString(builder, deckCards);
        builder.append("Best hand: ").append(searcher.getName());
        return builder.toString();
    }

    /**
     * Construct a string representation for a list of cards
     * @param builder   string builder
     * @param handCards list of cards to be represented in a string
     */
    private static void getCardsString(StringBuilder builder, List<Card> handCards) {
        for (Card card : handCards) {
            builder.append(card).append(" ");
        }
    }
}
