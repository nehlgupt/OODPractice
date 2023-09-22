import java.util.Date;

public class Vehicle {

    String carNum;
    String carType;
    Date startTime;

    public Vehicle(String carNum, String carType, Date startTime) {
        this.carNum = carNum;
        this.carType = carType;
        this.startTime = startTime;
    }

    public String getCarType() {
        return this.carType;
    }

    public String getCarNum() {
        return this.carNum;
    }

    public Date getStartTime() {
        return this.startTime;
    }
}