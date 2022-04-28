import java.util.List;
import java.util.StringJoiner;

/**
 * @author Simon
 */
public class GameStart {

    public static void name(List<Player> players) {
        StringJoiner sj = new StringJoiner(", ");
        for (Player player: players) {
            player.name();
            sj.add(player.getPlayerName());
        }
        System.out.printf("玩家們已準備好囉!!\n%s\n", sj);
    }

}
