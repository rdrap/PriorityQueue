package priorityqueue;

public class Heap {

    private int[] pq;
    private int N = 0;

    public Heap(int maxN) {
        pq = new int[maxN + 1];
    }

    public void sort() {
        for (int k = N / 2; k >= 1; k--) {
            sink(k);
        }
        while (N > 1) {
            exch(1, N--);
            sink(1);
        }
        N = pq.length - 1;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(int v) {
        pq[++N] = v;
        swim(N);
    }

    public int delMin() {
        int max = pq[1];
        exch(1, N--);
        pq[N + 1] = 0;
        sink(1);
        return max;
    }

    public int getValue(int index) {
        return pq[index];
    }

    private boolean less(int i, int j) {
        return pq[i] < pq[j];
    }

    private void exch(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N - 1 && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    public int getTotal() {
        int total = 0;
        for (int i = 1; i < pq.length; i++) {
            total += (int) (pq[i]);
        }
        return total;
    }
}
