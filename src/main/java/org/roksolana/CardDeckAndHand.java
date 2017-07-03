package main.java.org.roksolana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardDeckAndHand {

    private String source;

    public CardDeckAndHand(String source) {
        this.source = source;
    }

    public List<Card> getHandCards() {
        return createCardList(0, 5);
    }

    public List<Card> getDeckCards() {
        return createCardList(5, 10);
    }

    /**
     * This method creates list of cards in specified range
     * @param fromIndex - starting index
     * @param toIndex - ending index
     * @return list of cards
     */
    private List<Card> createCardList(int fromIndex, int toIndex) {
        String[] cards = source.split(" ");
        List<String> handCards = Arrays.asList(cards).subList(fromIndex, toIndex);
        List<Card> handList = new ArrayList<Card>();
        for (String handCard : handCards) {
            handList.add(new Card(handCard));
        }
        return handList;
    }
}
