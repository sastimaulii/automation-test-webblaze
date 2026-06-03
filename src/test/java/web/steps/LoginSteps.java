package web.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import web.pages.HomePage;
import web.pages.LoginPage;

public class LoginSteps {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    public LoginSteps() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Given("User is on login page")
    public void openLoginPage() {
        driver.get("https://www.demoblaze.com");
        homePage.openLoginModal();
    }

    @When("User input valid username and password")
    public void loginValid() {
        loginPage.login("sastimaulii", "17ismylife05");
    }

    @When("User input invalid username and password")
    public void loginInvalid() {

        System.out.println("BEFORE LOGIN ACTION");

        loginPage.login("sastimaulii", "wrongpass");

        System.out.println("AFTER LOGIN ACTION");
    }

    @Then("User should be redirected to dashboard")
    public void verifySuccess() {
        Assert.assertTrue(homePage.isUserLoggedIn("sastimaulii"));
    }

    @Then("Error message should be displayed")
    public void verifyError() {

        String alertText = loginPage.getAlertText();

        Assert.assertEquals("Wrong password.", alertText);

        loginPage.acceptAlert();
    }
}