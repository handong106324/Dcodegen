/**
 * Created by handong on 16/1/20.
 */
public class TestString {

    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == e));
        //一个是值，一个是指向该值的地址
    }
}
