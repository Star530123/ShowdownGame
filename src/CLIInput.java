import java.util.Scanner;

/**
 * @author Simon
 */
public class CLIInput extends Input{

    private final static Scanner SCANNER = new Scanner(System.in);

    @Override
    public String enterWords() {
        return SCANNER.next();
    }

    @Override
    public Integer enterNumber() {
        return SCANNER.nextInt();
    }
}
