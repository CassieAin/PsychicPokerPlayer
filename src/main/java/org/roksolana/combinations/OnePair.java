package main.java.org.roksolana.combinations;

import java.util.List;

import main.java.org.roksolana.Card;
import main.java.org.roksolana.combinations.util.CardUtils;

public class OnePair extends CombinationsSearcher {

    public OnePair() {
        super("one-pair");
    }

    /**
     * Return list of cards where number of cards list grouped by the same rank equals 2,
     * as it constitutes on pair.
     * @return list of cards suitable for the combination
     */
    @Override
    protected List<Card> searchCombination(final List<Card> cards) {

        for (List<Card> group : CardUtils.groupByRank(cards)) {
            if (group.size() == 2) {
                return group;
            }
        }
        return null;
    }
}
