package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage_Factory_BTVN14 {
    private WebDriver driver;
    @FindBy(xpath = "//span[img[contains(@class, 'avatar')]]")
    WebElement adminDropDown;
    @FindBy(xpath = "//a[contains(text(), 'Đăng xuất')]")
    WebElement btnDangXuat;

    public LogoutPage_Factory_BTVN14(WebDriver driverTest) {
        this.driver = driverTest;
        PageFactory.initElements(driver, this);
    }

    public void LogoutFunction() {
        adminDropDown.click();
        btnDangXuat.click();
    }
}
