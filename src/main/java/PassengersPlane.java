public class PassengersPlane extends CivilAircraft {
    private int numberOfPassengers;
    private int numberOfCrew;

    public PassengersPlane(double fuelUsage, double maxDistance, CivilAircraftType civilType, int numberOfPassengers, int numberOfCrew) {
        super(fuelUsage, maxDistance, civilType);
        this.numberOfPassengers=numberOfPassengers;
        this.numberOfCrew=numberOfCrew;
    }


    public int getNumberOfPeople() {
        return numberOfCrew+numberOfPassengers;
    }

    public double getCarryingWeight() {
        return numberOfCrew*9+numberOfPassengers*23;
    }
}

