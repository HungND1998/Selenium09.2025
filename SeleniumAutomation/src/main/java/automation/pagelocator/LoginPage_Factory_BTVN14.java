package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Factory_BTVN14 {
    private WebDriver driver;
    @FindBy(xpath = "//input[@type='text']")
    WebElement txtEmail;
    @FindBy(xpath = "//input[@type='password']")
    WebElement txtPassWord;
    @FindBy(xpath = "//span[normalize-space()='Đăng nhập']")
    WebElement btnDangNhap;

    public LoginPage_Factory_BTVN14(WebDriver driverTest) {
        this.driver = driverTest;
        PageFactory.initElements(driver, this);
    }

    public void loginFunction(String email, String passWord) {
        txtEmail.sendKeys(email);
        txtPassWord.sendKeys(passWord);
        btnDangNhap.click();
//        driver.switchTo().alert().accept();
    }
}
