package main.java.org.roksolana.combinations;

import java.util.List;

import main.java.org.roksolana.Card;
import main.java.org.roksolana.combinations.util.CardUtils;

public class AbstractOfAKindD extends CombinationsSearcher {

    private int numberOfKind;

    AbstractOfAKindD(String name, int numberOfKind) {
        super(name);
        this.numberOfKind = numberOfKind;
    }

    /**
     * Return list of cards where size of cards list grouped by the same rank equals numberofKind in a name
     * @return list of cards suitable for the combination
     */
    @Override
    protected List<Card> searchCombination(List<Card> cards) {
        for (List<Card> group : CardUtils.groupByRank(cards)) {
            if (group.size() == numberOfKind) {
                return group;
            }
        }
        return null;
    }
}
