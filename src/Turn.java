import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author Simon
 */
public class Turn {
    private final List<Player> players;


    public Turn(List<Player> players) {
        this.players = players;
    }

    public void execute() {
        List<Card> showCards = new ArrayList<>();
        for (Player player: players) {
            useExchange(player);
        }
        for (Player player: players) {
            showCards.add(player.show());
        }
        displayCards(showCards);
        Player player = showdown(showCards);
        gainPoint(player);
    }

    private Player showdown(List<Card> showCards) {
        Card maxCard = showCards.get(0);
        int index = 0;
        for (int i = 0; i < showCards.size(); i++) {
            Card card = showCards.get(i);
            if (maxCard.compareTo(card) < 0) {
                maxCard = card;
                index = i;
            }
        }
        return players.get(index);
    }

    private void displayCards(List<Card> showCards) {
        System.out.print("此回合各玩家出的牌為 : ");
        StringJoiner sj = new StringJoiner(", ");
        for (int i = 0; i < showCards.size(); i++) {
            sj.add(String.format("%s %s", players.get(i).getPlayerName(), showCards.get(i).toString()));
        }
        System.out.println(sj);
        ToolUtil.wait(1000);
    }

    public void useExchange(Player currentPlayer) {
        int exchangePrivilege = currentPlayer.getExchangePrivilege();
        if (exchangePrivilege == 0 || currentPlayer.wantToExchangeCard() == Player.DoExchange.NO) return;
        currentPlayer.decrementExchangePrivilege();
        Player targetPlayer = currentPlayer.exchangeCardWith(players.stream()
                .filter(player -> player.getOrder() != currentPlayer.getOrder())
                .collect(Collectors.toList()));
        System.out.printf("%s申請換牌!! ", currentPlayer.getPlayerName());
        currentPlayer.exchangeHands(targetPlayer);
    }

    public void gainPoint(Player player) {
        System.out.printf("恭喜%s得分 !!!\n", player.getPlayerName());
        player.setPoint(player.getPoint() + 1);
        ToolUtil.wait(1000);
    }
}
