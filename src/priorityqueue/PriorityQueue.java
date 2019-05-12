package priorityqueue;

import java.util.*;

public class PriorityQueue {

    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add((int) (Math.random() * 101));
        }
        FirstInFirstOut fifo = new FirstInFirstOut(list);
        System.out.println("FIFO Average Turnaround Time: " + fifo.process());
        ShortestJobFirst sjf = new ShortestJobFirst(list);
        System.out.println("SJF Average Turnaround Time: " + sjf.process());
        for (int i = 10; i < 55; i += 5) {
            RoundRobin rr = new RoundRobin(list, i);
            System.out.println("RR Average Turnaround Time (Time Slice = " + i + ") : " + rr.process());
        }

    }

}

/*
SAMPLE OUTPUT:
FIFO Average Turnaround Time: 2474.04
SJF Average Turnaround Time: 1678.45
RR Average Turnaround Time (Time Slice = 10) : 3375.78
RR Average Turnaround Time (Time Slice = 15) : 3365.14
RR Average Turnaround Time (Time Slice = 20) : 3307.81
RR Average Turnaround Time (Time Slice = 25) : 3289.99
RR Average Turnaround Time (Time Slice = 30) : 3368.72
RR Average Turnaround Time (Time Slice = 35) : 3222.27
RR Average Turnaround Time (Time Slice = 40) : 3169.09
RR Average Turnaround Time (Time Slice = 45) : 3156.31
RR Average Turnaround Time (Time Slice = 50) : 3087.22
 */