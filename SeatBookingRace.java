class seatBook {
    static int seat = 5;

    void book() {
        if (seat > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            seat--;
        } else {
            System.out.println("fail");
        }
    }

}

public class SeatBookingRace {
    public static void main(String[] args) throws InterruptedException {
        seatBook booking = new seatBook();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> booking.book(), "Thread-" + (i + 1));
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("Seats left: " + booking.seat);
        System.out.println("25ce057");
    }
}
