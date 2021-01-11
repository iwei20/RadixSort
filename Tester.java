public class Tester {
    public static void main(String[] args) {
        for(int i = 4; i >= 0; --i) {
            System.out.print(Radix.nth(34234, i));
        }
        System.out.println(); // 34234

        for(int i = 6; i >= 0; --i) {
            System.out.print(Radix.nth(-6859234, i));
        }
        System.out.println(); // 6859234

        System.out.println(Radix.nth(0, 0)); // 0
        System.out.println(Radix.nth(1, 0)); // 1
        System.out.println(Radix.nth(-5384958, 0)); // 8

        System.out.println(Radix.length(0)); // 1
        System.out.println(Radix.length(1049826537)); // 10
        System.out.println(Radix.length(-1523845437)); // 10
        System.out.println(Radix.length(Integer.MAX_VALUE)); // 10
        
        int n = 382493849;
        System.out.println(Radix.nth(n, Radix.length(n) - 1)); // 3
    }
}
