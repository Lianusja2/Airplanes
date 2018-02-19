package planes;

public abstract class CivilAircraft extends AirPlane {

    private CivilAircraftType civilType;

    CivilAircraft(String model, double fuelUsage, double maxDistance, CivilAircraftType civilType) throws IllegalAccessException {
        super(model, fuelUsage, maxDistance);
        this.civilType = civilType;
    }

    public CivilAircraftType getCivilType() {
        return civilType;
    }

}
