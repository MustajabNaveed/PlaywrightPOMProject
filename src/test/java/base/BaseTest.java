package base;

import Pages.HomePage;
import Pages.LoginPage;
import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf;
    Page page;
    protected Properties prop;
    protected HomePage homePage;
    protected LoginPage loginpage;

    @BeforeTest
    public void setup(){
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        homePage = new HomePage(page);
    }



    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }













}
