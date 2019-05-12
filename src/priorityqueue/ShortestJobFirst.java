package priorityqueue;

import java.util.*;

public class ShortestJobFirst {

    ArrayList processingTime = new ArrayList<Integer>();
    Heap heap;

    public ShortestJobFirst(ArrayList l) {
        heap = new Heap(100);
        for (Object obj : l) {
            heap.insert((int) obj);
        }
        heap.sort();
    }

    public double process() {
        int sum = 0;
        heap.sort();
        int size = heap.size();
        for (int i = 1; i < size; i++) {
            int temp = heap.getValue(i);
            sum += temp;
            processingTime.add(sum);
        }
        int total = 0;
        for (Object obj : processingTime) {
            total += (int) obj;
        }
        return ((double) total) / (size);
    }
}
