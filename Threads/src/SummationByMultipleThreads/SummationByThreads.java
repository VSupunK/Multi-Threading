package SummationByMultipleThreads;
import java.util.ArrayList;
import java.util.List;

public class SummationByThreads {
    public static void main(String[] args) {
        int sum = 0;
        int chunk = 1000;
        int end = 100000;
        int numThreads = end / chunk;

        List<SumThread> threads = new ArrayList<>();

        // Create and start threads
        for (int i = 1; i <= end; i += chunk) {
            SumThread thread = new SumThread(i, i + chunk - 1);
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

        System.out.println("Total Sum: " + sum);
    }
}
