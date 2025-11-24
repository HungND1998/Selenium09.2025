package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import automation.pagelocator.LoginPage_Factory_BTVN14;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class BTVN14_Login extends CommonBase {
    @BeforeMethod
    public void openWebPage() {
        driver = initFirefoxDriver(CT_PageURL.VIBLO_URL);
    }

    @Test
    public void loginSuccessfully() {
        LoginPage_Factory_BTVN14 login = new  LoginPage_Factory_BTVN14(driver);
        login.loginFunction("nguyenhung1998na@gmail.com", "12345678");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Trang Chủ']")).isDisplayed());
    }

    @Test
    public void loginFail_IncorrectPass() {
        LoginPage_Factory_BTVN14 loginFail = new LoginPage_Factory_BTVN14(driver);
        loginFail.loginFunction("nguyenhung199na@gmail.com", "12345678_incorrect");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginFail_IncorrectEmail() {
        LoginPage_Factory_BTVN14 loginFail = new LoginPage_Factory_BTVN14(driver);
        loginFail.loginFunction("nguyenhung199na@gmail.com_incorrect", "12345678");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginFail_IncorrectUserNameAndPass() {
        LoginPage_Factory_BTVN14 loginFail = new LoginPage_Factory_BTVN14(driver);
        loginFail.loginFunction("nguyenhung199na@gmail.com_incorrect", "12345678_incorrect");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
