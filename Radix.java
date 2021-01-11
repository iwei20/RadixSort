public class Radix {
    private static int bexp(int a, int b) {
        if(b == 0) return 1;
        if(b == 1) return a;
        int result = bexp(a, b / 2);
        result *= result;
        if(b % 2 == 1) result *= a;
        return result;
    }

    public static int nth(int n, int col) {
        return (n / bexp(10, col)) % 10;
    }

    public static int length(int n) {
        int currpower = 1;
        int result = 0;
        while(n / currpower > 0) {
            ++result;
            currpower *= 10;
        } 
        return Math.max(1, result);
    }

}
