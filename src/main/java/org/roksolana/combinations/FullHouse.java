package main.java.org.roksolana.combinations;

import java.util.ArrayList;
import java.util.List;

import main.java.org.roksolana.Card;
import main.java.org.roksolana.combinations.util.CardUtils;

public class FullHouse extends CombinationsSearcher {

    public FullHouse() {
        super("full-house");
    }

    /**
     * Return list of 5 cards where number of cards list grouped by the same rank equals 2 and equals 3,
     * as it constitutes 1 pair and 1 threesome.
     * @return list of cards suitable for the combination
     */
    @Override
    protected List<Card> searchCombination(final List<Card> cards) {

        final List<Card> result = new ArrayList<Card>();

        for (List<Card> group : CardUtils.groupByRank(cards)) {
            if (group.size() == 3) {
                result.addAll(group);
            } else if (group.size() == 2) {
                result.addAll(group);
            }
            if (result.size() == 5) {
                return result;
            }
        }
        return null;
    }
}
