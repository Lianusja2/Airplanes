package plane_Owner;

import planes.CivilAircraft;
import planes.CivilAircraftType;
import planes.Plane;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

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
        return getName().equals(company.getName()) && (getAirplanes() != null ? getAirplanes().equals(company.getAirplanes()) : company.getAirplanes() == null) && getId().equals(company.getId());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + (getAirplanes() != null ? getAirplanes().hashCode() : 0);
        result = 31 * result + getId().hashCode();
        return result;
    }
}
