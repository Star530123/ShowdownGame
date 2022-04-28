
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.Exchanger;
import java.util.stream.Collectors;

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
    private Exchange exchange;

    public Player(Order order, Input input) {
        setOrder(order);
        setInput(input);
    }

    public abstract void name();

    public abstract DoExchange wantToExchangeCard();

    public abstract Player exchangeCardWith(List<Player> players);

    public abstract Card show();

    public void exchangeHands(Player player) {
        System.out.printf("--> 對象為%s\n", player.getPlayerName());
        List<Card> targetCards = player.getCards();
        player.setCards(cards);
        exchange = new Exchange(this, player);
        cards = targetCards;
    }

    public void checkExchange() {
        if (exchange == null) return;
        exchange.decreaseCountdown();
        if (exchange.getCountdown() == 0) {
            exchange.returnHands();
            exchange = null;
        }
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (Card card: cards) {
            sj.add(card.toString());
        }
        return String.format("\n{order: %s, name: %15s, cards: %s}", this.order.name(), this.name, sj);
    }

    public String getPlayerName() {
        return String.format("%s玩家 %s", this.order.name(), this.name);
    }

    public void sortCard() {
        cards.sort(Card::compareTo);
    }

    public enum Order{
        P1(),P2(),P3(),P4()
    }

    public enum DoExchange {
        YES(1), NO(0);
        final int val;
        DoExchange(int val) {
            this.val = val;
        }

        public static DoExchange findByVal(int val) {
            return Arrays.stream(values())
                    .filter(doExchange -> doExchange.val == val)
                    .findFirst()
                    .orElse(null);
        }
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

    public void decrementExchangePrivilege() {
        this.exchangePrivilege--;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        ValidateUtil.requireNonNull(input);
        this.input = input;
    }
}
