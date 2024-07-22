package Summation_With_Without_Threads;

import java.util.ArrayList;
import java.util.List;

public class SummationWithThreads {
    public static void main(String[] args) {
        int end = 10000000;
        int chunk = 1000000;
        long sum = 0;

        List<SumThread> threads = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        // Create and start threads
        for (int i = 1; i <= end; i += chunk) {
            SumThread thread = new SumThread(i, Math.min(i + chunk - 1, end));
            thread.start();
            threads.add(thread);
        }

        // Wait for all threads to complete and collect results
        for (SumThread thread : threads) {
            try {
                thread.join();
                sum += thread.getSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total Sum (With Threads): " + sum);
        System.out.println("Execution Time (With Threads): " + (endTime - startTime) + " ms");
    }
}

class SumThread extends Thread {
    private int start;
    private int end;
    private long sum;

    public SumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
    }

    public long getSum() {
        return sum;
    }
}


