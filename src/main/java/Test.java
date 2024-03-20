import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String path = Test.class.getProtectionDomain().getCodeSource().getLocation().toString();
        path = path.substring(5);
        System.out.println(path);
        ArrayList<String> a = new ArrayList<>(List.of(path.split("/")));
        System.out.println(a);
        a.removeLast();
        path = String.join("/", a);
        System.out.println(path);
    }
}
