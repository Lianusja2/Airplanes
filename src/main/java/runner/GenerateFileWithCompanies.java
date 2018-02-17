package runner;

import planeOwner.Company;
import planeOwner.CompanyFiles;
import planeOwner.Corporation;
import planes.CargoPlane;
import planes.CivilAircraftType;
import planes.PassengersPlane;

import java.io.IOException;
import java.util.*;

public class GenerateFileWithCompanies {


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
        wizzair.addPlane(new PassengersPlane("VBJ-877",
                57.77,
                6543.9, CivilAircraftType.COMMERCIAL, 250, 8));
        wizzair.addPlane(new PassengersPlane("OMNH-457", 60, 7650.0, CivilAircraftType.COMMERCIAL, 276, 9));
        wizzair.addPlane(new CargoPlane("WWU-YYY", 45.67, 5678.0, CivilAircraftType.COMMERCIAL, 10000, 2));

        List<Company> companies = new ArrayList<>(Arrays.asList(mau, lufthansa, wizzair));

        try {
            CompanyFiles.outputBinaryFilmsIntoFile(companies, "CompaniesList");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
