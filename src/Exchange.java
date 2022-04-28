/**
 * @author Simon
 */
public class Exchange {
    private final Player applier;
    private final Player target;
    private int countdown = 3;

    public Exchange(Player applier, Player target) {
        this.applier = applier;
        this.target = target;
    }

    public void returnHands() {
        System.out.printf("%s玩家將交換回自己的手牌!!! ", applier.getOrder().name());
        applier.exchangeHands(target);
    }

    public void decreaseCountdown() {
        countdown--;
    }

    public int getCountdown() {
        return countdown;
    }
}
