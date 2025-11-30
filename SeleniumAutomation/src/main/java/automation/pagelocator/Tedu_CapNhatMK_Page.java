package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Tedu_CapNhatMK_Page {
    private WebDriver driver;
    @FindBy(id = "onesignal-slidedown-allow-button") WebElement btnSubscribe;
    @FindBy(xpath = "//a[@title='Đăng nhập']") WebElement menuLogin;
    @FindBy(id = "UserName")
    WebElement textEmail;

    @FindBy(id = "Password")
    WebElement txtPass;

    @FindBy(xpath = "//button[text()='Đăng nhập']")
    WebElement btnLogin;
    @FindBy(xpath = "//a[@title='Tài khoản' and @data-toggle='dropdown']")
    WebElement avatar;
    @FindBy(xpath = "//a[@title='Đổi mật khẩu']")
    WebElement updatePassword;
    @FindBy(id = "OldPassword") WebElement textOldPass;
    @FindBy(id = "NewPassword") WebElement textNewPass;
    @FindBy(id = "ConfirmNewPassword") WebElement textNewConfirm;
    @FindBy(xpath = "//input[@value='Cập nhật']") WebElement btnUpdate;
    public Tedu_CapNhatMK_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginFunction(String email, String pass) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            btnSubscribe.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            menuLogin.click();
            textEmail.sendKeys(email);
            txtPass.sendKeys(pass);
            btnLogin.click();
            btnSubscribe.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void changePassword(String oldPass, String newPass) {
        avatar.click();
        updatePassword.click();
        textOldPass.sendKeys(oldPass);
        textNewPass.sendKeys(newPass);
        btnUpdate.click();
    }

}
