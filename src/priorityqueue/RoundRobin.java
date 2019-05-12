package priorityqueue;

import java.util.*;

public class RoundRobin {

    ArrayList list = new ArrayList<Integer>();
    ArrayList processingTime = new ArrayList<>();
    int timeSlice;
    int N;

    public RoundRobin(ArrayList l, int tS) {
        for (Object obj : l) {
            list.add(obj);
        }
        timeSlice = tS;
        N = list.size();
    }

    public double process() {
        int time = 0;
        while (list.size() > 0) {
            int sub = (int) list.get(0) - timeSlice;
            if (sub > 0) {
                time += timeSlice;
                list.remove(0);
                list.add(sub);
            } else {
                time += (int) list.get(0);
                processingTime.add(time);
                list.remove(0);
            }
        }
        int total = 0;
        for (Object obj : processingTime) {
            total += (int) obj;
        }
        return ((double) total) / N;
    }

}
