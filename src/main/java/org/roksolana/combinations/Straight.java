package main.java.org.roksolana.combinations;

import java.util.List;

import main.java.org.roksolana.Card;
import main.java.org.roksolana.combinations.util.RoyalSequenceExtractor;
import main.java.org.roksolana.combinations.util.WheelSequenceExtractor;

public class Straight extends CombinationsSearcher {

    private WheelSequenceExtractor extractor;

    public Straight() {
        super("straight");
    }

    Straight(String name) {
        super(name);
    }

    @Override
    protected List<Card> searchCombination(List<Card> cards) {
        return this.extractor.extractSequence(cards);
    }

    /**
     * Return list of cards where cards are ordered by rank with the help of 2 sequences extractors:
     * one - for numbered ranks and another one for royal ranks 
     * @return list of cards suitable for the combination
     */
    @Override
    public boolean check(List<Card> handCards, List<Card> deckCards) {
        setExtractor(new RoyalSequenceExtractor());
        if (super.check(handCards, deckCards)) {
            return true;
        } else {
            setExtractor(new WheelSequenceExtractor());
            return super.check(handCards, deckCards);
        }
    }

    private void setExtractor(WheelSequenceExtractor extractor) {
        this.extractor = extractor;
    }
}
