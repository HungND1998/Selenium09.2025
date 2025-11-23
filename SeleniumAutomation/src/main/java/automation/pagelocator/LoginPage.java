package automation.pagelocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginFunction(String email, String pass) {
        WebElement textEmail = driver.findElement(By.id("email"));
        if (textEmail.isDisplayed()) {
            textEmail.sendKeys(email);
        }
        WebElement textPass = driver.findElement(By.id("password"));
        if (textPass.isDisplayed()) {
            textPass.sendKeys(pass);
        }
        driver.findElement(By.name("signin")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
}
