import java.util.ArrayList;
import java.util.List;

/**
 * @author Simon
 */
public class Main {
    public static void main(String[] args) {
        int humanPlayerNumber = 1;
        List<Player> players = initializePlayers(humanPlayerNumber);
        Deck deck = new Deck();
        System.out.println("遊戲開始!!!!");
        System.out.println("命名");
        GameStart.name(players);
        System.out.println("洗牌");
        deck.shuffle();
        System.out.println("抽卡階段!!!!");
        Draw.drawCard(players, deck);
        System.out.println("遊戲回合開始!!!!");
        System.out.println(players);
        System.out.println(deck);

    }

    private static List<Player> initializePlayers(int humanPlayerNumber) {
        ValidateUtil.integerInterval(humanPlayerNumber, 0, 4);
        List<Player> players = new ArrayList<>();
        for(Player.Order order: Player.Order.values()) {
            if (humanPlayerNumber != 0) {
                players.add(new HumanPlayer(order, new CLIInput()));
                humanPlayerNumber--;
            } else players.add(new AIPlayer(order, new RandomInput()));
        }
        return players;
    }
}
