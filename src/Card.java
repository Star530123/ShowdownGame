/**
 * @author Simon
 */
public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * @param card 比較的牌
     * @return 負數 : 代表此牌比傳進來的牌小 ; 正數 : 代表此牌比傳進來的牌大
     * 基本上不會有正數 (階級相同且花色相同)
     */
    public int compareTo(Card card) {
        int rankDiff = rank.val - card.rank.val;
        int suitDiff = suit.val - card.suit.val;
        if (rankDiff != 0) return rankDiff;
        else return suitDiff;
    }

    public enum Rank {
        TWO("2",2),
        THREE("3",3),
        FOUR("4",4),
        FIVE("5",5),
        SIX("6",6),
        SEVEN("7", 7),
        EIGHT("8", 8),
        NINE("9", 9),
        TEN("10", 10),
        JOKER("J", 11),
        QUEEN("Q", 12),
        KING("K",13),
        ACE("A",14);

        final String name;
        final int val;
        Rank(String name, int val) {
            this.name = name;
            this.val = val;
        }
    }

    public enum Suit {
        CLUB("♣",1),
        DIAMOND("♦",2),
        HEART("♥",3),
        SPADE("♠",4);

        final String symbol;
        final int val;
        Suit(String symbol, int val) {
            this.symbol = symbol;
            this.val = val;
        }
    }

    @Override
    public String toString() {
        return String.format("%s%s", this.suit.symbol, this.rank.name);
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
