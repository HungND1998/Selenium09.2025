package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ChangePass_Factory {
    private WebDriver driver;
    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement currentPass;
    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement newPass;
    @FindBy(xpath = "(//input[@type='password'])[3]")
    WebElement confirmNewPass;
    @FindBy(xpath = "//span[normalize-space()='Mật Khẩu']")
    WebElement btnChangePass;
    @FindBy(xpath = "//span[normalize-space()='Đổi mật khẩu']")
    WebElement btnChangePassWord;

    public ChangePass_Factory(WebDriver driverTest) {
        this.driver = driverTest;
        PageFactory.initElements(driver, this);
    }

    public void changePassFuction(String passWord, String newPassWord, String confirmNewPassWord) {
        btnChangePass.click();
        currentPass.sendKeys(passWord);
        newPass.sendKeys(newPassWord);
        confirmNewPass.sendKeys(confirmNewPassWord);
        btnChangePassWord.click();
    }
}
