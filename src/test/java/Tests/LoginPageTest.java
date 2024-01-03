package Tests;

import base.BaseTest;
import constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void loginPageNaviationTest(){
        loginpage = homePage.navigateToLoginPage();
        String actLoginPageTitle = loginpage.getLoginPageTile();
        System.out.println("Login page act title is : " +actLoginPageTitle);
        Assert.assertEquals(actLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);

    }

    @Test(priority = 2 )
    public void forgotPwdLinkExistTest(){
        loginpage = homePage.navigateToLoginPage();
        Assert.assertTrue(loginpage.iForgotPwdLinkExist());
    }

    @Test(priority = 3)
    public void appLoginTest(){

        Assert.assertTrue(loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));


    }


}
