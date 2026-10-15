class SharedTotal {
    long total = 0;

    void add(int value) {
        total += value;
    }

    synchronized void synchronizedAdd(int value) {
        total += value;
    }
}

public class ArraySumThreads {

    static final int SIZE = 1_000_000;
    static final int THREADS = 10;

    public static void main(String[] args) throws InterruptedException {

        int[] arr = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        System.out.println("Expected Total = " + SIZE);

        SharedTotal shared1 = new SharedTotal();
        Thread[] threads1 = new Thread[THREADS];

        long start1 = System.nanoTime();

        for (int i = 0; i < THREADS; i++) {

            int start = i * (SIZE / THREADS);
            int end = (i + 1) * (SIZE / THREADS);

            threads1[i] = new Thread(() -> {

                for (int j = start; j < end; j++) {
                    shared1.add(arr[j]);
                }

            });

            threads1[i].start();
        }

        for (Thread t : threads1) {
            t.join();
        }

        long end1 = System.nanoTime();

        System.out.println("\nWithout Synchronization");
        System.out.println("Total = " + shared1.total);
        System.out.println("Time = " + (end1 - start1) / 1_000_000 + " ms");

        SharedTotal shared2 = new SharedTotal();
        Thread[] threads2 = new Thread[THREADS];

        long start2 = System.nanoTime();

        for (int i = 0; i < THREADS; i++) {

            int start = i * (SIZE / THREADS);
            int end = (i + 1) * (SIZE / THREADS);

            threads2[i] = new Thread(() -> {

                for (int j = start; j < end; j++) {
                    shared2.synchronizedAdd(arr[j]);
                }

            });

            threads2[i].start();
        }

        for (Thread t : threads2) {
            t.join();
        }

        long end2 = System.nanoTime();

        System.out.println("\nWith Synchronization");
        System.out.println("Total = " + shared2.total);
        System.out.println("Time = " + (end2 - start2) / 1_000_000 + " ms");

        long[] localTotal = new long[THREADS];

        Thread[] threads3 = new Thread[THREADS];

        long start3 = System.nanoTime();

        for (int i = 0; i < THREADS; i++) {

            int threadNumber = i;
            int start = i * (SIZE / THREADS);
            int end = (i + 1) * (SIZE / THREADS);

            threads3[i] = new Thread(() -> {

                long sum = 0;

                for (int j = start; j < end; j++) {
                    sum += arr[j];
                }

                localTotal[threadNumber] = sum;
            });

            threads3[i].start();
        }

        for (Thread t : threads3) {
            t.join();
        }

        long finalTotal = 0;

        for (long sum : localTotal) {
            finalTotal += sum;
        }

        long end3 = System.nanoTime();

        System.out.println("\nUsing Local Totals");
        System.out.println("Total = " + finalTotal);
        System.out.println("Time = " + (end3 - start3) / 1_000_000 + " ms");
        System.out.println("25ce057");
    }
}