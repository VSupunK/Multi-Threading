package SummationByMultipleThreads;

class SumThread extends Thread {
    private int start;
    private int end;
    private int sum;

    public SumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        long id = Thread.currentThread().getId();
        System.out.println("TID: " + id + " calculating from " + start + " to " + end);
        sum = 0;

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = start; i <= end; i++) {
            sum += i;
        }
    }

    public int getSum() {
        return sum;
    }
}