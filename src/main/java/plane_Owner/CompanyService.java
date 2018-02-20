package plane_Owner;

import planes.Plane;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CompanyService implements CorporationService {

    public void writeBinaryCompaniesIntoFile(List<Company> films, String fileName) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            objectOutputStream.writeObject(films);
        }
    }


    public List<Company> readBinaryCompaniesFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Company>) objectInput.readObject();
        }
    }

    public double getTotalCarryingWeight(Company company) {
        double sum = 0;
        for (Plane plane : company.getAirplanes()) {
            sum += plane.getCarryingWeight();
        }
        return sum;
    }

    public int getNumberOfPeopleOnBoard(Company company) {
        int sum = 0;
        for (Plane plane : company.getAirplanes()) {
            sum += plane.getNumberOfPeople();
        }
        return sum;
    }

    public void sortPlanes(Company company, Comparator<Plane> by) {
        company.getAirplanes().sort(by);
    }

    public Comparator<Plane> byMaxDistance() {
        return Comparator.comparingDouble(Plane::getMaxDistance);
    }

    public List<Plane> filterPlanes(Company company, Predicate<Plane> predicate) {
        return company.getAirplanes().stream().filter(predicate).collect(Collectors.toList());
    }

    public Predicate<Plane> byFuelUsage(double min, double max) {
        if (max < min) {
            throw new IllegalArgumentException("Maximum Fuels usage can not be less then min fules usage");
        } else if (min < 0) {
            throw new IllegalArgumentException("Fuel usage can not be negative");
        } else {
            return (Plane plane) -> plane.getFuelUsage() >= min && plane.getFuelUsage() <= max;
        }
    }

}
