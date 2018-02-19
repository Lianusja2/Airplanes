package planes;

import java.util.Objects;
import java.util.UUID;

public abstract class AirPlane implements Plane {

    private double fuelUsage;
    private double maxDistance;
    private String model;
    private String id;


    AirPlane(String model, double fuelUsage, double maxDistance) throws IllegalAccessException {
        if (fuelUsage <= 0) {
            throw new IllegalAccessException("Fuel usage can not be less or equal to 0");
        }
        if (maxDistance <= 0) {
            throw new IllegalAccessException("Maximum distance can not be less or equal to 0");
        }
        Objects.requireNonNull(model, "Model can not be NULL");
        this.fuelUsage = fuelUsage;
        this.maxDistance = maxDistance;
        this.model = model;
        this.id = UUID.randomUUID().toString();
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public String getModel() {
        return model;
    }

    public double getFuelUsage() {
        return fuelUsage;
    }

    @Override
    public String getId() {
        return id;
    }


}
