package main.java.org.roksolana;

public enum Rank {
    ACE("A"),
    RANK2("2"),
    RANK3("3"),
    RANK4("4"),
    RANK5("5"),
    RANK6("6"),
    RANK7("7"),
    RANK8("8"),
    RANK9("9"),
    TEN("T"),
    JACK("J"),
    QUEEN("Q"),
    KING("K");

    private String name;

    private Rank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * This method checks for Rank name validity (whether it is allowed in poker)
     * @param rankName
     * @return rank if it is valid
     * @throws IllegalArgumentException if rank name is invalid
     */
    public static Rank getRankByName(String rankName) {
        for (Rank rank : Rank.values()) {
            if (rank.getName().equals(rankName)) {
                return rank;
            }
        }
        throw new IllegalArgumentException("illegal rank name: " + rankName);
    }
}
