class Main {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        Runnable task = () -> {
            synchronized (lock1) {
                System.out.println(
                        Thread.currentThread().getName() + ": Locked lock1");

                synchronized (lock2) {
                    System.out.println(
                            Thread.currentThread().getName() + ": Locked lock2");
                }

                System.out.println(
                        Thread.currentThread().getName() + ": Released both locks");
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");

        t1.start();
        t2.start();
        System.out.println("25CE057");
    }

}
