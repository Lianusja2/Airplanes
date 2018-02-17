package runner;

import planeOwner.Company;
import planeOwner.CompanyFiles;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;

public class Client {
    private final static Logger LOGGER = Logger.getLogger(Client.class.getName());

    public static void main(String[] args) throws IllegalAccessException, IOException, ClassNotFoundException {

        List<Company> companies = CompanyFiles.readBinaryFilmsFromFile("CompaniesList");

        Scanner sc = new Scanner(System.in);
        Company currentCompany = null;
        while (currentCompany == null) {
            System.out.println("Please select Company");
            companies.forEach(company -> System.out.println("Press  " + companies.indexOf(company) + " to select " + company.getName()));
            int companyIndex = handelNumberFormat(sc);
            boolean validInfoRequested = false;
            try{
                currentCompany = companies.get(companyIndex);}
            catch(IndexOutOfBoundsException e){
                System.out.println("Invalid digit entered! Please enter digit from the list");
                validInfoRequested = true;
            }
            while (!validInfoRequested) {
                validInfoRequested = true;
                System.out.println("Please select airplanes information you would like to know");
                System.out.println("Press 1  to find out total number of people for all planes");
                System.out.println("Press 2  to find out total carrying weight for all planes");
                System.out.println("Press 3  to filter all planes by fuel usage");
                System.out.println("Press 4  to sort planes by max distance");
                System.out.println("Press 0  if you want to change the company");
                int information = handelNumberFormat(sc);
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
                        filterByFuelUsage(sc, currentCompany);
                        break;
                    case 4:
                        currentCompany.sortPlanes(currentCompany.byMaxDistance());
                        System.out.println(currentCompany.getAirplanes());
                        break;
                    default:
                        System.out.println("You have selected incorrect number. Please try again");
                        validInfoRequested = false;
                        break;
                }
                validInfoRequested = continueInquiringInformation(sc, currentCompany, validInfoRequested);
            }
        }
    }

    private static boolean continueInquiringInformation(Scanner sc, Company currentCompany, boolean validInfoRequested) {
        boolean shouldStop = true;
        if (Objects.nonNull(currentCompany) && validInfoRequested) {
            System.out.println("Would you like to continue inquiring information  about this company?[yes/no]");
            String reply = sc.next();
            if (reply.equalsIgnoreCase("yes")) {
                shouldStop = false;
            } else if (!reply.equalsIgnoreCase("no")) {
                System.out.println("You reply was did not match [yes/no]. Program stops.");
            }
        }
        return shouldStop;
    }

    private static void filterByFuelUsage(Scanner sc, Company currentCompany) {
        int min, max;
        boolean validArguments = false;
        while (!validArguments) {
            System.out.println("Please enter min fuel usage");
            min = sc.nextInt();
            System.out.println("Please enter max fuel usage");
            max = sc.nextInt();
            try {
                System.out.println("List of airplanes filtered by fuel usage: " + currentCompany.filterPlanes(currentCompany.byFuelUsage(min, max)));
                validArguments = true;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private static int handelNumberFormat(Scanner sc) {
        int localInt = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                localInt = Integer.parseInt(sc.next());
                isValid = true;
            } catch (NumberFormatException e) {
                LOGGER.info("Your input is invalid. Please enter digit");
            }
        }
        return localInt;
    }


}
