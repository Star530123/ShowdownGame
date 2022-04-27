import java.util.ArrayList;
import java.util.List;

/**
 * @author Simon
 */
public class Main {
    public static void main(String[] args) {
        int humanPlayerNumber = 1;
        List<Player> players = initializePlayers(humanPlayerNumber);
        new GameStart(players);
        System.out.println(players);
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
