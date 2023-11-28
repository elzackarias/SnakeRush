public class Test {
    static int f1(int x) {
        if(x == 0) {
            return 1;
        } else {
            return f2(x - 1);
        }
    }
    static int f2(int x) {
        if(x == 0) {
            return 0;
        } else {
            return f1(x - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(f1(5));
        System.out.println(f1(4));
    }
}
