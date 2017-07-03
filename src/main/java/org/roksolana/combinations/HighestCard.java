package main.java.org.roksolana.combinations;

import java.util.List;

import main.java.org.roksolana.Card;

public class HighestCard extends CombinationsSearcher {

    public HighestCard() {
        super("highest-card");
    }

    @Override
    protected List<Card> searchCombination(List<Card> cards) {
        return cards;
    }

}
