import java.util.List;

/**
 * @author Simon
 */
public class GameStart {

    public GameStart(List<Player> players) {
        this.name(players);
    }

    public void name(List<Player> players) {
        for (Player player: players) {
            player.name();
        }
    }
}
