import java.util.List;

/**
 * @author Simon
 */
public class GameStart {

    public static void name(List<Player> players) {
        for (Player player: players) {
            player.name();
        }
    }

}
