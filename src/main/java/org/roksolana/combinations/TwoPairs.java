package main.java.org.roksolana.combinations;

import java.util.ArrayList;
import java.util.List;

import main.java.org.roksolana.Card;
import main.java.org.roksolana.combinations.util.CardUtils;

public class TwoPairs extends CombinationsSearcher {

    public TwoPairs() {
        super("two-pairs");
    }

    /**
     * Return list of cards where number of cards list grouped by the same rank equals 4,
     * as it constitutes 2 pairs of cards with 2 corresponding ranks.
     * @return list of cards suitable for the combination
     */
    @Override
    protected List<Card> searchCombination(final List<Card> cards) {

        final List<Card> result = new ArrayList<Card>();

        for (List<Card> group : CardUtils.groupByRank(cards)) {
            if (group.size() == 2) {
                result.addAll(group);
            }
            if (result.size() == 4) {
                return result;
            }
        }
        return null;
    }
}
