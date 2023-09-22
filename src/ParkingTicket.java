public class ParkingTicket {
    long duration;
    String carType;
    long totalPrice;

    public ParkingTicket(long duration, String carType) {
        this.duration = duration;
        this.carType = carType;
        this.totalPrice = calculateTotalPrice(this.carType, this.duration);
    }

    private long calculateTotalPrice(String carType, long duration) {
        long pricePerHour;
        if (carType.equals("SUV"))
            pricePerHour = 20;
        else
            pricePerHour = 16;

        return pricePerHour * duration;
    }

    public long getTotalPrice() {
        return this.totalPrice;
    }
}