import java.util.Date;
import java.util.Scanner;

public class ParkingLotService {

    public void performAction() {
        System.out.print("Parking lot Service initiated, please enter action types: Entry, Exit, Balance or End");
        Scanner scn = new Scanner(System.in);
        String actionType = scn.nextLine();
        ParkingLot parkingLot = new ParkingLot();
        while (!actionType.equals("End")) {
            if (actionType.equals("Entry")) {
                System.out.println("Please enter car type");
                String carType = scn.nextLine();
                if (parkingLot.checkAvailableSpots(carType)) {
                    System.out.println("Car spot available, please enter car number");
                    String carNum = scn.nextLine();
                    Date startTime = new Date();
                    Vehicle car = new Vehicle(carNum, carType, startTime);
                    parkingLot.park(car);
                    System.out.println("Car parked!");
                } else {
                    System.out.println("Sorry! Car spot not available");
                }
            }

                if (actionType.equals("Exit")) {
                    System.out.println("Welcome to car exit, please enter car number");
                    String carNumber = scn.nextLine();
                    parkingLot.exitCar(carNumber);
                }

                if (actionType.equals("Balance")) {
                    System.out.println("Total amount in account is " + parkingLot.getPayment());
                }

                actionType = scn.nextLine();

        }
    }
}