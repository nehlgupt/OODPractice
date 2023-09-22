import java.util.*;

public class ParkingLot {
    Map<String, List<ParkingSpot>> availableParkingSpots;
    Map<String, ParkingSpot> occupiedParkingSpots;
    static int payment = 0;

    ParkingLot() {
        availableParkingSpots = new HashMap<>();
        occupiedParkingSpots = new HashMap<>();
        ParkingSpot parkingSpotSuv = new ParkingSpot();
        List<ParkingSpot> availableParkingSpotSuv = new ArrayList<>();
        availableParkingSpotSuv.add(parkingSpotSuv);
        availableParkingSpots.put("Hatchback", availableParkingSpotSuv);
    }

    public boolean checkAvailableSpots(String carType) {
        if (availableParkingSpots.get(carType) != null)
            return availableParkingSpots.get(carType).size() > 0;
        else
            return false;
    }

    public void park(Vehicle car) {
        String carType = car.getCarType();
        List<ParkingSpot> parkingSpots = availableParkingSpots.get(carType);
        ParkingSpot parkingSpot = parkingSpots.remove(parkingSpots.size() - 1);
        parkingSpot.setVehicle(car);
        occupiedParkingSpots.put(car.getCarNum(), parkingSpot);
    }

    public void exitCar(String carNumber) {
        ParkingSpot parkedCar = occupiedParkingSpots.get(carNumber);

        if (parkedCar != null) {
            ParkingTicket parkingTicket = parkedCar.getParkingTicket(parkedCar);
            System.out.println("Please make a payment of " + parkingTicket.getTotalPrice());
            Scanner scn = new Scanner(System.in);
            int amount = scn.nextInt();
            payment += amount;
            occupiedParkingSpots.remove(carNumber);

            String carType = parkedCar.getVehicle().getCarType();
            List<ParkingSpot> parkingSpots = availableParkingSpots.get(carType);
            ParkingSpot parkingSpotNew = new ParkingSpot();
            parkingSpots.add(parkingSpotNew);
            availableParkingSpots.put(carType, parkingSpots);
            System.out.println("Thanks! Visit again");
        } else {
            System.out.println("Invalid car number");
        }
    }

        public int getPayment () {
            return payment;
        }
}


