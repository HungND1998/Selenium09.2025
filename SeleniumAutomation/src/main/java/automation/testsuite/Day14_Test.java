package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import automation.pagelocator.LoginPage_Factory;
import automation.pagelocator.LogoutPage_Factory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Day14_Test extends CommonBase {
    @BeforeMethod
    public void openWebPage() {
        driver = initFirefoxDriver(CT_PageURL.CRM_URL);
    }

    @Test
    public void loginSuccessfully() {
        LoginPage_Factory login = new LoginPage_Factory(driver);
        login.loginFunction("admin@gmail.com", "12345678");
        assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
    }

    @Test
    public void logoutSuccessfully() {
        loginSuccessfully();
        LogoutPage_Factory logout = new LogoutPage_Factory(driver);
        logout.LogoutFunction();
        Assert.assertTrue(driver.findElement(By.id("login")).isDisplayed());
    }
}
