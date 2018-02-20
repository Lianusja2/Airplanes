package runner;

import org.junit.Before;
import org.junit.Test;
import plane_Owner.Company;
import plane_Owner.CompanyService;
import plane_Owner.CorporationService;
import planes.CargoPlane;
import planes.CivilAircraft;
import planes.CivilAircraftType;
import planes.PassengersPlane;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuTest {
    private Company mau;
    private CorporationService companyService;
    private CivilAircraft cargoPlane, passengerPlane;
    private List<Company> companies;
    private String fileName = "TestCompaniesList";
    private File file = new File(fileName);
    private Menu menu;
    private Scanner sc;

    @Before
    public void preConditions() throws IllegalAccessException {
        companyService = new CompanyService();
        mau = new Company("Mau");
        passengerPlane = new PassengersPlane("TYY-177", 32, 4900.0, CivilAircraftType.COMMERCIAL, 100, 5);
        cargoPlane = new CargoPlane("WWU-YYY", 45.67, 5678.0, CivilAircraftType.COMMERCIAL, 10000, 2);

        mau.addPlane(cargoPlane);
        mau.addPlane(passengerPlane);

        Company lufthansa = new Company("Lufthansa");
        companies = Arrays.asList(mau, lufthansa);
        menu = new Menu(companies);
        sc = mock(Scanner.class);
    }

    @Test
    public void filterByFuelUsageTest() {
        when(sc.next()).thenReturn(String.valueOf(32));
        assertThat(menu.filterByFuelUsage(sc,mau), is(Arrays.asList(passengerPlane)));
    }

    @Test
    public void continueInquiringInformationYesTest() {
        when(sc.next()).thenReturn("yes");
        assertThat(menu.continueInquiringInformation(sc, mau, true), is(false));
    }

    @Test
    public void continueInquiringInformationWhenValidInfoFalseTest() {
      assertThat(menu.continueInquiringInformation(sc, mau, false), is(false));
    }

    @Test
    public void continueInquiringInformationWhenCurrentCompanyNullTest() {
        assertThat(menu.continueInquiringInformation(sc, null, true), is(true));
    }

    @Test
    public void continueInquiringInformationNoTest() {
        when(sc.next()).thenReturn("no");
        assertThat(menu.continueInquiringInformation(sc, mau, true), is(true));
    }

    @Test
    public void handelNumberFormatTest() {
        when(sc.next()).thenReturn("89");
        assertThat(menu.handelNumberFormat(sc), is(89));
    }
}
