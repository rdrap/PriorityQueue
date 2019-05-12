package priorityqueue;

import java.util.*;

public class FirstInFirstOut {

    ArrayList list = new ArrayList<>();
    ArrayList processingTime = new ArrayList<>();

    public FirstInFirstOut(ArrayList l) {
        for (Object obj : l) {
            list.add(obj);
        }
    }

    public double process() {
        int sum = 0;
        for (Object obj : list) {
            sum += (int) obj;
            processingTime.add(sum);
        }
        int total = 0;
        for (Object obj : processingTime) {
            total += (int) obj;
        }
        return ((double) total) / (list.size());
    }
}
