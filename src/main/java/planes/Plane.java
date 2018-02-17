package planes;

import common.HasId;

import java.io.Serializable;

public interface Plane extends HasId, Serializable {

    double getMaxDistance();

    int getNumberOfPeople();

    double getCarryingWeight();

    double getFuelUsage();

    String getModel();

}
