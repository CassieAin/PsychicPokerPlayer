package main.java.org.roksolana.combinations.util;

import java.util.Map;

import main.java.org.roksolana.Card;
import main.java.org.roksolana.Rank;

/** Sequence extractor for the 'royal straight' type of A-K-Q-J-T. */
public class RoyalSequenceExtractor extends WheelSequenceExtractor {

    static class RoyalValue extends CardValue {

        RoyalValue(final Card card) {
            super(card);
        }

        @Override
        protected Map<Rank, Integer> getValueNumberMapping() {
            final Map<Rank, Integer> valueMapping = super.getValueNumberMapping();
            valueMapping.put(Rank.ACE, 14);
            return valueMapping;
        }
    }

    @Override
    protected CardValue wrap(final Card card) {
        return new RoyalValue(card);
    }
}
