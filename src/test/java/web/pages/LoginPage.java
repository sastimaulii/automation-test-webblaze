package web.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locator
    private By username = By.id("loginusername");
    private By password = By.id("loginpassword");

    // FIX: spesifik ke button di modal
    private By loginBtn = By.xpath("//button[text()='Log in' and @onclick='logIn()']");

    // actions
    public void inputUsername(String user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void inputPassword(String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        By loginBtn = By.xpath("//button[text()='Log in']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // pastikan modal sudah benar-benar visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));

        // tunggu tombol benar-benar clickable
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));

        btn.click();
    }

    public void login(String user, String pass) {
        inputUsername(user);
        inputPassword(pass);
        clickLogin();
    }

    // ✅ HANDLE ALERT (PENTING BANGET)
    public String getAlertText() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            System.out.println("ALERT FOUND: " + alert.getText());

            return alert.getText();

        } catch (Exception e) {
            System.out.println("ALERT NOT FOUND - login did NOT trigger");
            throw e;
        }
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
}