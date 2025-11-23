package automation.pagelocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {
    private WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logoutFunction() {
        WebElement dropdown = driver.findElement(By.xpath("//a[normalize-space()='Admin']"));
        dropdown.click();

        WebElement logout = driver.findElement(By.xpath("(//button[text()='Đăng xuất'])[1]"));
        logout.click();

        WebElement confirmButton = driver.findElement(By.xpath("(//button[text()='Đăng xuất'])[2]"));
        confirmButton.click();
    }
}
