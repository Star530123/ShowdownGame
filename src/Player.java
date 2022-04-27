
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author Simon
 */
public abstract class Player {
    private Order order;
    private String name;
    private List<Card> cards = new ArrayList<>();
    private int point;
    private int exchangePrivilege = 1;
    private Input input;

    public Player(Order order, Input input) {
        setOrder(order);
        setInput(input);
    }

    public void name() {
        name = input.enterWords();
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (Card card: cards) {
            sj.add(card.toString());
        }
        return String.format("{order: %s, name: %s, cards: %s}", this.order.name(), this.name, sj);
    }

    public void sortCard() {
        cards.sort(Card::compareTo);
    }

    public enum Order{
        P1(),P2(),P3(),P4()
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        ValidateUtil.requireNonNull(order);
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getExchangePrivilege() {
        return exchangePrivilege;
    }

    public void setExchangePrivilege(int exchangePrivilege) {
        this.exchangePrivilege = exchangePrivilege;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        ValidateUtil.requireNonNull(input);
        this.input = input;
    }
}
