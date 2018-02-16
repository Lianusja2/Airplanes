package planes;

import common.HasId;

public interface Plane extends HasId {

    double getMaxDistance();

    int getNumberOfPeople();

    double getCarryingWeight();

    double getFuelUsage();

    String getModel();

}
