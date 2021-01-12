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
        return Math.abs((n / bexp(10, col)) % 10);
    }

    public static int length(int n) {
        int a = Math.abs(n);
        int result = 0;
        while(a > 0) {
            ++result;
            a /= 10;
        } 
        return Math.max(1, result);
    }

    public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
        for(int i = 0; i < buckets.length; ++i) {
            original.extend(buckets[i]);
        }
    }

    public static void radixSortSimple(SortableLinkedList data) {
        SortableLinkedList[] buckets = new SortableLinkedList[10];
        for(int i = 0; i < buckets.length; ++i) {
            buckets[i] = new SortableLinkedList();
        }
        int digits = 0;
        for(int i = 0; i < data.size(); ++i) {
            digits = Math.max(digits, length(data.get(i)));
        }

        for(int i = 0; i < digits; ++i) {
            for(; data.size() > 0;) {
                int element = data.remove(0);
                buckets[nth(element, i)].add(element);
            }
            merge(data, buckets);
        }
        
    }

}
