package planeOwner;

import planes.CivilAircraft;
import planes.CivilAircraftType;
import planes.Plane;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Company implements Corporation {

    private String name;
    private List<Plane> airplanes;
    private String id;

    public Company(String name) {
        Objects.requireNonNull(name, " Company name can not be NULL");
        this.name = name;
        airplanes = new ArrayList<>();
        id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public List<Plane> getAirplanes() {
        return airplanes;
    }

    public void addPlane(CivilAircraft plane) {
        if (plane.getCivilType().equals(CivilAircraftType.GENERAL)) {
            throw new IllegalArgumentException("Not possible to add General type Civil Aircraft planes to company. Only Commercial airplanes are allowed");
        }
         airplanes.add(plane);
    }

    public double getTotalCarryingWeight() {
        double sum = 0;
        for (Plane plane : airplanes) {
            sum +=plane.getCarryingWeight();
        }
        return sum;
    }

    public int getNumberOfPeopleOnBoard() {
        int sum = 0;
        for (Plane plane : airplanes) {
            sum += plane.getNumberOfPeople();
        }
        return sum;
    }

    public void sortPlanes(Comparator<Plane> by) {
        Collections.sort(airplanes, by);
    }

    public Comparator<Plane> byMaxDistance() {
        return (Plane p1, Plane p2) -> Double.compare(p1.getMaxDistance(), p2.getMaxDistance());
    }

    public List<Plane> filterPlanes(Predicate<Plane> predicate) {
        return airplanes.stream().filter(predicate).collect(Collectors.toList());
    }

    public Predicate<Plane> byFuelUsage(double min, double max) {
        if (max < min) {
            throw new IllegalArgumentException("Maximum Fules usege can not be less then min fules usege");
        } else if (min < 0) {
            throw new IllegalArgumentException("Fuel usege can not be negetive");
        } else {
            return (Plane plane) -> plane.getFuelUsage() >= min && plane.getFuelUsage() <= max;
        }
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;

        Company company = (Company) o;

        if (!getName().equals(company.getName())) return false;
        return (getAirplanes() != null ? getAirplanes().equals(company.getAirplanes()) : company.getAirplanes() == null) && getId().equals(company.getId());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + (getAirplanes() != null ? getAirplanes().hashCode() : 0);
        result = 31 * result + getId().hashCode();
        return result;
    }
}
