package main.java.org.roksolana;

public class Card {

    private Rank rank;
    private String suit;

    public Card(String source) {
        String rankName = String.valueOf(source.charAt(0));
        this.rank = Rank.getRankByName(rankName);
        this.suit = String.valueOf(source.charAt(1));
    }

    public Rank getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) {
            return false;
        }
        Card card = (Card) obj;
        return this.rank.equals(card.getRank()) && this.suit.equals(card.getSuit());
    }

    @Override
    public String toString() {
        return rank.getName() + suit;
    }
}
