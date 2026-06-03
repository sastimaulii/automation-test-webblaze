package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ======================
    // LOCATORS
    // ======================
    By loginButton = By.id("login2");
    By userLabel = By.id("nameofuser");
    By logoutButton = By.id("logout2");
    By cartButton = By.id("cartur");

    // ======================
    // NAVIGATION
    // ======================
    public void openHomePage() {
        driver.get("https://www.demoblaze.com");
    }

    public void openLoginModal() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
    }

    public void openCartPage() {
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        driver.findElement(cartButton).click();
    }

    // ======================
    // USER STATE
    // ======================
    public boolean isUserLoggedIn(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userLabel));

        return driver.findElement(userLabel)
                .getText()
                .contains(username);
    }

    public boolean isLoggedOut() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        return driver.findElement(loginButton).isDisplayed();
    }

    // ======================
    // PRODUCT
    // ======================
    public void selectProduct(String productName) {
        By product = By.linkText(productName);

        wait.until(ExpectedConditions.elementToBeClickable(product));
        driver.findElement(product).click();
    }

    // ======================
    // LOGOUT
    // ======================
    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
    }
}