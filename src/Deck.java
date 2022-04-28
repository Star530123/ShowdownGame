import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author Simon
 */
public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        initializeDeck();
    }

    private void initializeDeck() {
        Card.Rank[] ranks = Card.Rank.values();
        Card.Suit[] suits = Card.Suit.values();
        for (Card.Rank rank: ranks) {
            for (Card.Suit suit: suits) {
                cards.add(new Card(rank,suit));
            }
        }
    }

    public void shuffle() {
        List<Card> newCards = new ArrayList<>();
        for (int i = 52; i > 0; i--) {
            int index = (int) (Math.random() * i);
            newCards.add(cards.get(index));
            cards.remove(index);
        }
        cards = newCards;
        System.out.println("牌堆已洗牌完成！");
    }

    public Card drawCard() {
        if (cards.isEmpty()) throw new RuntimeException("牌堆已經沒牌抽囉！");
        return cards.remove(cards.size() - 1);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",","[","]");
        for (Card card: cards) {
            sj.add(card.toString());
        }
        return sj.toString();
    }

    public List<Card> getCards() {
        return cards;
    }
}
