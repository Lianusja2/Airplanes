import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Company {
    private String name;
    private List<Plane> airplanes;

    public Company(String name) {
        this.name = name;
        airplanes= new ArrayList<Plane>();
    }

    public String getName() {
        return name;
    }

    public List<Plane> getAirplanes() {
        return airplanes;
    }

    public void addPlane(Plane plane){
        airplanes.add(plane);
    }

    public double getTotalCarryingWeight() {
        double sum = 0;
        for (Plane plane : airplanes) {
            sum = +plane.getCarryingWeight();
        }
        return sum;
    }

    public int getNumberOfPeopleOnBoard(){
        int sum = 0;
        for (Plane plane : airplanes) {
            sum = +plane.getNumberOfPeople();
        }
        return sum;
    }

    public void sortPlanes(Comparator<Plane> by){
        Collections.sort(airplanes, by);
    }

    public  Comparator<Plane> byMaxDistance() {
        return (Plane p1, Plane p2)-> Double.compare(p1.getMaxDistance(), p2.getMaxDistance());
    }

    public List<Plane> filterPlanes(Predicate<Plane> predicate){
        return airplanes.stream().filter(predicate).collect(Collectors.toList());
    }

    public  Predicate<Plane> byFuelUsage(double min, double max) {
        // input validation

        return (Plane plane)-> plane.getFuelUsage()>=min && plane.getFuelUsage()<=max;
    }
}
