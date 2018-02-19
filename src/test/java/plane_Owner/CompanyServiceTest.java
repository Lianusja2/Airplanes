package plane_Owner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import planes.CargoPlane;
import planes.CivilAircraft;
import planes.CivilAircraftType;
import planes.PassengersPlane;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CompanyServiceTest {
    private Company mau;
    private CompanyService companyService;
    private CivilAircraft cargoPlane, passengerPlane;
    private List<Company> companies;
    private String fileName = "TestCompaniesList";
    private File file = new File(fileName);


    @Before
    public void preConditions() throws IllegalAccessException {
        companyService = new CompanyService();
        mau = new Company("Mau");
        passengerPlane = new PassengersPlane("TYY-177", 32.77, 4900.0, CivilAircraftType.COMMERCIAL, 100, 5);
        cargoPlane = new CargoPlane("WWU-YYY", 45.67, 5678.0, CivilAircraftType.COMMERCIAL, 10000, 2);

        mau.addPlane(cargoPlane);
        mau.addPlane(passengerPlane);

        Company lufthansa = new Company("Lufthansa");
        companies = Arrays.asList(mau, lufthansa);
    }

    @Test
    public void getTotalCarryingWeightTest() {
        assertThat(companyService.getTotalCarryingWeight(mau), is(12363.0));
    }

    @Test
    public void getNumberOfPeopleOnBoardTest() {
        assertThat(companyService.getNumberOfPeopleOnBoard(mau), is(107));
    }

    @Test
    public void filterPlanesByFuelUsageTest() {
        assertThat(companyService.filterPlanes(mau, companyService.byFuelUsage(30, 35)), is(Collections.singletonList(passengerPlane)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void byFuelUsageMinMoreThanMaxTest() {
        companyService.byFuelUsage(35, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void byFuelUsageMinLessThanZeroTest() {
        companyService.byFuelUsage(-1, 30);
    }

    @Test
    public void sortPlanesByMaxDistanceTest() {
        companyService.sortPlanes(mau, companyService.byMaxDistance());
        assertThat(mau.getAirplanes(), is(Arrays.asList(passengerPlane, cargoPlane)));
    }

    @Test
    public void writeAndReadBinaryCompaniesIntoFileTest() throws IOException, ClassNotFoundException {
        companyService.writeBinaryCompaniesIntoFile(companies, fileName);
        List<Company> companiesFromFile = companyService.readBinaryCompaniesFromFile(fileName);
        assertThat(companiesFromFile, is(companies));
    }

    @After
    public void postConditions() {
        file.delete();
    }

}
