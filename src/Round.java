import java.util.List;

/**
 * @author Simon
 */
public class Round {

    public static void takeTurns(List<Player> players) {
        int count = 13;
        for (int i = 1; i <= count; i++) {
            System.out.printf("第%d回合\n", i);
            checkExchange(players);
            new Turn(players).execute();
        }
    }

    private static void checkExchange(List<Player> players) {
        for (int i = players.size() - 1; i >= 0; i--) {
            players.get(i).checkExchange();
        }
    }


}
