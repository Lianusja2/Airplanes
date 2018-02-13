public class CargoPlane extends CivilAircraft {

    private double carryingWeight;
    private int numberOfCrew;

    public CargoPlane(double fuelUsage, double maxDistance, CivilAircraftType civilType, double carryingWeight, int numberOfCrew) {
        super(fuelUsage, maxDistance, civilType);
        this.carryingWeight=carryingWeight;
        this.numberOfCrew=numberOfCrew;
    }

    public int getNumberOfPeople() {
        return numberOfCrew;
    }

    public double getCarryingWeight() {
        return carryingWeight + numberOfCrew*9 ;
    }

}
