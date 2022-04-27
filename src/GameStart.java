import java.util.List;

/**
 * @author Simon
 */
public class GameStart {

    public static void name(List<Player> players) {
        for (Player player: players) {
            if (player.getClass().equals(HumanPlayer.class)) {
                System.out.println(player.getOrder().name() + "玩家請輸入姓名:");
            }
            player.name();
        }
    }

}
