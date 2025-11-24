package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Factory {
    private WebDriver driver;
    @FindBy(id = "email")
    WebElement txtEmail;

    @FindBy(id = "password")
    WebElement txtPass;

    @FindBy(name = "signin")
    WebElement btnDangNhap;

    public LoginPage_Factory(WebDriver driverTest) {
        this.driver = driverTest;
        PageFactory.initElements(driver, this);
    }

    public void loginFunction(String email, String passWord) {
        txtEmail.sendKeys(email);
        txtPass.sendKeys(passWord);
        btnDangNhap.click();
//        driver.switchTo().alert().accept();
    }
}
