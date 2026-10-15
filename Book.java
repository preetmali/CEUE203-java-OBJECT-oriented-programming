public class Book extends Media {

    public Book(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    public double lateFee() {
        return lateDays * 2;
    }
}