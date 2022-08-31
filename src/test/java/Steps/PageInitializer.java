package Steps;

import Pages.AddEmployeePage;
import Pages.DashboardPages;
import Pages.LoginPage;

public class PageInitializer {

    public static LoginPage loginPage;
    public static AddEmployeePage ade;
    public static DashboardPages dash;

    public static void initializePageObjects(){
        loginPage = new LoginPage();
        ade = new AddEmployeePage();
        dash = new DashboardPages();
    }



}
