package main.java.org.roksolana.combinations;

import java.util.List;

import main.java.org.roksolana.Card;
import main.java.org.roksolana.combinations.util.CardUtils;

public class Flush extends CombinationsSearcher {

    public Flush() {
        super("flush");
    }

    /**
     * Return list of cards where number of cards list grouped by the same suit equals 5
     * as it constitutes on pair.
     * @return list of cards suitable for the combination
     */
    @Override
    protected List<Card> searchCombination(List<Card> cards) {
        for (List<Card> group : CardUtils.groupBySuit(cards)) {
            if (group.size() == 5) {
                return group;
            }
        }
        return null;
    }
}
