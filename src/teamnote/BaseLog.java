package teamnote;

public class BaseLog {

    public static double baseLog(int x, int base) {
        return Math.log(x) / Math.log(base);
    }

    public static void main(String[] args) {
        double v = baseLog(25, 5);
        System.out.println(v);
    }
}
