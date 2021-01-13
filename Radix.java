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
        
        int digits = 1;
        for(int i = 0; i < digits; ++i) {
            while(data.size() > 0) {
                int element = data.remove(0);
                digits = Math.max(digits, length(element));
                buckets[nth(element, i)].add(element);
            }
            merge(data, buckets);
        }
        
    }

    public static void radixSort(SortableLinkedList data) {
        SortableLinkedList pos = new SortableLinkedList();
        SortableLinkedList neg = new SortableLinkedList();

        while(data.size() > 0) {
            int first = data.remove(0);
            if(first >= 0) {
                pos.add(first);
            } else {
                neg.add(first);
            }
        }

        radixSortSimple(pos);
        radixSortSimple(neg);
        while(neg.size() > 0) {
            data.add(neg.remove(neg.size() - 1));
        }
        data.extend(pos);
    }

}
