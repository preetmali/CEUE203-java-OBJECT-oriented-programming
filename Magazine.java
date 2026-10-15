public class Magazine extends Media {

    public Magazine(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    public double lateFee() {
        return lateDays * 3;
    }
}