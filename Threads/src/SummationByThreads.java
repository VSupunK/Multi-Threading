public class SummationByThreads {
    public static void main(String[] args) {
        int sum = 0;
        int chunk = 1000;
        int end = 10000;

        for (int i = 1; i<= end; i += chunk){
            int s = getSum(i, i + chunk - 1);
            sum += s;
        }
        System.out.println("" + sum);
    }

    public static int getSum(int start, int end){
        long id = Thread.currentThread().threadId();
        System.out.println("TID : " + id);
        int sum = 0;

        try {
            Thread.sleep(100);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        for (int i = start; i <= end; i++){
            sum += i;
        }
        return sum;
    }
}
