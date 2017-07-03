package test.java.org.roksolana;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.java.org.roksolana.Card;
import main.java.org.roksolana.CardDeckAndHand;

public class CardDeckAndHandTest {

    @Test
    public void testPokerFactoryCreate() {
        CardDeckAndHand allCards = new CardDeckAndHand("TH JH QC QD QS QH KH AH 2S 6S");
        List<Card> handCards = allCards.getHandCards();
        List<Card> deckCards = allCards.getDeckCards();
        assertEquals(handCards, createCardList("TH", "JH", "QC", "QD", "QS"));
        assertEquals(deckCards, createCardList("QH", "KH", "AH", "2S", "6S"));
    }

    public static List<Card> createCardList(String... cards) {
        final List<Card> list = new ArrayList<Card>();
        for (String card : cards) {
            list.add(new Card(card));
        }
        return list;
    }

}
