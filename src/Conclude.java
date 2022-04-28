import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author Simon
 */
public class Conclude {

    public static void displayWinnerName(List<Player> players) {
        System.out.println("~~各玩家比分~~");
        List<Player> winners = new ArrayList<>();
        int maxPoint = 0;
        StringJoiner sj = new StringJoiner(", ");
        for (Player player: players) {
            if (player.getPoint() > maxPoint) {
                winners = new ArrayList<>();
                winners.add(player);
                maxPoint = player.getPoint();
            } else if (player.getPoint() == maxPoint) {
                winners.add(player);
            }
            sj.add(String.format("%s玩家 %s: %d分", player.getOrder().name(), player.getName(), player.getPoint()));
        }
        System.out.println(sj);
        sj = new StringJoiner("、");
        for (Player winner: winners) sj.add(winner.getName());
        System.out.printf("恭喜玩家%s獲得本次的最高分 %d分!!!", sj, maxPoint);
    }
}
