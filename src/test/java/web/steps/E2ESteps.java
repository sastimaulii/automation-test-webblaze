package web.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import web.pages.HomePage;
import web.pages.LoginPage;
import web.pages.ProductPage;
import web.pages.CartPage;

import static org.junit.Assert.assertTrue;

public class E2ESteps {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;

    public E2ESteps() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @Given("User is on homepage")
    public void userIsOnHomepage() {
        driver.get("https://www.demoblaze.com");
    }

    @When("User click login button")
    public void userClickLoginButton() {
        homePage.openLoginModal();
    }

    @When("User input valid credentials")
    public void userInputValidCredentials() {
        loginPage.login("sastimaulii", "17ismylife05");
    }

    @When("User input invalid credentials")
    public void userInputInvalidCredentials() {
        loginPage.login("sastimaulii", "wrongpass");
    }

    @Then("User should be logged in")
    public void userShouldBeLoggedIn() {
        assertTrue(homePage.isUserLoggedIn("sastimaulii"));
    }

    @Then("System should show login error")
    public void systemShouldShowLoginError() {
        String alertText = loginPage.getAlertText();
        assertTrue(alertText.contains("Wrong"));
        loginPage.acceptAlert();
    }

    @When("User select product {string}")
    public void userSelectProduct(String product) {
        homePage.selectProduct(product);
    }

    @When("User click Add to cart")
    public void userClickAddToCart() {
        productPage.addToCart();
    }

    @Then("Product should be added to cart")
    public void productShouldBeAddedToCart() {
        assertTrue(productPage.isAddToCartSuccess());
    }

    @When("User go to cart page")
    public void userGoToCartPage() {
        homePage.openCartPage();
    }

    @Then("Product should be displayed in cart")
    public void productShouldBeDisplayedInCart() {
        assertTrue(cartPage.isProductDisplayed());
    }

    @When("User click logout button")
    public void userClickLogoutButton() {
        homePage.clickLogout();
    }

    @Then("User should be logged out")
    public void userShouldBeLoggedOut() {
        assertTrue(homePage.isLoggedOut());
    }
}