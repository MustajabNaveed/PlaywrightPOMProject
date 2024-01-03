package Pages;
import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    //1. String Locators:
    private String emailId = "//input[@id='input-email']";
    private String password = "//input[@id='input-password']";
    private String loginButton = "//input[@value='Login']";
    private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
    private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

    //2. page constructor:
    public LoginPage(Page page){
        this.page = page;
    }

    public String getLoginPageTile(){
        return page.title();
    }

    public boolean iForgotPwdLinkExist(){
        return page.isVisible(forgotPwdLink);
    }

    public boolean doLogin(String appUserName, String appPassword){
        System.out.println("App creds: "+ appUserName +":" + appPassword);
        page.fill(emailId, appUserName);
        page.fill(password, appPassword);
        page.click(loginButton);
        if(page.isVisible(logoutLink)){
            System.out.println("User is logged in Successfully....");
            return true;
        }
        return false;


    }






}


