import java.util.ArrayList;
import java.util.List;

/**
 * @author Simon
 */
public class Main {
    public static void main(String[] args) {
        int humanPlayerNumber = 0;
        List<Player> players = initializePlayers(humanPlayerNumber);
        Deck deck = new Deck();
        System.out.println("\n遊戲開始!!!!");
        System.out.println("各玩家命名時間~~~~");
        GameStart.name(players);
        System.out.println("洗牌");
        deck.shuffle();
        System.out.println("\n抽卡階段!!!!");
        Draw.drawCard(players, deck);
        System.out.println("\n遊戲回合開始!!!!");
        Round.takeTurns(players);
        System.out.println("\n結算時間!!!!");
        Conclude.displayWinnerName(players);
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
