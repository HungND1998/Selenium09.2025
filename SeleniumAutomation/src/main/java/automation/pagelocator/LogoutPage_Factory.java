package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LogoutPage_Factory {
    private WebDriver driver;
    @FindBy(id = "dropdownMenuLink")
    WebElement adminDropDown;
    @FindBy(xpath = "//button[text()='Đăng xuất' and @type='button']")
    WebElement btnDangXuat;
    @FindBy(xpath = "//button[text()='Đăng xuất' and @type='submit']")
    WebElement btnConfirmDangXuat;

    public LogoutPage_Factory(WebDriver driverTest) {
        this.driver = driverTest;
        PageFactory.initElements(driverTest, this);
    }


    public void LogoutFunction() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        adminDropDown.click();
        btnDangXuat.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        btnConfirmDangXuat.click();
    }
}
