import java.util.List;

/**
 * @author Simon
 */
public class Draw {

    public static void drawCard(List<Player> players, Deck deck) {
        for (int i = 0; i < 13; i++) {
            for (Player player: players) {
                player.getCards().add(deck.drawCard());
            }
        }
        players.forEach(Player::sortCard);
    }
}
