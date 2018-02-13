public abstract class AirPlane implements  Plane{

    private double fuelUsage;
    private double maxDistance;


    public AirPlane(double fuelUsage, double maxDistance) {
        this.fuelUsage = fuelUsage;
        this.maxDistance = maxDistance;
    }

    public double getMaxDistance() {
        return maxDistance;
    }


    public double getFuelUsage() {
        return fuelUsage;
    }


}
