package runner;

import planeOwner.Company;
import planes.CargoPlane;
import planes.CivilAircraftType;
import planes.PassengersPlane;

import java.util.*;

public class Client {

    public static void main(String[] args) throws IllegalAccessException {

        Company mau = new Company("Mau");
        mau.addPlane(new PassengersPlane("TYY-177", 32.77, 4900.0, CivilAircraftType.COMMERCIAL, 100, 5));
        mau.addPlane(new PassengersPlane("TFF-780", 12.77, 2400.0, CivilAircraftType.COMMERCIAL, 10, 3));
        mau.addPlane(new PassengersPlane("TGB-568", 40.77, 4900.0, CivilAircraftType.COMMERCIAL, 98, 5));
        mau.addPlane(new PassengersPlane("VBJ-877", 57.77, 6543.9, CivilAircraftType.COMMERCIAL, 250, 8));
        mau.addPlane(new PassengersPlane("OMNH-457", 60, 7650.0, CivilAircraftType.COMMERCIAL, 276, 9));
        mau.addPlane(new CargoPlane("WWU-YYY", 45.67, 5678.0, CivilAircraftType.COMMERCIAL, 10000, 2));

        Company lufthansa = new Company("Lufthansa");
        lufthansa.addPlane(new PassengersPlane("HTY-876", 56.9, 9000.0, CivilAircraftType.COMMERCIAL, 400, 9));
        lufthansa.addPlane(new CargoPlane("WJB-098", 45.67, 5678.0, CivilAircraftType.COMMERCIAL, 10000, 2));
        lufthansa.addPlane(new CargoPlane("WWU-099", 38.67, 4678.0, CivilAircraftType.COMMERCIAL, 10000, 2));

        Company wizzair = new Company("WizzAir");
        wizzair.addPlane(new PassengersPlane("VBJ-877", 57.77, 6543.9, CivilAircraftType.COMMERCIAL, 250, 8));
        wizzair.addPlane(new PassengersPlane("OMNH-457", 60, 7650.0, CivilAircraftType.COMMERCIAL, 276, 9));
        wizzair.addPlane(new CargoPlane("WWU-YYY", 45.67, 5678.0, CivilAircraftType.COMMERCIAL, 10000, 2));

        List<Company> companies = new ArrayList<>(Arrays.asList(mau, lufthansa, wizzair));

        Scanner sc = new Scanner(System.in);
        Company currentCompany = null;
        while (currentCompany == null) {
            System.out.println("Please select Company");
            companies.forEach(company -> System.out.println("Press  " + companies.indexOf(company) + " to select " + company.getName()));
            currentCompany = companies.get(sc.nextInt());
            boolean validInfoRequested = false;


            while (!validInfoRequested) {
                validInfoRequested = true;
                System.out.println("Please select airplanes information you would like to know");
                System.out.println("Press 1  to find out total number of people for all planes");
                System.out.println("Press 2  to find out total carrying weight for all planes");
                System.out.println("Press 3  to filter all planes by fuel usage");
                System.out.println("Press 4  to sort planes by max distance");
                System.out.println("Press 0  if you want to change the company");
                int information = sc.nextInt();
                switch (information) {
                    case 0:
                        currentCompany = null;
                        break;
                    case 1:
                        System.out.println("Total Number of People: " + currentCompany.getNumberOfPeopleOnBoard());
                        break;
                    case 2:
                        System.out.println("Total carrying weight: " + currentCompany.getTotalCarryingWeight());
                        break;
                    case 3:
                        int min, max;
                        boolean validArguments = false;
                        while (!validArguments) {
                            System.out.println("Please enter min fuel usage");
                            min = sc.nextInt();
                            System.out.println("Please enter max fuel usage");
                            max = sc.nextInt();
                            try {
                                System.out.println("List of airplanes filtered by fuel usage: " + currentCompany.filterPlanes(mau.byFuelUsage(min, max)));
                                validArguments = true;
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 4:
                        currentCompany.sortPlanes(mau.byMaxDistance());
                        System.out.println(mau.getAirplanes());
                        break;
                    default:
                        System.out.println("You have selected incorrect number. Please try again");
                        validInfoRequested = false;
                        break;

                }
                if (Objects.nonNull(currentCompany) && validInfoRequested) {
                    System.out.println("Would you like to continue inquiring information  about this company?[yes/no]");
                    String reply = sc.next();
                    if (reply.equalsIgnoreCase("yes")) {
                        validInfoRequested = false;
                    } else if (!reply.equalsIgnoreCase("no")) {
                        System.out.println("You reply was did not match [yes/no]. Program stops.");
                    }

                }

            }
        }


    }
}
