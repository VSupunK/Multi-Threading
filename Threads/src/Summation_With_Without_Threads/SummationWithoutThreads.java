package Summation_With_Without_Threads;

public class SummationWithoutThreads {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int end = 10000000;
        long sum = 0;

        for (int i = 1; i <= end; i++) {
            sum += i;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total Sum (Without Threads): " + sum);
        System.out.println("Execution Time (Without Threads): " + (endTime - startTime) + " ms");
    }
}
