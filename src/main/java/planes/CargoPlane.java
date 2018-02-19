package planes;

public class CargoPlane extends CivilAircraft {

    private double carryingWeight;
    private int numberOfCrew;


    public CargoPlane(String model, double fuelUsage, double maxDistance, CivilAircraftType civilType, double carryingWeight, int numberOfCrew) throws IllegalAccessException {
        super(model, fuelUsage, maxDistance, civilType);
        if (carryingWeight == 0) {
            throw new IllegalAccessException("Carrying weight can not be less then 0");
        }
        if (numberOfCrew <= 0) {
            throw new IllegalAccessException("Crew number can not be less or equal to 0");
        }
        this.carryingWeight = carryingWeight;
        this.numberOfCrew = numberOfCrew;
    }

    public int getNumberOfPeople() {
        return numberOfCrew;
    }

    public double getCarryingWeight() {
        return carryingWeight + numberOfCrew * 9;
    }


    @Override
    public String toString() {
        return "CargoPlane{" +
                "carryingWeight=" + carryingWeight +
                ", numberOfCrew=" + numberOfCrew +
                ", id='" + getId() + '\'' +
                ", fuelUsage=" + getFuelUsage() +
                ", maxDistance=" + getMaxDistance() +
                ", model='" + getModel() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CargoPlane)) {
            return false;
        }
        CargoPlane that = (CargoPlane) o;
        if (Double.compare(that.getCarryingWeight(), getCarryingWeight()) != 0) {
            return false;
        }
        {
            return numberOfCrew == that.numberOfCrew && getId().equals(that.getId());
        }
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getCarryingWeight());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + numberOfCrew;
        result = 31 * result + getId().hashCode();
        return result;
    }
}
