import java.io.UnsupportedEncodingException;

/**
 * @author 郑章洋
 * @date 2019-11-19 10:08
 */
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        StringBuilder reqContext1 = new StringBuilder("hello").insert(0, String.format("%010d", 111) + "00");
        StringBuilder reqContext = new StringBuilder("hello").insert(0, String.format("%-10d", 111) + "00");

        System.out.println(reqContext1);
        System.out.println(reqContext);
    }
    public static boolean isOdd(int i){
        return (i & 1) != 0;
    }


}
