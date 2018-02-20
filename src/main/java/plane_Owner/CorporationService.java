package plane_Owner;

import planes.Plane;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface CorporationService {
    void writeBinaryCompaniesIntoFile(List<Company> films, String fileName) throws IOException;

    List<Company> readBinaryCompaniesFromFile(String fileName) throws IOException, ClassNotFoundException;

    double getTotalCarryingWeight(Company company);

    int getNumberOfPeopleOnBoard(Company company);

    void sortPlanes(Company company, Comparator<Plane> by);

    List<Plane> filterPlanes(Company company, Predicate<Plane> predicate);
    Predicate<Plane> byFuelUsage(double min, double max);
    Comparator<Plane> byMaxDistance();
}
