import java.util.Date;

public class ParkingSpot {
    Vehicle vehicle;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingTicket getParkingTicket(ParkingSpot parkedCar) {
        long duration = (new Date().getTime() - parkedCar.vehicle.getStartTime().getTime()) / (1000 * 60 * 60);
        return new ParkingTicket(duration, parkedCar.getVehicle().getCarType());
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }
}