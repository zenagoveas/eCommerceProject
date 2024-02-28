package managers;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageObjectManager {
    private WebDriver driver;
    private HomePage homePage;
    private ResultsListPage resultsListPage;
    private ItemDetailsPage itemDetailsPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }


    public ResultsListPage getResultsListPage()
    {
        return (resultsListPage == null) ? resultsListPage = new ResultsListPage(driver) : resultsListPage;
    }

    public ItemDetailsPage getItemDetailsPage()
    {
        return (itemDetailsPage == null) ? itemDetailsPage = new ItemDetailsPage(driver) : itemDetailsPage;
    }
}
