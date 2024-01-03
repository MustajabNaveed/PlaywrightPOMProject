package Pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;

    private String search = "input[name='search']";
    private String searchIcon = "div#search button";
    private String searchPageHeader = "div#content h1";

    private String loginLink = "a:text('Login')";
    private String myAccountLink = "a[title=\"My Account\"]";


    public HomePage(Page page){
        this.page = page;
    }

    public String getHomePageTile(){
        String title = page.title();
        System.out.println("page Title is: " +title);
        return title;
    }
    public String getHomePageURL(){
        String url = page.url();
        System.out.println("page URL is:" +url);
        return url;
    }

    public String doSearch(String productName){
        page.fill(search,productName);
        page.click(searchIcon);
        String header =  page.textContent(searchPageHeader);
        System.out.println("The Search page header text is: " + header);
        return header;

    }


    public LoginPage navigateToLoginPage(){
        page.click(myAccountLink);
        page.click(loginLink);
        return new LoginPage(page);
    }




}
