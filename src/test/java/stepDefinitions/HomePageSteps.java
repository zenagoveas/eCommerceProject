package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.ItemDetailsPage;
import pages.ResultsListPage;

import java.time.Duration;

public class HomePageSteps {

    TestContext testContext;
    Wait<WebDriver> wait;
    HomePage homePage;
    ResultsListPage resultsListPage;
    ItemDetailsPage itemDetailsPage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
        resultsListPage = testContext.getPageObjectManager().getResultsListPage();
        itemDetailsPage = testContext.getPageObjectManager().getItemDetailsPage();
        wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), Duration.ofSeconds(10));
    }

    @When("user searches for item {string}")
    public void userSearchesForItem(String search) {
        testContext.searchedItem = search;
        homePage.enterSearchKey(search);
        homePage.clickSearchButton();
        Assert.assertTrue(resultsListPage.isResultListDisplayed(),"No results displayed");
    }

    @Then("he sees the item is listed on top")
    public void heSeesTheItemIsListedOnTop() {
        Assert.assertTrue(resultsListPage.verifyResultOnTop(testContext.searchedItem));
    }

    @And("he adds the top result to the cart")
    public void heAddsTopResultToTheCart() {
        resultsListPage.clickTopResult();
        testContext.getGenericUtils().switchWindowToChild();
        itemDetailsPage.clickAddToCartButton();
    }

    @Then("he navigates to the home page")
    public void heNavigatesToTheHomePage() {
        homePage.clickLogo();
    }

    @And("he verifies that the item is listed under Your Recently Viewed Items")
    public void heVerifiesThatTheItemIsListedUnderYourRecentlyViewedItems() {
        Assert.assertTrue(homePage.verifyItemIsListedOnRecentlyViewedItems(testContext.searchedItem),
                "Item "+testContext.searchedItem+" is not listed on Your Recently Viewed Items");
    }

    @When("user adds the below list to the cart")
    public void userAddsTheBelowListToTheCart(DataTable dataTable) {
    }
}
