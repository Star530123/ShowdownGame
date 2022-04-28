import java.util.List;

/**
 * @author Simon
 */
public class Draw {

    public static void drawCard(List<Player> players, Deck deck) {
        int round = deck.getCards().size() / players.size();
        for (int i = 0; i < round; i++) {
            for (Player player: players) {
                player.getCards().add(deck.drawCard());
            }
        }
        players.forEach(Player::sortCard);
    }
}
