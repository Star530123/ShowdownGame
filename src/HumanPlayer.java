import java.util.List;
import java.util.StringJoiner;

/**
 * @author Simon
 */
public class HumanPlayer extends Player{
    public HumanPlayer(Order order, Input input) {
        super(order, input);
    }

    @Override
    public void name() {
        System.out.println(getOrder().name() + "玩家請輸入姓名:");
        setName(getInput().enterWords());
    }

    @Override
    public DoExchange wantToExchangeCard() {
        while (true) {
            try{
                System.out.printf("請問要不要交換手牌? (要請輸入 %d,不要請輸入 %d)\n", DoExchange.YES.val, DoExchange.NO.val);
                DoExchange doExchange = DoExchange.findByVal(getInput().enterNumber());
                if (doExchange == null) throw new RuntimeException();
                return doExchange;
            } catch (Exception e) {
                System.out.println("請輸入正確的值！");
            }
        }
    }

    @Override
    public Player exchangeCardWith(List<Player> players) {
        while (true) {
            try {
                System.out.print("請輸入你要交換手牌的人選 :");
                StringJoiner sj = new StringJoiner(",", "(", ")");
                for (int i = 0; i < players.size(); i++) {
                    sj.add(String.format("%s請輸入%d", players.get(i).getPlayerName(), i));
                }
                System.out.println(sj);
                int index = getInput().enterNumber();
                return players.get(index);
            } catch (Exception e) {
                System.out.println("請輸入正確的值！");
            }
        }
    }

    @Override
    public Card show() {
        while (true) {
            try {
                StringJoiner sj = new StringJoiner(", ","[","]");
                for (int i = 0; i < getCards().size(); i++) sj.add(String.format("%d: %s", i+1,getCards().get(i)));
                System.out.printf("請輸入要出的牌(從左至右數1~%d):\n", getCards().size());
                System.out.println(sj);
                Integer val = getInput().enterNumber();
                ValidateUtil.integerInterval(val, 1, getCards().size());
                return getCards().remove(val - 1);
            } catch (Exception e) {
                System.out.println("請輸入正確的值！");
            }
        }
    }
}
