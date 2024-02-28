package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
//import pages.CartPage;

public class CartPageSteps {

    TestContext testContext;
    //CartPage cartPage;

    public CartPageSteps(TestContext context) {
        testContext = context;
        //cartPage = testContext.getPageObjectManager().getCartPage();
    }

    @Then("the user reviews the cart with below list")
    public void theUserReviewsTheCartWithBelowList(DataTable dataTable) {
    }
}
