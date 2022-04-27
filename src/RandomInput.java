/**
 * @author Simon
 */
public class RandomInput extends Input{

    @Override
    public String enterWords() {
        String s = "abcdefghijklmnopqrstuvwxyz";
        int length = 3 + (int) (Math.random() * 10);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(s.charAt((int) (Math.random() * s.length())));
        }
        return sb.toString();
    }

    @Override
    public Integer enterNumber() {
        return (int) (Math.random() * Integer.MAX_VALUE);
    }
}
