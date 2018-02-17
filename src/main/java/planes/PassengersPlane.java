package planes;

import java.util.UUID;

public class PassengersPlane extends CivilAircraft {
    private int numberOfPassengers;
    private int numberOfCrew;
    private String id;

    public PassengersPlane(String model, double fuelUsage, double maxDistance, CivilAircraftType civilType, int numberOfPassengers, int numberOfCrew) throws IllegalAccessException {
        super(model,fuelUsage, maxDistance, civilType);
        if(numberOfPassengers <=0){
            throw new IllegalAccessException("Passengers number can not be less or equal to 0");
        }
        if(numberOfCrew <=0){
            throw new IllegalAccessException("Crew number can not be less or equal to 0");
        }
        this.numberOfPassengers=numberOfPassengers;
        this.numberOfCrew=numberOfCrew;
        this.id= UUID.randomUUID().toString();
    }


    public int getNumberOfPeople() {
        return numberOfCrew+numberOfPassengers;
    }

    public double getCarryingWeight() {
        return numberOfCrew*9+numberOfPassengers*23;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PassengersPlane{" +
                "numberOfPassengers=" + numberOfPassengers +
                ", numberOfCrew=" + numberOfCrew +
                ", id='" + id + '\'' +
                ", fuelUsage=" + getFuelUsage() +
                ", maxDistance=" + getMaxDistance() +
                ", model='" + getModel() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengersPlane)) return false;

        PassengersPlane that = (PassengersPlane) o;

        if (numberOfPassengers != that.numberOfPassengers) return false;
        if (numberOfCrew != that.numberOfCrew) return false;
        return getId().equals(that.getId()) && getModel().equals(that.getModel());
    }

    @Override
    public int hashCode() {
        int result = numberOfPassengers;
        result = 31 * result + numberOfCrew;
        result = 31 * result + getId().hashCode();
        result = 31 * result + getModel().hashCode();
        return result;
    }
}

