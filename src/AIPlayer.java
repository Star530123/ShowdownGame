import java.util.List;

/**
 * @author Simon
 */
public class AIPlayer extends Player{
    private int exchangeCardRound;

    public AIPlayer(Order order, Input input) {
        super(order, input);
        exchangeCardRound = (int) (Math.random() * 13);
    }

    @Override
    public void name() {
        setName(getInput().enterWords());
    }

    @Override
    public DoExchange wantToExchangeCard() {
        if (exchangeCardRound == 0) return DoExchange.YES;
        return DoExchange.NO;
    }

    @Override
    public Player exchangeCardWith(List<Player> players) {
        return players.get(getInput().enterNumber() % players.size());
    }

    @Override
    public Card show() {
        exchangeCardRound--;
        return getCards().remove((int) (Math.random() * getCards().size()));
    }
}
