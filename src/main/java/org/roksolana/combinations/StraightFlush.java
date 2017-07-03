package main.java.org.roksolana.combinations;

import java.util.List;

import main.java.org.roksolana.Card;
import main.java.org.roksolana.combinations.util.CardUtils;

public class StraightFlush extends Straight {

    public StraightFlush() {
        super("straight-flush");
    }

    /**
     * Return list of cards where all 5 cards of 1 suit are places in an order,
     * using wheel sequence of cards extractor and royal extractor through Straight combination
     * @return list of cards suitable for the combination
     */
    @Override
    protected List<Card> searchCombination(List<Card> cards) {
        for (List<Card> group : CardUtils.groupBySuit(cards)) {
            List<Card> candidates = super.searchCombination(group);
            if (candidates != null) {
                return candidates;
            }
        }
        return null;
    }
}
