/**
 * @author Simon
 */
public class ValidateUtil {

    public static <T> void requireNonNull(T object) {
        if (object == null) throw new RuntimeException("此物件不可為null");
    }

    public static void integerInterval(int val, int min, int max) {
        if (val >= min && val <= max) return;
        throw new RuntimeException(String.format("輸入的數值需介於%d~%d之間", min, max));
    }
}
