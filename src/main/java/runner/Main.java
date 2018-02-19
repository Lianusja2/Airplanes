package runner;

import plane_Owner.Company;
import plane_Owner.CompanyService;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, IOException, ClassNotFoundException {
        List<Company> companies =   new CompanyService().readBinaryCompaniesFromFile("CompaniesList");
        Menu menu = new Menu(companies);
        menu.run();
    }


}
