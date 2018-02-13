public abstract class CivilAircraft extends AirPlane {
    private CivilAircraftType civilType;

    public CivilAircraft(double fuelUsage, double maxDistance, CivilAircraftType civilType) {
        super(fuelUsage, maxDistance);
        this.civilType=civilType;
    }


    public CivilAircraftType getCivilType() {
        return civilType;
    }


}
