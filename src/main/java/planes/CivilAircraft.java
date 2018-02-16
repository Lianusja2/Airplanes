package planes;

import planes.AirPlane;

public abstract class CivilAircraft extends AirPlane {

    private CivilAircraftType civilType;

    CivilAircraft(String model, double fuelUsage, double maxDistance, CivilAircraftType civilType) throws IllegalAccessException {
        super(model,fuelUsage, maxDistance);
        this.civilType=civilType;
    }

    public CivilAircraftType getCivilType() {
        return civilType;
    }

    public void setCivilType(CivilAircraftType civilType) {
        this.civilType = civilType;
    }
}
